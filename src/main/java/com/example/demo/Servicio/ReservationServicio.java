/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Reservation;
import com.example.demo.Repositorio.ReservationRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlo
 */
@Service
public class ReservationServicio {
    @Autowired
    private ReservationRepositorio reservationRepositorio;
    
    public List<Reservation> getAll() {
        return reservationRepositorio.getAll();
    }
    
    public Optional<Reservation> getReservation (int reservationId){
        return reservationRepositorio.getReservation(reservationId);
    }
    
    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation() == null) {
            return reservationRepositorio.save(reservation);
        }else {
            Optional<Reservation> e = reservationRepositorio.getReservation(reservation.getIdReservation());
            if (!e.isPresent()) {
                return reservation;
            }else {
                return reservationRepositorio.save(reservation);
            }
        }
    }
}
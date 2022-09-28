/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Client;
import com.example.demo.Repositorio.ClientRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlo
 */
@Service
public class ClientServicio {
    @Autowired
    private ClientRepositorio clientRepositorio;
    
    public List<Client> getAll() {
        return clientRepositorio.getAll();
    }
    
    public Optional<Client> getClient (int clientId){
        return clientRepositorio.getClient(clientId);
    }
    
    public Client save(Client client){
        if (client.getIdClient() == null) {
            return clientRepositorio.save(client);
        }else {
            Optional<Client> e = clientRepositorio.getClient(client.getIdClient());
            if (!e.isPresent()) {
                return client;
            }else {
                return clientRepositorio.save(client);
            }
        }
    }
}


package com.kitsune.kitsune_api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.InformacionRideCliente;
import com.kitsune.kitsune_api.services.impl.ClienteServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("kitsune/cliente")
public class ClienteController{
    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @GetMapping("/mostrarRides")
    public HttpResponse<List<InformacionRideCliente>> mostrarRides(@RequestParam int clienteId) {
        return this.clienteServiceImpl.mostrarRidesCliente(clienteId);
        
    }
    

}

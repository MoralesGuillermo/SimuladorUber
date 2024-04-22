package com.kitsune.kitsune_api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.kitsune.kitsune_api.dto.ClienteDto;
import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.InformacionRideCliente;
import com.kitsune.kitsune_api.dto.InformacionRideClienteParaFront;
import com.kitsune.kitsune_api.dto.PerfilCliente;
import com.kitsune.kitsune_api.entities.Cliente;
import com.kitsune.kitsune_api.services.impl.ClienteServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("kitsune/cliente")
public class ClienteController{

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @GetMapping("/ver-perfil/{clienteId}")
    public HttpResponse<PerfilCliente> verPerfil(@PathVariable int clienteId) {
        return this.clienteServiceImpl.verPerfil(clienteId);
    }
    

    @GetMapping("/mostrarRidesParaFront/{clienteId}")
    public HttpResponse<List<InformacionRideClienteParaFront>> mostrarRidesParaFront(@PathVariable int clienteId) {
        return this.clienteServiceImpl.mostrarRidesClienteParaFront(clienteId);
    }
    
    @PostMapping("/crear")
    public HttpResponse<Cliente> crearCliente(@RequestBody ClienteDto clienteDto) {
        return this.clienteServiceImpl.crearCliente(clienteDto);
    }
    
    @GetMapping("/perfil")
    public HttpResponse<PerfilCliente> verPerfil2(@RequestParam int clienteId) {
        return this.clienteServiceImpl.verPerfil(clienteId);
    }
        
    @GetMapping("/test")
    public String testAPI() {
        return "Se realizo la conexion de manera exitosa";
    }

    
    }
    



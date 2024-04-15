package com.kitsune.kitsune_api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.InformacionRide;
import com.kitsune.kitsune_api.dto.PerfilCliente;
import com.kitsune.kitsune_api.dto.PerfilPersona;
import com.kitsune.kitsune_api.entities.Cliente;
import com.kitsune.kitsune_api.entities.Persona;
import com.kitsune.kitsune_api.repositories.ClienteRepository;
import com.kitsune.kitsune_api.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public HttpResponse<PerfilCliente> verPerfil(int clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).get();
        HttpResponse<PerfilCliente> response = new HttpResponse<>();
        if (cliente == null){
            response.setStatus((short)404);
            return response;
        }
        PerfilCliente perfilCliente = new PerfilCliente();
        PerfilPersona perfilPersona = new PerfilPersona();
        Persona personaCliente = cliente.getPersona();
        
        perfilPersona.setDni(personaCliente.getDni());
        perfilPersona.setNombre(personaCliente.getNombre());
        perfilPersona.setApellido(personaCliente.getApellido());
        perfilPersona.setEmail(personaCliente.getEmail());
        perfilPersona.setTelefono(personaCliente.getTelefono());
        
        perfilCliente.setPerfilPersona(perfilPersona); 
        perfilCliente.setUsername(cliente.getUsuario().getUsername());
        
        response.setStatus((short) 200);
        response.setResponseBody(perfilCliente);
        return response;
    }

    @Override
    public HttpResponse<List<InformacionRide>> mostrarRidesCliente(int clienteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarRidesCliente'");
    }
}

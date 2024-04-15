package com.kitsune.kitsune_api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitsune.kitsune_api.dto.ClienteDto;
import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.InformacionRide;
import com.kitsune.kitsune_api.dto.PerfilCliente;
import com.kitsune.kitsune_api.entities.Cliente;
import com.kitsune.kitsune_api.repositories.ClienteRepository;
import com.kitsune.kitsune_api.repositories.PersonaRepository;
import com.kitsune.kitsune_api.repositories.UsuarioRepository;
import com.kitsune.kitsune_api.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public HttpResponse<Cliente> crearCliente(ClienteDto clienteDto){
        HttpResponse<Cliente> response = new HttpResponse<>();
        if (isIncomplete(clienteDto)){   // Los datos no se enviaron completos
            response.setStatus((short)400);
        }
        else if (personaAlreadyExists(clienteDto) || usuarioAlreadyExists(clienteDto)){ // Se usó un dni o un usuario ya existente
            response.setStatus((short) 406);
        }else{
            Cliente savedCliente = saveCliente(clienteDto);
            response.setStatus((short) 200);
            response.setResponseBody(savedCliente);
        }
        return response;
    }

    private boolean isIncomplete(ClienteDto clienteDto){
        return (clienteDto == null || clienteDto.getPersona() == null || clienteDto.getUsuario() == null);
    } 

    private boolean personaAlreadyExists(ClienteDto clienteDto){
        return personaRepository.existsById(clienteDto.getPersona().getDni());
    }

    private boolean usuarioAlreadyExists(ClienteDto clienteDto){
        return (usuarioRepository.getByUsername(clienteDto.getUsuario().getUsername()) != null);
    }

    private Cliente saveCliente(ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        cliente.setPersona(clienteDto.getPersona());
        cliente.setUsuario(clienteDto.getUsuario());
        return clienteRepository.save(cliente);
    }

    @Override
    public HttpResponse<PerfilCliente> verPerfil(int clienteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verPerfil'");
    }

    @Override
    public HttpResponse<List<InformacionRide>> mostrarRidesCliente(int clienteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarRidesCliente'");
    }  
}

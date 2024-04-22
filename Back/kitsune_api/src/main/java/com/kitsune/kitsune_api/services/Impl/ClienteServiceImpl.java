package com.kitsune.kitsune_api.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitsune.kitsune_api.dto.ClienteDto;
import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.InformacionRideCliente;
import com.kitsune.kitsune_api.dto.PerfilCliente;
import com.kitsune.kitsune_api.dto.PerfilPersona;
import com.kitsune.kitsune_api.entities.Cliente;
import com.kitsune.kitsune_api.entities.Persona;
import com.kitsune.kitsune_api.entities.Rides;
import com.kitsune.kitsune_api.entities.Usuario;
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
        }else {
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
        HttpResponse<PerfilCliente> response = new HttpResponse<>();
        if (clienteRepository.existsById(clienteId)){
            Cliente cliente = clienteRepository.findById(clienteId).get();
            
            PerfilCliente perfilCliente = new PerfilCliente();
            PerfilPersona perfilPersona = new PerfilPersona();
            Usuario usuarioCLiente = cliente.getUsuario();
            Persona personaCliente = cliente.getPersona();
            
            perfilPersona.setDni(personaCliente.getDni());
            perfilPersona.setNombre(personaCliente.getNombre());
            perfilPersona.setApellido(personaCliente.getApellido());
            perfilPersona.setEmail(personaCliente.getEmail());
            perfilPersona.setTelefono(personaCliente.getTelefono());
            perfilPersona.setEdad(personaCliente.getEdad());
            perfilPersona.setGenero(personaCliente.getGenero());
            perfilCliente.setPerfilPersona(perfilPersona); 
            perfilCliente.setUsername(cliente.getUsuario().getUsername());
            perfilCliente.setEstatus(usuarioCLiente.getEstatus());
            response.setStatus((short) 200);
            response.setResponseBody(perfilCliente);
            return response;
        }
            response.setStatus((short)404);
            return response;
    }

    @Override
    public HttpResponse<List<InformacionRideCliente>> mostrarRidesCliente(int clienteId) {
        HttpResponse<List<InformacionRideCliente>> response = new HttpResponse<>();
        //Si existe el cliente:
        if (this.clienteRepository.existsById(clienteId)){
            Cliente cliente = this.clienteRepository.findById(clienteId).get();
            //Si cliente tiene rides
                if (null != cliente.getRides()) {
                    Persona persona = cliente.getPersona();
                    List<Rides> listaRides = cliente.getRides();
                    

                    List<InformacionRideCliente> listaInformacionRides = new ArrayList<>();
                    PerfilPersona perfilPersona = new PerfilPersona();
                    PerfilCliente perfilCliente = new PerfilCliente();

                    perfilPersona.setApellido(persona.getApellido());
                    perfilPersona.setDni(persona.getDni());
                    perfilPersona.setEmail(persona.getEmail());
                    perfilPersona.setNombre(persona.getNombre());
                    perfilPersona.setTelefono(persona.getTelefono());
                    perfilCliente.setPerfilPersona(perfilPersona);
                    perfilCliente.setUsername(cliente.getUsuario().getUsername());
                    for (Rides ride: listaRides) {
                        InformacionRideCliente informacionRideCliente = new InformacionRideCliente();
                        informacionRideCliente.setCalificacion(ride.getCalificacion());
                        informacionRideCliente.setPerfilCliente(perfilCliente);
                        informacionRideCliente.setDestinoRide(ride.getDireccionDestino());
                        informacionRideCliente.setFechaRide(ride.getFecha());
                        informacionRideCliente.setOrigenRide(ride.getDireccionOrigen());
                        informacionRideCliente.setPrecioRide(ride.getCosto());
                        listaInformacionRides.add(informacionRideCliente);


                        /*InformacionRideCliente informacionRideCliente = new InformacionRideCliente();
                        listaInformacionRides.get(i).setCalificacion(listaRides.get(i).getCalificacion());
                        listaInformacionRides.get(i).setPerfilCliente(perfilCliente);
                        listaInformacionRides.get(i).setDestinoRide(listaRides.get(i).getDireccionDestino());
                        listaInformacionRides.get(i).setFechaRide(listaRides.get(i).getFecha());
                        listaInformacionRides.get(i).setOrigenRide(listaRides.get(i).getDireccionOrigen());
                        listaInformacionRides.get(i).setPrecioRide(listaRides.get(i).getCosto());
                        listaInformacionRides.add(informacionRideCliente);
                         */
                    }
                    response.setResponseBody(listaInformacionRides);
                    response.setStatus((short)200);
                    return response;
                }
                //Si cliente no tiene rides
                else{
                    response.setStatus((short)404);
                    return response;
                }
        }
        //Si no existe el cliente
        else{
            response.setStatus((short)400);
            return response;
        }
    }
}



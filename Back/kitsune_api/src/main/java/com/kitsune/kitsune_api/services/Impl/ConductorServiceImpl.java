package com.kitsune.kitsune_api.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.InformacionRide;
import com.kitsune.kitsune_api.dto.NuevoConductorDto;
import com.kitsune.kitsune_api.dto.PerfilConductor;
import com.kitsune.kitsune_api.dto.VehiculoDto;
import com.kitsune.kitsune_api.entities.Conductor;
import com.kitsune.kitsune_api.entities.ConductorVehiculos;
import com.kitsune.kitsune_api.entities.Persona;
import com.kitsune.kitsune_api.entities.Usuario;
import com.kitsune.kitsune_api.entities.Vehiculo;
import com.kitsune.kitsune_api.entities.compisite_keys.ConductorVehiculoKey;
import com.kitsune.kitsune_api.repositories.ConductorRepository;
import com.kitsune.kitsune_api.repositories.ConductorVehiculosRepository;
import com.kitsune.kitsune_api.repositories.PersonaRepository;
import com.kitsune.kitsune_api.repositories.UsuarioRepository;
import com.kitsune.kitsune_api.repositories.VehiculoRepository;
import com.kitsune.kitsune_api.services.ConductorService;

@Service
public class ConductorServiceImpl implements ConductorService{
    
    @Autowired
    ConductorRepository conductorRepository;

    @Autowired
    VehiculoRepository vehiculoRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ConductorVehiculosRepository conductorVehiculosRepository;

    @Override
    public HttpResponse<Conductor> crearConductor(NuevoConductorDto nuevoConductor){
        Vehiculo vehiculoNuevoConductor = nuevoConductor.getVehiculo();
        Persona personaNuevoConductor = nuevoConductor.getPersona();
        Usuario usuarioNuevoConductor = nuevoConductor.getUsuario();
        HttpResponse<Conductor> response = new HttpResponse<>();
        if (vehiculoAlreadyExists(vehiculoNuevoConductor)|| personaAlreadyExists(personaNuevoConductor) || usuarioAlreadyExists(usuarioNuevoConductor) ){
            response.setStatus((short) 406);
            return response;
        }
        Conductor conductor = new Conductor();
        conductor.setPersona(personaNuevoConductor);
        conductor.setDisponible(true);
        conductor.setRating(0);
        conductor.setUsuario(usuarioNuevoConductor);

        Vehiculo savedVehiculo = vehiculoRepository.save(vehiculoNuevoConductor);
        Conductor savedConductor = conductorRepository.save(conductor);

        ConductorVehiculoKey conductorVehiculoKey = new ConductorVehiculoKey();
        conductorVehiculoKey.setConductorId(savedConductor.getConductorId());
        conductorVehiculoKey.setVehiculoVin(savedVehiculo.getVin());

        ConductorVehiculos conductorVehiculosNuevo = new ConductorVehiculos();
        conductorVehiculosNuevo.setConductorVehiculoKey(conductorVehiculoKey);
        conductorVehiculosNuevo.setFechaInicioOperacion(LocalDate.now());
        conductorVehiculosNuevo.setEstatus('A');
        conductorVehiculosNuevo.setVehiculo(vehiculoNuevoConductor);
        conductorVehiculosNuevo.setConductor(conductor);
        conductorVehiculosRepository.save(conductorVehiculosNuevo);

        response.setStatus((short) 200);
        response.setResponseBody(savedConductor);
        return response;
    }

    private boolean vehiculoAlreadyExists(Vehiculo vehiculo){
        return vehiculoRepository.existsById(vehiculo.getVin());
    }

    private boolean personaAlreadyExists(Persona persona){
        return personaRepository.existsById(persona.getDni());
    }

    private boolean usuarioAlreadyExists(Usuario user){
        return usuarioRepository.getByUsername(user.getUsername()) != null;
    }

    @Override
    public HttpResponse<PerfilConductor> verPerfil(int conductorId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verPerfil'");
    }

    @Override
    public HttpResponse<String> cambiarVehiculo(int conductorId, VehiculoDto vehiculoDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarVehiculo'");
    }

    @Override
    public HttpResponse<List<InformacionRide>> obtenerRidesConductor(int conductorId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerRidesConductor'");
    }


    
}

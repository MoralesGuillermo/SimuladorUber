package com.kitsune.kitsune_api.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.InformacionRide;
import com.kitsune.kitsune_api.dto.NuevoConductorDto;
import com.kitsune.kitsune_api.dto.PerfilConductor;
import com.kitsune.kitsune_api.dto.PerfilPersona;
import com.kitsune.kitsune_api.entities.Conductor;
import com.kitsune.kitsune_api.entities.ConductorVehiculos;
import com.kitsune.kitsune_api.entities.Persona;
import com.kitsune.kitsune_api.entities.Vehiculo;
import com.kitsune.kitsune_api.repositories.ConductorRepository;
import com.kitsune.kitsune_api.entities.Usuario;
import com.kitsune.kitsune_api.entities.compisite_keys.ConductorVehiculoKey;
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
        HttpResponse<PerfilConductor> response = new HttpResponse<>();
            if (this.conductorRepository.existsById(conductorId)) {
            Conductor conductor = conductorRepository.findById(conductorId).get();
            
            List<ConductorVehiculos> conductorVehiculos = conductor.getConductorVehiculos();
            char estado = 'A';
                for (ConductorVehiculos conductorVehiculo: conductorVehiculos) {
                    if (estado == conductorVehiculo.getEstatus() && conductorId == conductorVehiculo.getConductorVehiculoKey().getConductorId()) {
                        String vinVehiculo = conductorVehiculo.getConductorVehiculoKey().getVehiculoVin();
                        Vehiculo vehiculo = this.vehiculoRepository.findById(vinVehiculo).get();

                        PerfilConductor perfilConductor = new PerfilConductor();
                        PerfilPersona perfilPersona = new PerfilPersona();
                        Persona personaConductor = conductor.getPersona();

                        perfilPersona.setDni(personaConductor.getDni());
                        perfilPersona.setNombre(personaConductor.getNombre());
                        perfilPersona.setApellido(personaConductor.getApellido());
                        perfilPersona.setEmail(personaConductor.getEmail());
                        perfilPersona.setTelefono(personaConductor.getTelefono());
                
                        perfilConductor.setPerfilPersona(perfilPersona);
                        perfilConductor.setMarcaVehiculo(vehiculo.getMarcavehiculo().getDescripcion());
                        perfilConductor.setColorVehiculo(vehiculo.getColor());
                        perfilConductor.setPlacaVehiculo(vehiculo.getPlacas());
                        perfilConductor.setRating(conductor.getRating());

                        response.setStatus((short) 200);
                        response.setResponseBody(perfilConductor);
                        return response;
                    }
                response.setStatus((short) 404);
                return response;
                }
            }
        response.setStatus((short) 404);
        return response;
    }

    @Override
    public HttpResponse<String> cambiarVehiculo(int conductorId, Vehiculo vehiculo) {
        HttpResponse<String> response = new HttpResponse<>();
        if (this.conductorRepository.existsById(conductorId)) {
            Conductor conductor = this.conductorRepository.findById(conductorId).get();
            List<ConductorVehiculos> conductorVehiculos = conductor.getConductorVehiculos();
            char estado = 'A';

            for (ConductorVehiculos conductorVehiculo: conductorVehiculos) {
                if (conductorVehiculo.getEstatus() == estado) {
                    conductorVehiculo.setEstatus('I');

                    this.conductorVehiculosRepository.save(conductorVehiculo);
                }
            }

            String vin = vehiculo.getVin();
            if (this.vehiculoRepository.existsById(vin)) {
                Vehiculo vehiculoAsignar = this.vehiculoRepository.findById(vin).get();
                List<ConductorVehiculos> conductorVehiculoAsignar = vehiculoAsignar.getConductorVehiculos();
                
                for (ConductorVehiculos conductorVehiculosAsig : conductorVehiculoAsignar) {
                    if (conductorVehiculosAsig.getConductorVehiculoKey().getConductorId() == conductorId && conductorVehiculosAsig.getConductorVehiculoKey().getVehiculoVin() == vin) {
                        conductorVehiculosAsig.setEstatus('A');;

                        this.conductorVehiculosRepository.save(conductorVehiculosAsig);

                        //VehiculoDto vehiculoDto = new VehiculoDto();

                        //vehiculoDto.setVin(vehiculo.getVin());
                        //vehiculoDto.setPlacas(vehiculo.getPlacas());
                        //vehiculoDto.setColor(vehiculo.getColor());
                        //vehiculoDto.setMarcavehiculo(vehiculo.getMarcavehiculo());

                        response.setStatus((short) 200);
                        response.setResponseBody("Vehiculo cambiado con exito");
                        return response;
                    }
                }
            }
            response.setStatus((short) 404);
            return response;

        }
        response.setStatus((short) 404);
        return response;
    }

    @Override
    public HttpResponse<List<InformacionRide>> obtenerRidesConductor(int conductorId) {
        HttpResponse<List<InformacionRide>> response = new HttpResponse<>();      

        if (this.conductorRepository.existsById(conductorId)) {
           Conductor conductor = this.conductorRepository.findById(conductorId).get();
           List<ConductorVehiculos> listaRides = new  ArrayList<>();
                listaRides = conductor.getConductorVehiculos();
        List<InformacionRide> informacionRides = new  ArrayList<>();
        PerfilConductor perfilConductor = new PerfilConductor();
        PerfilPersona perfilPersona = new PerfilPersona();
        perfilPersona.setDni(conductor.getPersona().getDni());
        perfilPersona.setNombre(conductor.getPersona().getNombre());
        perfilPersona.setApellido(conductor.getPersona().getApellido());
        perfilPersona.setEmail(conductor.getPersona().getEmail());
        perfilPersona.setTelefono(conductor.getPersona().getTelefono());
        perfilConductor.setPerfilPersona(perfilPersona);
        perfilConductor.setRating(conductor.getRating());
    
          for (int i = 0; i < listaRides.size(); i++) {
            InformacionRide informacionRide = new InformacionRide();
            perfilConductor.setMarcaVehiculo(listaRides.get(i).getVehiculo().getMarcavehiculo().getMarcaId());
            perfilConductor.setColorVehiculo(listaRides.get(i).getVehiculo().getColor());
            perfilConductor.setPlacaVehiculo(listaRides.get(i).getVehiculo().getPlacas());
            informacionRide.setPerfilConductor(perfilConductor);
            informacionRide.setFechaRide( conductor.getRides().get(i).getFecha());
            informacionRide.setOrigenRide(conductor.getRides().get(i).getDireccionOrigen());
            informacionRide.setDestinoRide(conductor.getRides().get(i).getDireccionDestino());
            informacionRide.setPrecioRide(conductor.getRides().get(i).getCosto());
            informacionRide.setCalificacion(conductor.getRides().get(i).getCalificacion());
            informacionRides.add(informacionRide);
          }
           response.setStatus((short) 200);
           response.setResponseBody(informacionRides);
           return response;
        }else{

            response.setStatus((short) 404);
            return null;
        }
        
    }


    
}

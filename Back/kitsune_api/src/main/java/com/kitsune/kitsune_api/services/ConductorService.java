package com.kitsune.kitsune_api.services;

import java.util.List;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.InformacionRide;
import com.kitsune.kitsune_api.dto.NuevoConductorDto;
import com.kitsune.kitsune_api.dto.PerfilConductor;
import com.kitsune.kitsune_api.entities.Vehiculo;
import com.kitsune.kitsune_api.dto.VehiculoDto;
import com.kitsune.kitsune_api.entities.Conductor;


public interface ConductorService {

    public HttpResponse<Conductor> crearConductor(NuevoConductorDto nuevoConductor);

    public HttpResponse<PerfilConductor> verPerfil(int conductorId);

    public HttpResponse<String> cambiarVehiculo(int conductorId, Vehiculo vehiculo);

    public  HttpResponse<List<InformacionRide>> obtenerRidesConductor(int conductorId);
}

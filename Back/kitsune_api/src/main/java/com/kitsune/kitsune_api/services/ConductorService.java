package com.kitsune.kitsune_api.services;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.PerfilConductor;
import com.kitsune.kitsune_api.dto.VehiculoDto;


public interface ConductorService {

    public HttpResponse<PerfilConductor> verPerfil(int conductorId);

    public HttpResponse<String> cambiarVehiculo(int conductorId, VehiculoDto vehiculoDto);
}

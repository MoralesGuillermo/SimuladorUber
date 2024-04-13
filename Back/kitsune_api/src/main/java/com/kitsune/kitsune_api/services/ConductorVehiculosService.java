package com.kitsune.kitsune_api.services;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.entities.ConductorVehiculos;

public interface ConductorVehiculosService {
    
    public HttpResponse<ConductorVehiculos> cambiarVehiculoConductor(int conductorId, String vehiculoVin);

}

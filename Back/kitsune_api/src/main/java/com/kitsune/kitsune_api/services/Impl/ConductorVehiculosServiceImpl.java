package com.kitsune.kitsune_api.services.impl;

import org.springframework.stereotype.Service;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.entities.ConductorVehiculos;
import com.kitsune.kitsune_api.services.ConductorVehiculosService;

@Service
public class ConductorVehiculosServiceImpl implements ConductorVehiculosService{

    @Override
    public HttpResponse<ConductorVehiculos> cambiarVehiculoConductor(int conductorId, String vehiculoVin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarVehiculoConductor'");
    }
    
}

package com.kitsune.kitsune_api.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.InformacionRide;
import com.kitsune.kitsune_api.dto.PerfilConductor;
import com.kitsune.kitsune_api.dto.VehiculoDto;
import com.kitsune.kitsune_api.services.ConductorService;

@Service
public class ConductorServiceImpl implements ConductorService{

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

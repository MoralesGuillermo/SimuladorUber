package com.kitsune.kitsune_api.services.impl;

import org.springframework.stereotype.Service;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.VehiculoDto;
import com.kitsune.kitsune_api.entities.Vehiculo;
import com.kitsune.kitsune_api.services.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoService{

    @Override
    public HttpResponse<Vehiculo> crearVehiculo(VehiculoDto vehiculo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearVehiculo'");
    }
    
}

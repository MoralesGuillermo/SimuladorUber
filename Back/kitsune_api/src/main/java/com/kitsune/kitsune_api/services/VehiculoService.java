package com.kitsune.kitsune_api.services;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.VehiculoDto;
import com.kitsune.kitsune_api.entities.Vehiculo;

public interface VehiculoService {
    
    public  HttpResponse<Vehiculo> crearVehiculo(VehiculoDto vehiculo);
}

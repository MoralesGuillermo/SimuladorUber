package com.kitsune.kitsune_api.services;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.VehiculoDto;
import com.kitsune.kitsune_api.entities.Vehiculo;

public class VehiculoService {
    
    public  HttpResponse<Vehiculo> nuevoVehiculo(Vehiculo vehiculo);

}

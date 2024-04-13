package com.kitsune.kitsune_api.services;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.entities.Direcciones;

public interface DireccionesService {
    
    public  HttpResponse<Direcciones> nuevaDireccion(Direcciones direccion);

    
}

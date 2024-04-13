package com.kitsune.kitsune_api.services;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.entities.Tarjetas;

public interface TarjetasService {
    
    public  HttpResponse<Tarjetas> nuevaTarjeta(Tarjetas tarjeta);

    public  HttpResponse<String> eliminarTarjeta(String pan);
}

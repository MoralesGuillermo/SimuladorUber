package com.kitsune.kitsune_api.services;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.TarjetasDTO;
import com.kitsune.kitsune_api.entities.Tarjetas;

public interface TarjetasService {
    
    public  HttpResponse<TarjetasDTO> nuevaTarjeta(Tarjetas tarjeta, int clienteId);

    public  HttpResponse<String> eliminarTarjeta(String pan);
}

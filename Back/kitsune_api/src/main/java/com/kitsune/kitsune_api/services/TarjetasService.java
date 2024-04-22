package com.kitsune.kitsune_api.services;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.TarjetasDTO;


public interface TarjetasService {
    
    public  HttpResponse<TarjetasDTO> nuevaTarjeta(TarjetasDTO tarjetasDTO);

    public  HttpResponse<String> eliminarTarjeta(String pan);

    
}

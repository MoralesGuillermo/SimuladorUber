package com.kitsune.kitsune_api.services.Impl;

import org.springframework.stereotype.Service;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.entities.Tarjetas;
import com.kitsune.kitsune_api.services.TarjetasService;

@Service
public class TarjetasServiceImpl implements TarjetasService{

    @Override
    public HttpResponse<Tarjetas> nuevaTarjeta(Tarjetas tarjeta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nuevaTarjeta'");
    }

    @Override
    public HttpResponse<String> eliminarTarjeta(String pan) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarTarjeta'");
    }
    
    
}

package com.kitsune.kitsune_api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.entities.Tarjetas;
import com.kitsune.kitsune_api.repositories.TarjetasRepository;
import com.kitsune.kitsune_api.services.TarjetasService;

@Service
public class TarjetasServiceImpl implements TarjetasService{

    @Autowired
    private TarjetasRepository tarjetasRepository;

    @Override
    public HttpResponse<Tarjetas> nuevaTarjeta(Tarjetas tarjeta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nuevaTarjeta'");
    }

    @Override
    public HttpResponse<String> eliminarTarjeta(String pan) {
        HttpResponse<String> response = new HttpResponse<>();
        if (null!=pan) {
            if (null!=this.tarjetasRepository.findById(pan)) {
                Tarjetas tarjeta = this.tarjetasRepository.findById(pan).get();
                this.tarjetasRepository.delete(tarjeta);
                response.setStatus((short) 200);
                return response;
            }
            response.setStatus((short) 404);
            return response;
        }
        response.setStatus((short) 204);
        return response;
    }
    
    
}

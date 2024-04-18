package com.kitsune.kitsune_api.services.impl;

import org.springframework.stereotype.Service;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.entities.Rides;
import com.kitsune.kitsune_api.services.RidesService;

@Service
public class RidesServiceImpl implements RidesService{


    @Override
    public HttpResponse<Rides> nuevoRide(Rides ride) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nuevoRide'");
    }

    @Override
    public HttpResponse<String> cancelarRide(int rideId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelarRide'");
    }

    @Override
    public HttpResponse<String> calificarRide(int rideId, int calificaion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calificarRide'");
    }

    @Override
    public HttpResponse<Rides> solicitarRide(Rides ride) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solicitarRide'");
    }
    
}

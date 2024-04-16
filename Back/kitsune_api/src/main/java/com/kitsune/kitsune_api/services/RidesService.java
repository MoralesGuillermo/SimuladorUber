package com.kitsune.kitsune_api.services;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.RideDto;
import com.kitsune.kitsune_api.entities.Rides;

public interface RidesService {

    public HttpResponse<RideDto> solicitarRide(RideDto ride);

    public HttpResponse<Rides> nuevoRide(RideDto ride);

    public HttpResponse<String> cancelarRide(int rideId);

    public HttpResponse<String> calificarRide(int rideId, int calificacion);

    
}

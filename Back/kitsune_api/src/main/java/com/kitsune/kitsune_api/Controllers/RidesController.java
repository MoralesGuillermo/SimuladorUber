package com.kitsune.kitsune_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.RideDto;
import com.kitsune.kitsune_api.entities.Rides;
import com.kitsune.kitsune_api.services.impl.RidesServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("kitsune")
public class RidesController {
    
@Autowired
private RidesServiceImpl ridesServiceImpl;

    @PostMapping("/ride/solicitar")
    public HttpResponse<RideDto> solicitarRide(@RequestBody RideDto ride) {
        return this.ridesServiceImpl.solicitarRide(ride);
    }

    @PostMapping("/ride/nuevo")
    public HttpResponse<Rides> nuevoRide(@RequestBody RideDto ride) {
        return this.ridesServiceImpl.nuevoRide(ride);
    }

    @DeleteMapping("/ride/cancelar/{rideId}")
    public HttpResponse<String> cancelarRide(@PathVariable int rideId) {
        return this.ridesServiceImpl.cancelarRide(rideId);
    }

    @PutMapping("/ride/calificar/{rideId}")
    public HttpResponse<String> calificarRide(@PathVariable int rideId, @RequestParam int calificacion) {
        return this.ridesServiceImpl.calificarRide(rideId, calificacion);
    }
    
}

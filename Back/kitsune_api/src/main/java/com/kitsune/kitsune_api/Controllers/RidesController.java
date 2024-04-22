package com.kitsune.kitsune_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.RideDto;
import com.kitsune.kitsune_api.entities.Rides;
import com.kitsune.kitsune_api.services.impl.RidesServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("kitsune/ride")
public class RidesController {
    
@Autowired
private RidesServiceImpl ridesServiceImpl;

    @PostMapping("/solicitar")
    public HttpResponse<RideDto> solicitarRide(@RequestBody RideDto ride) {
        System.out.println(ride);
        return this.ridesServiceImpl.solicitarRide(ride);
    }

    @PostMapping("/nuevo")
    public HttpResponse<Rides> nuevoRide(@RequestBody RideDto ride) {
        return this.ridesServiceImpl.nuevoRide(ride);
    }

    @PutMapping("/cancelar/{rideId}")
    public HttpResponse<String> cancelarRide(@PathVariable int rideId) {
        return this.ridesServiceImpl.cancelarRide(rideId);
    }

    @PutMapping("/calificar/{rideId}")
    public HttpResponse<String> calificarRide(@PathVariable int rideId, @RequestParam int calificacion) {
        return this.ridesServiceImpl.calificarRide(rideId, calificacion);
    }
    
    @PutMapping("/finalizado/{rideId}")
    public HttpResponse<String> finalizarRide(@PathVariable int rideId) {
        return this.ridesServiceImpl.finalizarRide(rideId);
    }

    @GetMapping("/solicitar-precio/{distancia}")
    public HttpResponse<Double> solicitarPrecio(@PathVariable float distancia) {
        return this.ridesServiceImpl.solicitarPrecio(distancia);
    }
    

}

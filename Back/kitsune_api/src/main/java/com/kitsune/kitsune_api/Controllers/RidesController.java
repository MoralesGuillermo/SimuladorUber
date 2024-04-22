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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("kitsune/ride")
public class RidesController {
    
@Autowired
private RidesServiceImpl ridesServiceImpl;

    @PostMapping("/solicitar")
    @Operation(summary = "Solicita un ride.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ride solicitado correctamente.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RideDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Solicitud de ride incompleta."),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado.") })
    public HttpResponse<RideDto> solicitarRide(@RequestBody RideDto ride) {
        System.out.println(ride);
        return this.ridesServiceImpl.solicitarRide(ride);
    }

    @PostMapping("/nuevo")
    @Operation(summary = "Crea un nuevo ride.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ride creado correctamente.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Rides.class)) }),
            @ApiResponse(responseCode = "400", description = "Solicitud de ride incompleta."),
            @ApiResponse(responseCode = "404", description = "Cliente o conductor no encontrado.") })
    public HttpResponse<Rides> nuevoRide(@RequestBody RideDto ride) {
        return this.ridesServiceImpl.nuevoRide(ride);
    }

    @PutMapping("/cancelar/{rideId}")
    @Operation(summary = "Cancela un ride.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ride cancelado correctamente."),
            @ApiResponse(responseCode = "404", description = "Ride no encontrado.") })
    public HttpResponse<String> cancelarRide(@PathVariable int rideId) {
        return this.ridesServiceImpl.cancelarRide(rideId);
    }

    @PutMapping("/calificar/{rideId}")
    @Operation(summary = "Califica un ride.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ride calificado correctamente."),
            @ApiResponse(responseCode = "404", description = "Ride no encontrado.") })
    public HttpResponse<String> calificarRide(@PathVariable int rideId, @RequestParam int calificacion) {
        return this.ridesServiceImpl.calificarRide(rideId, calificacion);
    }
    
    @PutMapping("/finalizado/{rideId}")
    @Operation(summary = "Finaliza un ride.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ride finalizado correctamente."),
            @ApiResponse(responseCode = "404", description = "Ride no encontrado.") })
    public HttpResponse<String> finalizarRide(@PathVariable int rideId) {
        return this.ridesServiceImpl.finalizarRide(rideId);
    }

    @GetMapping("/solicitar-precio/{distancia}")
    @Operation(summary = "Solicita el precio de un ride en función de la distancia.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Precio solicitado correctamente.") })
    public HttpResponse<Double> solicitarPrecio(@PathVariable float distancia) {
        return this.ridesServiceImpl.solicitarPrecio(distancia);
    }

    @GetMapping("/preguntar-aceptado/{rideId}")
    @Operation(summary = "Verifica si un ride ha sido aceptado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El ride ha sido aceptado."),
            @ApiResponse(responseCode = "400", description = "El ride no ha sido aceptado o no encontrado.") })
    public HttpResponse<Boolean> getMethodName(@PathVariable int rideId) {
        return this.ridesServiceImpl.fueAceptado(rideId);
    }
    
    

}

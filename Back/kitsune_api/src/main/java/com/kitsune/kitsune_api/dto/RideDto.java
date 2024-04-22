package com.kitsune.kitsune_api.dto;

import com.kitsune.kitsune_api.entities.Direcciones;

import lombok.Data;


@Data
public class RideDto {
    
    private int rideId;

    private double distancia;

    private double costo;

    private int clienteid;

    private int conductorId;

    private Direcciones origen;

    private Direcciones destino ;
}


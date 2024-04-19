package com.kitsune.kitsune_api.dto;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kitsune.kitsune_api.entities.Cliente;

@Data
public class RideDto {
    
    private double distancia;

    private double costo;

    private int clienteid;

    @JsonIgnore
    private Cliente clienteRide;

    private int conductorId;

    private int  idDireccionOrigen;

    private int idDireccionDestino;

    private int metodoid;

}


package com.kitsune.kitsune_api.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kitsune.kitsune_api.entities.Direcciones;

import lombok.Data;

@Data
public class InformacionRideCliente {

    private PerfilCliente perfilCliente;

    private LocalDate fechaRide;

    @JsonIgnore
    private Direcciones origenRide;
    @JsonIgnore
    private Direcciones destinoRide;
    
    private double precioRide;

    private int calificacion;
}

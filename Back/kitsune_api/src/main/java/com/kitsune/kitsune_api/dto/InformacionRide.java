package com.kitsune.kitsune_api.dto;

import java.time.LocalDate;

import com.kitsune.kitsune_api.entities.Direcciones;

import lombok.Data;

@Data
public class InformacionRide {

    private PerfilConductor perfilConductor;

    private LocalDate fechaRide;

    private Direcciones origenRide;

    private Direcciones destinoRide;
    
    private double precioRide;

    private int calificacion;

}

package com.kitsune.kitsune_api.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class InformacionRide {

    private PerfilConductor perfilConductor;

    private LocalDate fechaRide;

    private String origenRide;

    private String destinoRide;
    
    private String precioRide;

    private int calificacion;

}

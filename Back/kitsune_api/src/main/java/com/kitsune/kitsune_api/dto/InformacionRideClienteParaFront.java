package com.kitsune.kitsune_api.dto;

import java.time.LocalDate;



import lombok.Data;

@Data
public class InformacionRideClienteParaFront {

    private String username;

    private LocalDate fechaRide;

    private String origenRideLatitud;
    private String origenRideLongitud;

    private String destinoRideLatitud;
    private String destinoRideLongitud;
    
    private double precioRide;

    private int calificacion;
}

package com.kitsune.kitsune_api.dto;

import lombok.Data;

@Data
public class PerfilConductor {
    
    private PerfilPersona perfilPersona;

    private String marcaVehiculo;

    private String colorVehiculo;

    private String placaVehiculo;

    private double rating;

}

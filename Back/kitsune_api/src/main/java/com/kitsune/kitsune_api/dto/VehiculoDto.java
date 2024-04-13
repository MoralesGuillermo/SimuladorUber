package com.kitsune.kitsune_api.dto;

import com.kitsune.kitsune_api.entities.MarcaVehiculo;

import lombok.Data;

@Data
public class VehiculoDto {

    private String vin;

    private String placas;

    private String color;

    private MarcaVehiculo marcavehiculo;

    private int tipoVehiculo;
}

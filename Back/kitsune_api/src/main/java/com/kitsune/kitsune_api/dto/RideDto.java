package com.kitsune.kitsune_api.dto;

import lombok.Data;
import com.kitsune.kitsune_api.entities.Cliente;

@Data
public class RideDto {
    
    private int rideId;

    private double distancia;

    private double costo;

    private int calificacion;

    private char estatus;

    private int clienteid;

    private Cliente clienteRide;

    private int conductorId;

    private int  idDireccionOrigen;

    private int idDireccionDestino;

    private int metodoid;

}

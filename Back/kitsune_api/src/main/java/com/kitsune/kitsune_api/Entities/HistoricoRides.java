package com.kitsune.kitsune_api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="historicorides")
@Data
public class HistoricoRides {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rideid")
    private int rideId;

    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "conductorid", referencedColumnName = "conductorid")
    private Conductor conductor;

    private LocalDate fecha;

    @OneToOne
    @JoinColumn(name = "vehiculovin", referencedColumnName = "vin")
    private Vehiculo vehiculo;

    private String latitudOrigen;

    private String latitudDestino;

    private String longitudOrigen;

    private String longitudDestino;

    private double distancia;

    private Parametros parametros;

    private double costo;

    private int calificacion;

    private char status;
}

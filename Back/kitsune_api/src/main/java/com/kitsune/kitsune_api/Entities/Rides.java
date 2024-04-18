package com.kitsune.kitsune_api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="rides")
@Data
public class Rides {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rideid")
    private int rideId;

    private LocalDate fecha = LocalDate.now();

    private double distancia;

    private double costo;

    private int calificacion;

    private char estatus;

    @ManyToOne
    @JoinColumn(name="clienteid", referencedColumnName="clienteid")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "conductorid", referencedColumnName = "conductorid")
    private Conductor conductor;

    @ManyToOne
    @JoinColumn(name = "direccionorigen", referencedColumnName = "direccionid")
    private Direcciones direccionorigen;

    @ManyToOne
    @JoinColumn(name = "direcciondestino", referencedColumnName = "direccionid")
    private Direcciones direcciondestino;

    @ManyToOne
    @JoinColumn(name="metodoid", referencedColumnName="metodoid")
    private MetodosPago metodospago;
}

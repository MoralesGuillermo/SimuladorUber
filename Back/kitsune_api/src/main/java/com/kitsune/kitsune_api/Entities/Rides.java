package com.kitsune.kitsune_api.Entities;

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
@Table(name="rides")
@Data
public class Rides {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rideid")
    private int rideId;

    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "conductorid", referencedColumnName = "conductorid")
    private Conductor conductor;

    @OneToOne
    @JoinColumn(name = "vehiculovin", referencedColumnName = "vin")
    private Vehiculo vehiculo;

    private LocalDate fecha;

    @OneToOne
    @JoinColumn(name = "direccionorigen", referencedColumnName = "direccionid")
    private Direcciones direccionorigen;

    @OneToOne
    @JoinColumn(name = "direcciondestino", referencedColumnName = "direccionid")
    private Direcciones direcciondestino;

    private double ditancia;

    private double costo;

    private MetodosPago metodospago;

    private int calificacion;

    private char estatus;
}

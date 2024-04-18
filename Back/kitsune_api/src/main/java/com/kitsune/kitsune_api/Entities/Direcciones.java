package com.kitsune.kitsune_api.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="direcciones")
@Data
public class Direcciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="direccionid")
    private int direccionId;

    private String latitud;

    private String longitud;

    @OneToMany(mappedBy = "direccionOrigen")
    private List<Rides> origenride;

    @OneToMany(mappedBy = "direccionDestino")
    private List<Rides> destinoride;

    @OneToMany(mappedBy = "direccion")
    private List<Conductor> conductores;
}

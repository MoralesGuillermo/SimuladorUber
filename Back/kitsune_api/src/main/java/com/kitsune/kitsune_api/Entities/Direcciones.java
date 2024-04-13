package com.kitsune.kitsune_api.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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

    @OneToOne(mappedBy = "direccionorigen")
    private Rides origenride;

    @OneToOne(mappedBy = "direcciondestino")
    private Rides destinoride;
}

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

@Entity
@Table(name="conductor")
@Data
public class Conductor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="conductorid")
    private int conductorId;

    @OneToOne
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private Persona persona;

    private double rating;

    private boolean disponible;

    private Direcciones direcciones;

    @OneToOne(mappedBy = "conductor")
    private Rides rides;

    @OneToOne(mappedBy = "conductor")
    private HistoricoRides historicorides;
}

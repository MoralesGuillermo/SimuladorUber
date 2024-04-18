package com.kitsune.kitsune_api.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private Persona persona;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private Usuario usuario;

    private double rating;

    private boolean disponible;

    @ManyToOne
    @JoinColumn(name="direccionactual", referencedColumnName="direccionid")
    private Direcciones direccion;

    @OneToMany(mappedBy = "conductor")
    private List<Rides> rides;

    @OneToMany(mappedBy="conductor")
    private List<ConductorVehiculos> conductorVehiculos;
}

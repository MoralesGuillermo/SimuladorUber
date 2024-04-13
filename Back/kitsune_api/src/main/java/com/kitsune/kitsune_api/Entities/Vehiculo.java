package com.kitsune.kitsune_api.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="vehiculo")
@Data
public class Vehiculo {
    
    @Id
    private String vin;

    private String placas;

    private String color;

    @ManyToOne()
    @JoinColumn(name = "marca", referencedColumnName = "marcaid")
    private MarcaVehiculo marcavehiculo;

    @OneToMany(mappedBy = "vehiculo")
    private List<ConductorVehiculos> conductorVehiculos;
}

package com.kitsune.kitsune_api.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marcaid", referencedColumnName = "marcaid")
    private MarcaVehiculo marcavehiculo;

    @Column(name="tipovehiculo")
    private int tipoVehiculo;

    @OneToOne(mappedBy = "vehiculo")
    private Rides rides;

    @OneToOne(mappedBy = "vehiculo")
    private HistoricoRides historicorides;
}

package com.kitsune.kitsune_api.entities;

import java.time.LocalDate;

import com.kitsune.kitsune_api.entities.compisite_keys.ConductorVehiculoKey;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="conductorvehiculos")
@Data
public class ConductorVehiculos {

    @EmbeddedId
    private ConductorVehiculoKey conductorVehiculoKey;

    @Column(name="fechainiciooperacion")
    LocalDate fechaInicioOperacion;

    @Column(name="fechafinalizacionoperacion")
    LocalDate fechaFinOperacion;

    char estatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("conductorId")
    @JoinColumn(name="conductorid", referencedColumnName = "conductorid")
    private Conductor conductor;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("vehiculoVin")
    @JoinColumn(name = "vehiculovin", referencedColumnName = "vin")
    private Vehiculo vehiculo;

}

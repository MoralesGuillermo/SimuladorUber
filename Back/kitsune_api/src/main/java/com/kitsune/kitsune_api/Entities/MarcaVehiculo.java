package com.kitsune.kitsune_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="marcavehiculo")
@Data
public class MarcaVehiculo {
    
    @Id
    private String marcaID;

    private String descripcion;

    @OneToOne(mappedBy = "marcavehiculo")
    private Vehiculo vehiculo;
}

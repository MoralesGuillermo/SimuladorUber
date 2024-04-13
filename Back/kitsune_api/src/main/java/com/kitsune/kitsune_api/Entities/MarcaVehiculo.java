package com.kitsune.kitsune_api.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="marcavehiculo")
@Data
public class MarcaVehiculo {
    
    @Id
    @Column(name="marcaid")
    private String marcaID;

    private String descripcion;

    @OneToMany(mappedBy = "marcavehiculo")
    private List<Vehiculo> vehiculos;
}

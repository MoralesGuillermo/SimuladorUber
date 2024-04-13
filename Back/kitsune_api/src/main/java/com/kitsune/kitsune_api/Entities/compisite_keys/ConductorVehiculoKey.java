package com.kitsune.kitsune_api.entities.compisite_keys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ConductorVehiculoKey implements Serializable{

    @Column(name="vehiculovin")
    private String vehiculoVin;

    @Column(name="conductorid")
    private int conductorId;

}

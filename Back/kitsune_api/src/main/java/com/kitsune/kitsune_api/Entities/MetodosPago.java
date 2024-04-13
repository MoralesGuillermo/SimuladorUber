package com.kitsune.kitsune_api.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="metodospago")
@Data
public class MetodosPago {
 
    @Id
    @Column(name="metodoid")
    private int metodoId;

    @Column(name="tipometodo")
    private char tipoMetodo;

    @ManyToOne()
    @JoinColumn(name = "pan", referencedColumnName = "pan")
    private Tarjetas tarjetas;

    @OneToMany(mappedBy="metodospago")
    private List<Rides> rides;

}

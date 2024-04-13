package com.kitsune.kitsune_api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="tarjetas")
@Data
public class Tarjetas {
    
    @Id
    private String pan;

    private int cvv;

    @ManyToOne()
    @JoinColumn(name = "clienteid", referencedColumnName = "clienteid")
    private Cliente cliente;    

    @Column(name="fechacaducidad")
    private LocalDate fechaCaducidad;

    @OneToMany(mappedBy = "tarjetas")
    private List<MetodosPago> metodospago;
}

package com.kitsune.kitsune_api.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="parametros")
@Data
public class Parametros {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="parametroid")
    private int parametroId;

    private String descripcion;

    private double valor;
}

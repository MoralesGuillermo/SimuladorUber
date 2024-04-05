package com.recibosluz.demo.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tiporesidencia")
@Data
public class TipoResidencia {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="idtiporesidencia")
    private int idTipoResidencia;

    private String descripcion;

    private double precioKw;

}

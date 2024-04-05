package com.recibosluz.demo.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="abonado")
@Data
public class Abonado {
    
    @Id
    private String dni;

    private String nombre;

    private String apellido;

    private String telefono;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idtiporesidencia", referencedColumnName = "idtiporesidencia")
    private TipoResidencia TiposResidencia;



}

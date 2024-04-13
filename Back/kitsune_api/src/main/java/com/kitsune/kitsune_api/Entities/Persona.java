package com.kitsune.kitsune_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="persona")
@Data
public class Persona {
    
    @Id
    private String dni;

    private String nombre;

    private String apellido;

    private String telefono;

    private String email;

    private int edad;

    private char genero;

    @OneToOne(mappedBy = "persona")
    private Cliente cliente;

    @OneToOne(mappedBy = "persona")
    private Conductor conductor;
}

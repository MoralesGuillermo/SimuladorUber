package com.kitsune.kitsune_api.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore; 

@Entity
@Table(name="cliente")
@Data
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="clienteid")
    private int clienteId;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private Persona persona;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private Usuario usuario;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Tarjetas> tarjetas;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Rides> rides;
}

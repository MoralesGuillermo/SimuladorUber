package com.kitsune.kitsune_api.dto;

import com.kitsune.kitsune_api.entities.Persona;
import com.kitsune.kitsune_api.entities.Usuario;
import com.kitsune.kitsune_api.entities.Vehiculo;

import lombok.Data;

@Data
public class NuevoConductorDto {

     private Vehiculo vehiculo;

     private Persona persona;

     private Usuario usuario;

    
}

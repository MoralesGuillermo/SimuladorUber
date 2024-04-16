package com.kitsune.kitsune_api.dto;

import com.kitsune.kitsune_api.entities.Persona;
import com.kitsune.kitsune_api.entities.Usuario;

import lombok.Data;

@Data
public class ClienteDto {

    private Persona persona;

    private Usuario usuario;
}

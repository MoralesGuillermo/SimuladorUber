package com.kitsune.kitsune_api.dto;

import com.kitsune.kitsune_api.entities.Cliente;

import lombok.Data;

@Data
public class UsuarioDto {
    private int userId;

    private String username;

    private String passkey;

    private Cliente cliente;
    

}

package com.kitsune.kitsune_api.dto;

import lombok.Data;

@Data
public class PerfilCliente {

    private int clienteId;
    
    private PerfilPersona perfilPersona;

    private String username;

    private char estatus;
}

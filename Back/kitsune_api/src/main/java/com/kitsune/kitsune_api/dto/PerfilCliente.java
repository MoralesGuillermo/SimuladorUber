package com.kitsune.kitsune_api.dto;

import lombok.Data;

@Data
public class PerfilCliente {

    private PerfilPersona perfilPersona;

    private String username;

    private String telefono;

}

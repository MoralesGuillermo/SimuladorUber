package com.recibosluz.demo.DTO;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AbonadoDTO {
    private String dni;

    private String nombre;

    private String apellido;

    private String telefono;

    private int idTipoResidencia;
}

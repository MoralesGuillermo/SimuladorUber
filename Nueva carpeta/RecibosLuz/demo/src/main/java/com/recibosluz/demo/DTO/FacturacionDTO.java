package com.recibosluz.demo.DTO;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.recibosluz.demo.Entities.Abonado;

import lombok.Data;

@Component
@Data
public class FacturacionDTO {
        

    private int idFacturacion;


    private LocalDate fechaFacturacion;

    private String dni;

    private Abonado abonado;


    private double kwsConsumidos;


    private double totalFacturacion;
}

package com.kitsune.kitsune_api.dto;

import java.time.LocalDate;
import java.util.List;



import lombok.Data;

@Data
public class TarjetasDTO {
    
    private String username;

    private String pan;

    private int cvv;


    private LocalDate fechaCaducidad;

    private List<Character> metodosDePago;
     
}


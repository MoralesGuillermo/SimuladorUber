package com.kitsune.kitsune_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.TarjetasDTO;
import com.kitsune.kitsune_api.entities.Tarjetas;
import com.kitsune.kitsune_api.services.impl.TarjetasServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/kitsune/tarjeta")
public class TarjetasController {

    @Autowired
    private TarjetasServiceImpl tarjetasServiceImpl;
    

    @PostMapping("/crear")
    public HttpResponse<TarjetasDTO> crearTarjeta(@RequestBody Tarjetas tarjetas, @RequestParam int clienteId) {
        return this.tarjetasServiceImpl.nuevaTarjeta(tarjetas, clienteId);
    }
    
}

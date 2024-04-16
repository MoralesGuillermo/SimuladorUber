package com.kitsune.kitsune_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.services.impl.TarjetasServiceImpl;


@RestController
@RequestMapping("kitsune")
public class TarjetasController {
    
    @Autowired
    private TarjetasServiceImpl tarjetasServiceImpl;

    @DeleteMapping("/eliminarTarjeta/{pan}")
    public HttpResponse<String> eliminarTarjeta(@PathVariable String pan){
        return this.tarjetasServiceImpl.eliminarTarjeta(pan);
    }
}

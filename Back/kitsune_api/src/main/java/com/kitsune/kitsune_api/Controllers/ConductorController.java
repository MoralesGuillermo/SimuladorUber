package com.kitsune.kitsune_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.PerfilConductor;
import com.kitsune.kitsune_api.services.impl.ConductorServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("kitsune")
public class ConductorController {
    
    @Autowired
    private ConductorServiceImpl conductorServiceImpl;

    @GetMapping("/verPerfilConductor/{conductorId}")
    public HttpResponse<PerfilConductor> verPerfilConductor(@PathVariable int conductorId) {
        return this.conductorServiceImpl.verPerfil(conductorId);
    }
    
}

package com.kitsune.kitsune_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.PerfilConductor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.kitsune.kitsune_api.dto.NuevoConductorDto;
import com.kitsune.kitsune_api.entities.Conductor;
import com.kitsune.kitsune_api.services.impl.ConductorServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("kitsune/conductor")
public class ConductorController {

    @Autowired
    ConductorServiceImpl conductorServiceImpl;
    
    @PostMapping("/crear")
    public HttpResponse<Conductor> crearConductor(@RequestBody  NuevoConductorDto nuevoConductor) {
        return conductorServiceImpl.crearConductor(nuevoConductor);
    }

    @GetMapping("/verPerfilConductor/{conductorId}")
    public HttpResponse<PerfilConductor> verPerfilConductor(@PathVariable int conductorId) {
        return this.conductorServiceImpl.verPerfil(conductorId);
    }    
}

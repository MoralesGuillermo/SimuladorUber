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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;


@RestController
@RequestMapping("kitsune/conductor")
public class ConductorController {

    @Autowired
    ConductorServiceImpl conductorServiceImpl;
    
    @PostMapping("/crear")
    @Operation(summary = "Crea un nuevo conductor.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Conductor creado correctamente.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Conductor.class)) }),
            @ApiResponse(responseCode = "406", description = "Vehículo, persona o usuario ya existentes.") })
    public HttpResponse<Conductor> crearConductor(@RequestBody  NuevoConductorDto nuevoConductor) {
        return conductorServiceImpl.crearConductor(nuevoConductor);
    }

    @GetMapping("/verPerfilConductor/{conductorId}")
    @Operation(summary = "Obtiene el perfil de un conductor mediante su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Perfil del conductor obtenido correctamente.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PerfilConductor.class)) }),
            @ApiResponse(responseCode = "404", description = "Conductor no encontrado.") })
    public HttpResponse<PerfilConductor> verPerfilConductor(@PathVariable int conductorId) {
        return this.conductorServiceImpl.verPerfil(conductorId);
    } 
}

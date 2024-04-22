package com.kitsune.kitsune_api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.kitsune.kitsune_api.dto.ClienteDto;
import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.InformacionRideCliente;
import com.kitsune.kitsune_api.dto.PerfilCliente;
import com.kitsune.kitsune_api.entities.Cliente;
import com.kitsune.kitsune_api.services.impl.ClienteServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("kitsune/cliente")
public class ClienteController{

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @GetMapping("/ver-perfil/{clienteId}")
    @Operation(summary = "Obtiene el perfil de un cliente mediante su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Perfil del cliente obtenido correctamente.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PerfilCliente.class)) }),
            @ApiResponse(responseCode = "404", description = "Perfil del cliente no encontrado.") })
    public HttpResponse<PerfilCliente> verPerfil(@PathVariable int clienteId) {
        return this.clienteServiceImpl.verPerfil(clienteId);
    }
    

    @GetMapping("/mostrarRides")
    @Operation(summary = "Muestra los rides de un cliente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rides del cliente obtenidos correctamente.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = InformacionRideCliente.class)) }),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta."),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado.") })
    public HttpResponse<List<InformacionRideCliente>> mostrarRides(@RequestParam int clienteId) {
        return this.clienteServiceImpl.mostrarRidesCliente(clienteId);
    }
    
    @PostMapping("/crear")
    @Operation(summary = "Crea un nuevo cliente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente creado correctamente.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cliente.class)) }),
            @ApiResponse(responseCode = "400", description = "Datos incompletos."),
            @ApiResponse(responseCode = "406", description = "Persona o usuario ya existentes.") })
    public HttpResponse<Cliente> crearCliente(@RequestBody ClienteDto clienteDto) {
        return this.clienteServiceImpl.crearCliente(clienteDto);
    }
        
    @GetMapping("/test")
    @Operation(summary = "Prueba de conexión a la API.")
    public String testAPI() {
        return "Se realizo la conexion de manera exitosa";
    }
    

}

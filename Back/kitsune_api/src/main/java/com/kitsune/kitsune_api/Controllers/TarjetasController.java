package com.kitsune.kitsune_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.TarjetasDTO;
import com.kitsune.kitsune_api.entities.Tarjetas;
import com.kitsune.kitsune_api.services.impl.TarjetasServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/kitsune/tarjeta")
public class TarjetasController {

    @Autowired
    private TarjetasServiceImpl tarjetasServiceImpl;
    

    @PostMapping("/crear")
    @Operation(summary = "Crea una nueva tarjeta de crédito para un cliente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarjeta creada correctamente."),
            @ApiResponse(responseCode = "400", description = "Cliente no encontrado.") })
    public HttpResponse<TarjetasDTO> crearTarjeta(@RequestBody Tarjetas tarjetas, @RequestParam int clienteId) {
        return this.tarjetasServiceImpl.nuevaTarjeta(tarjetas, clienteId);
    }

    @DeleteMapping("/eliminarTarjeta/{pan}")
    @Operation(summary = "Elimina una tarjeta de crédito por su número PAN.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarjeta eliminada correctamente."),
            @ApiResponse(responseCode = "400", description = "El número PAN de la tarjeta es nulo."),
            @ApiResponse(responseCode = "404", description = "Tarjeta no encontrada.") })
    public HttpResponse<String> eliminarTarjeta(@PathVariable String pan){
        return this.tarjetasServiceImpl.eliminarTarjeta(pan);
    }
}

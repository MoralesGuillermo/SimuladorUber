package com.kitsune.kitsune_api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.UsuarioDto;
import com.kitsune.kitsune_api.entities.Persona;
import com.kitsune.kitsune_api.services.impl.UsuarioServiceImpl;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("kitsune/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @GetMapping("/logon")
    @Operation(summary = "Inicia sesión de usuario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inicio de sesión exitoso."),
            @ApiResponse(responseCode = "400", description = "Credenciales de inicio de sesión inválidas.") })
    public HttpResponse<Persona> logon(@RequestBody UsuarioDto user){
        return this.usuarioServiceImpl.logon(user);
    }


    @DeleteMapping("/eliminar")
    @Operation(summary = "Elimina un usuario por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario eliminado correctamente."),
            @ApiResponse(responseCode = "400", description = "El ID de usuario proporcionado no existe.") })
    public HttpResponse<String> eliminarUsuario(@RequestParam int userId) {
        return this.usuarioServiceImpl.borrarUsuario(userId);
        
    }

    @PutMapping("/cambiarContrasena")
    @Operation(summary = "Cambia la contraseña de un usuario por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contraseña cambiada correctamente."),
            @ApiResponse(responseCode = "400", description = "El ID de usuario proporcionado no existe.") })
    public HttpResponse<String> cambiarPassword(@RequestParam int userId,@RequestParam String password) {
        return this.usuarioServiceImpl.cambiarPassword(userId, password);
    }


}

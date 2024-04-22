package com.kitsune.kitsune_api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.UsuarioDto;
import com.kitsune.kitsune_api.entities.Persona;
import com.kitsune.kitsune_api.services.impl.UsuarioServiceImpl;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("kitsune/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @GetMapping("/logon")
    public HttpResponse<Persona> logon(@RequestBody UsuarioDto user){
        return this.usuarioServiceImpl.logon(user);
    }


    @PutMapping("/eliminar/{clienteId}")
    public HttpResponse<String> eliminarUsuario(@PathVariable int clienteId) {
        return this.usuarioServiceImpl.borrarUsuario(clienteId);
        
    }

    @PutMapping("/cambiarContrasena")
    public HttpResponse<String> cambiarPassword(@RequestParam int userId,@RequestParam String password) {
        return this.usuarioServiceImpl.cambiarPassword(userId, password);
    }


}

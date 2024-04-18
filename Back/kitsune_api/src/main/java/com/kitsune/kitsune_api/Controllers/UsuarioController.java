package com.kitsune.kitsune_api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.services.impl.UsuarioServiceImpl;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("kitsune/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;


    @DeleteMapping("/eliminar")
    public HttpResponse<String> eliminarUsuario(@RequestParam int userId) {
        return this.usuarioServiceImpl.borrarUsuario(userId);
        
    }

    @PutMapping("/cambiarContraseña")
    public HttpResponse<String> cambiarPaswword(@RequestParam int userId,@RequestParam String password) {
        return this.usuarioServiceImpl.cambiarPassword(userId, password);
    }


}

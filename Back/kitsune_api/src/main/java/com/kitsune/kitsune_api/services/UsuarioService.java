package com.kitsune.kitsune_api.services;


import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.UsuarioDto;
import com.kitsune.kitsune_api.entities.Persona;

public interface UsuarioService {

    public HttpResponse<Persona> logon(UsuarioDto user);

    public HttpResponse<String> borrarUsuario(int userId);

    public HttpResponse<String> cambiarPassword(int userId, String password);

    public HttpResponse<String> activarUsuario(int userId);

}

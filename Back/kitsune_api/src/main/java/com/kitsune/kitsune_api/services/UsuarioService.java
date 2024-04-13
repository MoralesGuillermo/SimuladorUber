package com.kitsune.kitsune_api.services;

import java.util.List;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.InformacionRide;
import com.kitsune.kitsune_api.dto.UsuarioDto;
import com.kitsune.kitsune_api.entities.Usuario;

public interface UsuarioService {

    public HttpResponse<Usuario> crearUsuario(UsuarioDto usuarioDto);

    public HttpResponse<String> borrarUsuario(int userId);

    public HttpResponse<String> cambiarPassword(int userId, String password);

    public HttpResponse<List<InformacionRide>> verRidesCliente(int userId);

}

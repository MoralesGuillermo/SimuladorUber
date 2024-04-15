package com.kitsune.kitsune_api.services;

import java.util.List;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.InformacionRide;

public interface UsuarioService {

    public HttpResponse<String> borrarUsuario(int userId);

    public HttpResponse<String> cambiarPassword(int userId, String password);

    public HttpResponse<List<InformacionRide>> verRidesCliente(int userId);

}

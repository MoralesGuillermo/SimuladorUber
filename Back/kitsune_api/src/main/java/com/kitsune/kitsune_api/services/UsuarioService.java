package com.kitsune.kitsune_api.services;

import java.util.List;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.InformacionRide;
import com.kitsune.kitsune_api.dto.UsuarioDto;
import com.kitsune.kitsune_api.entities.Cliente;

public interface UsuarioService {

    public HttpResponse<Cliente> logon(UsuarioDto user);

    public HttpResponse<String> borrarUsuario(int userId);

    public HttpResponse<String> cambiarPassword(int userId, String password);

    public HttpResponse<List<InformacionRide>> verRidesCliente(int userId);

}

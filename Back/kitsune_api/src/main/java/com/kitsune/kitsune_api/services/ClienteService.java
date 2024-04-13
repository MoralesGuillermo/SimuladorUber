package com.kitsune.kitsune_api.services;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.PerfilCliente;

public interface ClienteService {

    public HttpResponse<PerfilCliente> verPerfil(int clienteId);

}

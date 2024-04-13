package com.kitsune.kitsune_api.services;

import java.util.List;
import com.kitsune.kitsune_api.dto.InformacionRide;
import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.PerfilCliente;

public interface ClienteService {

    public HttpResponse<PerfilCliente> verPerfil(int clienteId);

    public HttpResponse<List<InformacionRide>> mostrarRidesCliente(int clienteId);
}

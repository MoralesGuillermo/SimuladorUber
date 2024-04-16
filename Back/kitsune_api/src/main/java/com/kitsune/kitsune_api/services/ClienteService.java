package com.kitsune.kitsune_api.services;

import java.util.List;
import com.kitsune.kitsune_api.dto.InformacionRide;
import com.kitsune.kitsune_api.dto.ClienteDto;
import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.PerfilCliente;
import com.kitsune.kitsune_api.entities.Cliente;

public interface ClienteService {

    public HttpResponse<Cliente> crearCliente(ClienteDto clienteDto);

    public HttpResponse<PerfilCliente> verPerfil(int clienteId);

    public HttpResponse<List<InformacionRide>> mostrarRidesCliente(int clienteId);
}

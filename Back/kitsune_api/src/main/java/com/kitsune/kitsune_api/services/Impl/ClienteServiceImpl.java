package com.kitsune.kitsune_api.services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.InformacionRide;
import com.kitsune.kitsune_api.dto.PerfilCliente;
import com.kitsune.kitsune_api.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Override
    public HttpResponse<PerfilCliente> verPerfil(int clienteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verPerfil'");
    }

    @Override
    public HttpResponse<List<InformacionRide>> mostrarRidesCliente(int clienteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarRidesCliente'");
    }
    
}

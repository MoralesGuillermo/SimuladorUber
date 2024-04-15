package com.kitsune.kitsune_api.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.InformacionRide;
import com.kitsune.kitsune_api.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Override
    public HttpResponse<String> borrarUsuario(int userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarUsuario'");
    }

    @Override
    public HttpResponse<String> cambiarPassword(int userId, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarPassword'");
    }

    @Override
    public HttpResponse<List<InformacionRide>> verRidesCliente(int userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verRidesCliente'");
    }

    
}

package com.kitsune.kitsune_api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.InformacionRide;
import com.kitsune.kitsune_api.dto.UsuarioDto;
import com.kitsune.kitsune_api.entities.Cliente;
import com.kitsune.kitsune_api.entities.Usuario;
import com.kitsune.kitsune_api.repositories.UsuarioRepository;
import com.kitsune.kitsune_api.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
        @Autowired
        UsuarioRepository usuarioRepository;

        @Override
        public HttpResponse<Cliente> logon(UsuarioDto user) {
            HttpResponse<Cliente> response = new HttpResponse<>();
            Usuario expectedUser = usuarioRepository.getByUsername(user.getUsername());
            if (invalidCredentials(user, expectedUser)){
                response.setStatus((short) 401);
                return response;
            }
            Cliente cliente = expectedUser.getCliente();
            response.setStatus((short) 200);
            response.setResponseBody(cliente);
            return response;
        }

        private boolean invalidCredentials(UsuarioDto user, Usuario expected){
            return (expected == null || !user.getPasskey().equals(expected.getPasskey()));
        }

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

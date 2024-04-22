package com.kitsune.kitsune_api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.PerfilCliente;
import com.kitsune.kitsune_api.dto.UsuarioDto;
import com.kitsune.kitsune_api.entities.Cliente;
import com.kitsune.kitsune_api.entities.Conductor;
import com.kitsune.kitsune_api.entities.Persona;
import com.kitsune.kitsune_api.entities.Usuario;

import com.kitsune.kitsune_api.repositories.UsuarioRepository;
import com.kitsune.kitsune_api.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
        @Autowired
        private UsuarioRepository usuarioRepository;


        @Override
        public HttpResponse<Persona> logon(UsuarioDto user) {
            HttpResponse<Persona> response = new HttpResponse<>();
            Usuario expectedUser = usuarioRepository.getByUsername(user.getUsername());
            if (invalidCredentials(user, expectedUser) || noUserAsigned(expectedUser) || deletedUser(expectedUser)){
                response.setStatus((short) 400);
                return response;
            }
            Cliente cliente = expectedUser.getCliente();
            Conductor conductor = expectedUser.getConductor();
            Persona persona = cliente == null ? conductor.getPersona() : cliente.getPersona(); 
            response.setStatus((short) 200);
            response.setResponseBody(persona);
            return response;
        }

        private boolean invalidCredentials(UsuarioDto user, Usuario expected){
            return (expected == null || !user.getPasskey().equals(expected.getPasskey()));
        }

        private boolean noUserAsigned(Usuario user){
            return (user.getCliente() == null && user.getConductor() == null);
        }

        private boolean deletedUser(Usuario user){
            return (user.getEstatus() == 'I');
        }

    @Override
    public HttpResponse<String> borrarUsuario(int userId) {
        HttpResponse<String> response = new HttpResponse<>();
        if (this.usuarioRepository.existsById(userId)) {
            Usuario usuario = this.usuarioRepository.findById(userId).get();
            usuario.setEstatus('I');
            this.usuarioRepository.save(usuario);
            response.setResponseBody("Usuario borrado correctamente");
            response.setStatus((short)200);
            return response;
        }
        else{
            response.setStatus((short)400);
            return response;
        }
    }

    @Override
    public HttpResponse<String> cambiarPassword(int userId, String password) {
        HttpResponse<String> response = new HttpResponse<>();

        //Si el usuario existe
        if(this.usuarioRepository.existsById(userId)){
            Usuario usuario = this.usuarioRepository.findById(userId).get();
            usuario.setPasskey(password);
            this.usuarioRepository.save(usuario);
            
            response.setResponseBody("La contraseña ha sido cambiada con exito");
            response.setStatus((short)200);
            return response;
        }
        //Si el usuario no existe
        else{
            response.setStatus((short)400);
            return response;
        }
    }

    public HttpResponse<String> borrarUsuario2(int userId) {
        HttpResponse<String> response = new HttpResponse<>();
        if (this.usuarioRepository.existsById(userId)) {
            this.usuarioRepository.deleteById(userId);
            response.setResponseBody("Usuario borrado correctamente");
            response.setStatus((short)200);
            return response;
        }
        else{
            response.setStatus((short)400);
            return response;
        }
    }

    @Override
    public HttpResponse<String> activarUsuario(int userId) {
        HttpResponse<String> response = new HttpResponse<>();
        if (this.usuarioRepository.existsById(userId)) {
            Usuario usuario = this.usuarioRepository.findById(userId).get();
            usuario.setEstatus('A');
            response.setResponseBody("Usuario activado correctamente");
            response.setStatus((short)200);
            return response;
        }
        else{
            response.setStatus((short)400);
            return response;
        }
    }
}

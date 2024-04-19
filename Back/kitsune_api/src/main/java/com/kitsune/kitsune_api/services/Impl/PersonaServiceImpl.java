package com.kitsune.kitsune_api.services.impl;

import org.springframework.stereotype.Service;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.PerfilPersona;
import com.kitsune.kitsune_api.entities.Persona;
import com.kitsune.kitsune_api.services.PersonaService;

@Service
// TODO: ELIMINAR
public class PersonaServiceImpl implements PersonaService{

    @Override
    public HttpResponse<PerfilPersona> crearPersona(Persona persona) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearPersona'");
    }
    
}

package com.kitsune.kitsune_api.services;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.PerfilPersona;
import com.kitsune.kitsune_api.entities.Persona;

public interface PersonaService {
    
    public  HttpResponse<PerfilPersona> crearPersona(Persona persona);

}

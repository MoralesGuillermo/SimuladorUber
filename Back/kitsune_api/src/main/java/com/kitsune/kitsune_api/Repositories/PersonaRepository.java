package com.kitsune.kitsune_api.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kitsune.kitsune_api.Entities.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, String>{
    
}

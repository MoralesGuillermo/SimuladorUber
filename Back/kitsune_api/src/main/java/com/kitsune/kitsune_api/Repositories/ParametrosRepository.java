package com.kitsune.kitsune_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kitsune.kitsune_api.entities.Parametros;

@Repository
public interface ParametrosRepository extends CrudRepository<Parametros, Integer>{
    
    public Parametros getByDescripcion(String descripcion);
}

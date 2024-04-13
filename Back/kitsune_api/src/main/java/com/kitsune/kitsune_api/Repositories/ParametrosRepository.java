package com.kitsune.kitsune_api.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kitsune.kitsune_api.Entities.Parametros;

@Repository
public interface ParametrosRepository extends CrudRepository<Parametros, Integer>{
    
}

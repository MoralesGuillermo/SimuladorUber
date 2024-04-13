package com.kitsune.kitsune_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kitsune.kitsune_api.entities.MetodosPago;

@Repository
public interface MetodosPagoRepository extends CrudRepository<MetodosPago, Integer>{
    
}

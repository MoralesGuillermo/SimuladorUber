package com.kitsune.kitsune_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kitsune.kitsune_api.entities.ConductorVehiculos;
import com.kitsune.kitsune_api.entities.compisite_keys.ConductorVehiculoKey;

@Repository
public interface ConductorVehiculosRepository extends CrudRepository<ConductorVehiculos,ConductorVehiculoKey>{
    
}

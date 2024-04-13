package com.kitsune.kitsune_api.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaVehiculo extends CrudRepository<MarcaVehiculo, String>{
    
}

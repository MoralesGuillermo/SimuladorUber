package com.kitsune.kitsune_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kitsune.kitsune_api.entities.MetodosPago;
import java.util.List;
import com.kitsune.kitsune_api.entities.Tarjetas;


@Repository
public interface MetodosPagoRepository extends CrudRepository<MetodosPago, Integer>{
    public List<MetodosPago> findAllByTarjetas(Tarjetas tarjetas);
}

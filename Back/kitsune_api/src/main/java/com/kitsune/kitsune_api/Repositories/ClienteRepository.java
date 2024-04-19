package com.kitsune.kitsune_api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kitsune.kitsune_api.entities.Cliente;

import com.kitsune.kitsune_api.entities.Usuario;


@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{
    @Query("SELECT c FROM Cliente c WHERE c.usuario = :usuario")
    public Cliente findByUsuario(@Param("usuario") Usuario usuario);
}

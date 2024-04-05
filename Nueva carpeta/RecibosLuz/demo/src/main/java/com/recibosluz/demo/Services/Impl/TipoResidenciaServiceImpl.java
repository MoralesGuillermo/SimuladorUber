package com.recibosluz.demo.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recibosluz.demo.Entities.TipoResidencia;
import com.recibosluz.demo.Repositorys.TipoResidenciaRepository;
import com.recibosluz.demo.Services.TipoResidenciaService;

@Service
public class TipoResidenciaServiceImpl implements TipoResidenciaService{

    @Autowired
    private TipoResidenciaRepository tipoResidenciaRepository;

    @Override
    public TipoResidencia crearTipoResidencia(TipoResidencia tipoResidencia) {
        return this.tipoResidenciaRepository.save(tipoResidencia);
    }
}

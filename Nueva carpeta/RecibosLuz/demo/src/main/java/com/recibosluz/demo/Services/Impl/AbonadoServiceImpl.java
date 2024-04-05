package com.recibosluz.demo.Services.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recibosluz.demo.DTO.AbonadoDTO;
import com.recibosluz.demo.Entities.Abonado;
import com.recibosluz.demo.Entities.TipoResidencia;
import com.recibosluz.demo.Repositorys.AbonadoRepository;
import com.recibosluz.demo.Repositorys.TipoResidenciaRepository;
import com.recibosluz.demo.Services.AbonadoService;

@Service
public class AbonadoServiceImpl implements AbonadoService{

    @Autowired
    private AbonadoRepository abonadoRepository;

    @Autowired
    private TipoResidenciaRepository tipoResidenciaRepository;

    @Override
    public Abonado crearAbonado(AbonadoDTO abonado) {
        TipoResidencia tipoResidencia = this.tipoResidenciaRepository.findById(abonado.getIdTipoResidencia()).get();
        Abonado abonadoGuardar = new Abonado();
        abonadoGuardar.setTiposResidencia(tipoResidencia);
        abonadoGuardar.setApellido(abonado.getApellido());
        abonadoGuardar.setDni(abonado.getDni());
        abonadoGuardar.setNombre(abonado.getNombre());
        abonadoGuardar.setTelefono(abonado.getTelefono());

        return this.abonadoRepository.save(abonadoGuardar);
    }

    @Override
    public Optional<Abonado> obtenerAbonado(String dni) {
        return this.abonadoRepository.findById(dni);
    }

    @Override
    public String eliminarAbonado(String dni) {
        if(this.abonadoRepository.existsById(dni)){
            this.abonadoRepository.deleteById(dni);
            return "Eliminado correctamente";


        }
        return "No existe";
    }
    
}

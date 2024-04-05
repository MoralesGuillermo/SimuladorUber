package com.recibosluz.demo.Services.Impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recibosluz.demo.DTO.FacturacionDTO;
import com.recibosluz.demo.Entities.Abonado;
import com.recibosluz.demo.Entities.Facturacion;
import com.recibosluz.demo.Entities.TipoResidencia;
import com.recibosluz.demo.Repositorys.AbonadoRepository;
import com.recibosluz.demo.Repositorys.FacturacionRepository;
import com.recibosluz.demo.Services.FacturacionService;

@Service
public class FacturacionServiceImpl implements FacturacionService{

    @Autowired
    private AbonadoRepository abonadoRepository;

    @Autowired
    private FacturacionRepository facturacionRepository;

    //@Autowired
    //private TipoResidenciaRepository tipoResidenciaRepository;

    @Override
    public Facturacion crearFacturacion(FacturacionDTO facturacion) {
        Abonado abonado = this.abonadoRepository.findById(facturacion.getDni()).get();
        TipoResidencia tipoResidencia = abonado.getTiposResidencia();
        LocalDate date = LocalDate.now();

        Facturacion facturacionGuardar = new Facturacion();
        facturacionGuardar.setAbonado(abonado);
        
        facturacionGuardar.setFechaFacturacion(date);
        facturacionGuardar.setKwsConsumidos(facturacion.getKwsConsumidos());
        facturacionGuardar.setTotalFacturacion(facturacion.getKwsConsumidos()*tipoResidencia.getPrecioKw());
        
        return this.facturacionRepository.save(facturacionGuardar);
    }
    
}

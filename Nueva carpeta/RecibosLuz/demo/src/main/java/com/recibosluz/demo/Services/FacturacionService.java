package com.recibosluz.demo.Services;

import com.recibosluz.demo.DTO.FacturacionDTO;
import com.recibosluz.demo.Entities.Facturacion;

public interface FacturacionService {
    
    public Facturacion crearFacturacion(FacturacionDTO facturacion);

}

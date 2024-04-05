package com.recibosluz.demo.Services;

import java.util.Optional;

import com.recibosluz.demo.DTO.AbonadoDTO;
import com.recibosluz.demo.Entities.Abonado;

public interface AbonadoService {
    
    public Abonado crearAbonado(AbonadoDTO abonado);
    public Optional<Abonado> obtenerAbonado(String dni);
    public String eliminarAbonado(String dni);

}

package com.recibosluz.demo.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recibosluz.demo.DTO.AbonadoDTO;
import com.recibosluz.demo.DTO.FacturacionDTO;
import com.recibosluz.demo.Entities.Abonado;
import com.recibosluz.demo.Entities.Facturacion;
import com.recibosluz.demo.Entities.TipoResidencia;
import com.recibosluz.demo.Services.Impl.AbonadoServiceImpl;
import com.recibosluz.demo.Services.Impl.FacturacionServiceImpl;
import com.recibosluz.demo.Services.Impl.TipoResidenciaServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RequestMapping("/api")
@RestController
public class HomeController {
    @Autowired
    private AbonadoServiceImpl abonadoServiceImpl;

    @Autowired
    private TipoResidenciaServiceImpl tipoResidenciaServiceImpl;

    @Autowired
    private FacturacionServiceImpl facturacionServiceImpl;


    @PostMapping("/residencias/crear")
    public TipoResidencia crearTipoResidencia(@RequestBody TipoResidencia tipoResidencia) {
        return tipoResidenciaServiceImpl.crearTipoResidencia(tipoResidencia);
    }

    @PostMapping("/abonados/crear")
    public Abonado crearAbonados(@RequestBody AbonadoDTO abonado) {
        return this.abonadoServiceImpl.crearAbonado(abonado);
    }
    
    @GetMapping("/abonado/obtener")
    public Optional<Abonado> obtenerAbonado(@RequestParam String dni) {
        return this.abonadoServiceImpl.obtenerAbonado(dni);
    }
    
    @DeleteMapping("/abonado/eliminar")
    public String eliminarAbonado(@RequestParam String dni){
        return this.abonadoServiceImpl.eliminarAbonado(dni);
    }

    @PostMapping("/facturacion/crear")
    public Facturacion crearFacturacion(@RequestBody FacturacionDTO facturacionDTO) {
        return this.facturacionServiceImpl.crearFacturacion(facturacionDTO);
    }
    


}

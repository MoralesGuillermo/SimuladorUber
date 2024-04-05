package empleadopagos.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import empleadopagos.demo.Entities.HistoricoPago;
import empleadopagos.demo.Services.Impl.PagosServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/api/Pagos")
@RestController
public class PagosController {
    
    @Autowired
    private PagosServiceImpl pagosServiceImpl;

    @PostMapping("/crear")
    public HistoricoPago creHistoricoPago(@RequestBody HistoricoPago historicoPago) {
        
        
        return this.pagosServiceImpl.crearPagos(historicoPago);
    }
    

}

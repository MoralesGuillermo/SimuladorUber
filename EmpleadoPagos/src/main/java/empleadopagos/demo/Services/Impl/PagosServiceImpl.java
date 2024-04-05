package empleadopagos.demo.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import empleadopagos.demo.Entities.HistoricoPago;
import empleadopagos.demo.Repositorys.PagosRepository;
import empleadopagos.demo.Services.PagosService;

@Service
public class PagosServiceImpl implements PagosService{

    @Autowired
    private PagosRepository pagosRepository;

    @Override
    public HistoricoPago crearPagos(HistoricoPago historicoPago) {
       HistoricoPago historicoPagoGuardar = new HistoricoPago();
        historicoPagoGuardar.setEmpleado(historicoPago.getEmpleado());
        historicoPagoGuardar.setHorasTrabajadas(historicoPago.getHorasTrabajadas());
        historicoPagoGuardar.setPrecioPorHora(historicoPago.getPrecioPorHora());
        historicoPagoGuardar.setTotalSueldo(historicoPago.getHorasTrabajadas()*historicoPago.getPrecioPorHora());
        return this.pagosRepository.save(historicoPagoGuardar);

    }
    
}

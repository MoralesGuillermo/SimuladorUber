package empleadopagos.demo.DTO;

import java.util.List;

import org.springframework.stereotype.Component;

import empleadopagos.demo.Entities.Empleado;
import empleadopagos.demo.Entities.HistoricoPago;
import lombok.Data;

@Component
@Data
public class EmpleadoPago {
    
    private Empleado empleado;
    private List<HistoricoPago> pagos;

}

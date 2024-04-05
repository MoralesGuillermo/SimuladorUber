package empleadopagos.demo.Services;

import java.util.List;
import java.util.Optional;

import empleadopagos.demo.Entities.Empleado;
import empleadopagos.demo.DTO.EmpleadoPago;
import empleadopagos.demo.DTO.QueryPagosDTO;
import empleadopagos.demo.Entities.HistoricoPago;

public interface EmpleadoService {
    
    public Empleado crearEmpleados(Empleado empleado);
    public Optional<List<HistoricoPago>> buscarEmpleado(String dni);
    public String eliminarEmpleado(String dni);
    public Optional<List<EmpleadoPago>> buscarTodosEmpleados();
    public Optional<List<HistoricoPago>> buscarTodosPagosEntre(QueryPagosDTO queryPagosDTO);
    
}

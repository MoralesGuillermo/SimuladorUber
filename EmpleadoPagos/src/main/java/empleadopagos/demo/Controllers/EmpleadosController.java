package empleadopagos.demo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import empleadopagos.demo.DTO.EmpleadoPago;
import empleadopagos.demo.DTO.QueryPagosDTO;
import empleadopagos.demo.Entities.Empleado;
import empleadopagos.demo.Entities.HistoricoPago;
import empleadopagos.demo.Services.Impl.EmpleadoServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RequestMapping("/api/Empleado")
@RestController
public class EmpleadosController {
    
    @Autowired
    public EmpleadoServiceImpl empleadoServiceImpl;


    @PostMapping("/crear")
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
        return this.empleadoServiceImpl.crearEmpleados(empleado);
    }


    @GetMapping("/buscar")
    public Optional<List<HistoricoPago>> buscarEmpleado(@RequestParam String dni) {
        return this.empleadoServiceImpl.buscarEmpleado(dni);
    }

    @DeleteMapping("/eliminar")
    public String eliminarEmpleado(@RequestParam String dni){
        return this.empleadoServiceImpl.eliminarEmpleado(dni);
    }

    @GetMapping("/buscarTodos")
    public Optional<List<EmpleadoPago>> buscarTodosEmpleados() {
        return this.empleadoServiceImpl.buscarTodosEmpleados();
    }
    
    @GetMapping("/buscarTodosPagosEntre")
    public Optional<List<HistoricoPago>> buscarTodosPagosEntre(@RequestParam QueryPagosDTO queryPagosDTO) {
        return this.empleadoServiceImpl.buscarTodosPagosEntre(queryPagosDTO);
    }
    

}

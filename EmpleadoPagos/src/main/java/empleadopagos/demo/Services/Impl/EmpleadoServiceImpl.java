package empleadopagos.demo.Services.Impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import empleadopagos.demo.DTO.EmpleadoPago;
import empleadopagos.demo.DTO.QueryPagosDTO;
import empleadopagos.demo.Entities.Empleado;
import empleadopagos.demo.Entities.HistoricoPago;
import empleadopagos.demo.Repositorys.EmpleadoRepository;
import empleadopagos.demo.Repositorys.PagosRepository;
import empleadopagos.demo.Services.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private PagosRepository pagosRepository;

    @Autowired
    private EmpleadoPago empleadoPago;

  

    @Override
    public Empleado crearEmpleados(Empleado empleado) {
      return this.empleadoRepository.save(empleado);
    }

    @Override
    public Optional<List<HistoricoPago>> buscarEmpleado(String dni) {
        Empleado empleado = this.empleadoRepository.findById(dni).get();
        return this.pagosRepository.findOptionalAllByEmpleado(empleado);


    }

    @Override
    public String eliminarEmpleado(String dni) {
        if(this.empleadoRepository.existsById(dni)){
           this.empleadoRepository.delete(this.empleadoRepository.findById(dni).get());
           return "Empleado borrado exitosamente";
        }
        return "Empleado No existe";
    }

    @Override
    public Optional<List<EmpleadoPago>> buscarTodosEmpleados() {
     List<EmpleadoPago> empleadoPagoList= new ArrayList<>();
        Iterable<Empleado> empleadoLisIterable= this.empleadoRepository.findAll();
        for (Empleado empleado : empleadoLisIterable) {
           List<HistoricoPago> historicoPagos = (List<HistoricoPago>) this.pagosRepository.findAllByEmpleado((empleado));
            this.empleadoPago.setEmpleado(empleado);
            this.empleadoPago.setPagos(historicoPagos);
            empleadoPagoList.add(empleadoPago);
        }
        Optional<List<EmpleadoPago>> empleadoPagoOptionalList = Optional.of(empleadoPagoList);
        return empleadoPagoOptionalList;

    }

    @Override
    public Optional<List<HistoricoPago>> buscarTodosPagosEntre(QueryPagosDTO queryPagosDTO) {
        LocalDate fechaInicio = queryPagosDTO.getFechaInicio();
        LocalDate fechaFinal = queryPagosDTO.getFechaFinal();
        String dni = queryPagosDTO.getDni();
        Empleado empleado = this.empleadoRepository.findById(dni).get();
            return this.pagosRepository.findAllByFechaBetweenAndEmpleado(fechaInicio, fechaFinal, empleado);

    
    }

    
}

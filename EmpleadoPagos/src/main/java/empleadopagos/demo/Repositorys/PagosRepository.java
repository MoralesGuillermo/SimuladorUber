package empleadopagos.demo.Repositorys;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import empleadopagos.demo.Entities.Empleado;
import empleadopagos.demo.Entities.HistoricoPago;

@Repository
public interface PagosRepository extends CrudRepository<HistoricoPago,Integer>{
    
    public Optional<List<HistoricoPago>> findOptionalAllByEmpleado(Empleado empleado);
    public List<HistoricoPago> findAllByEmpleado(Empleado empleado);
    public Optional<List<HistoricoPago>> findAllByFechaBetweenAndEmpleado(LocalDate fechaInicio, LocalDate fechaFinal, Empleado empleado);
}

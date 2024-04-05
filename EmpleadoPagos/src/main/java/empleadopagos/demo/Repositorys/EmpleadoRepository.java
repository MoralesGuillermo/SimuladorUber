package empleadopagos.demo.Repositorys;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import empleadopagos.demo.Entities.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, String>{

}


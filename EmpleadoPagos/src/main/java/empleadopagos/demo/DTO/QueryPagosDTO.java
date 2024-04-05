package empleadopagos.demo.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class QueryPagosDTO {
    
    private String dni;

    private LocalDate fechaInicio;

    private LocalDate fechaFinal;
}

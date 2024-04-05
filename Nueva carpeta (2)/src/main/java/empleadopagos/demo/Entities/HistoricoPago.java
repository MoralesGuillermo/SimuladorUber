package empleadopagos.demo.Entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="historicopagos")
@Data
public class HistoricoPago {
    
    @Column(name="fechapago")
    private LocalDate fechaPago;

    @ManyToOne
    private Empleado empleado;

    @Column(name="horastrabajadas")
    private int horasTrabajadas;

    @Column(name="precioporhora")
    private double precioPorHora;

    @Column(name="totalsueldo")
    private double totalSueldo;
}

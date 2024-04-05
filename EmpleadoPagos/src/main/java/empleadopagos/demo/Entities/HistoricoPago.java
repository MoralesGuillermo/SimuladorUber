package empleadopagos.demo.Entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="historicopagos")
@Data
public class HistoricoPago {
    
    @Id
    @Column(name="idpago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;

    @Column(name="fechapago")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name ="dni",referencedColumnName = "dni")
    private Empleado empleado;

    @Column(name="horastrabajadas")
    private int horasTrabajadas;

    @Column(name="precioporhora")
    private double precioPorHora;

    @Column(name="totalsueldo")
    private double totalSueldo;
}

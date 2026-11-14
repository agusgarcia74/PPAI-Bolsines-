package ar.edu.utn.frc.dsi.bolsines.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

/** Duenio: T5 (Agustin). */
@Entity
public class DetalleRemito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;
    private Integer numero;

    @ManyToOne(cascade = CascadeType.ALL)
    private Documentacion documentacion;

    protected DetalleRemito() {
    }

    public DetalleRemito(Integer numero, LocalDateTime fecha, Documentacion documentacion) {
        this.numero = numero;
        this.fecha = fecha;
        this.documentacion = documentacion;
    }

    public Documentacion getDocumentacion() {
        return documentacion;
    }

    /** Flujo principal: delega en documentacion.aceptar(...). Lo de adentro es el patron State. */
    public void aceptarDocumentacion(LocalDateTime fechaHoraActual, Empleado empleado) {
        throw new UnsupportedOperationException("TODO T5");
    }

    public Integer getNumero() {
        return numero;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Long getId() {
        return id;
    }
}

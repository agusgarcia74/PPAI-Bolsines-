package ar.edu.utn.frc.dsi.bolsines.entity;

import ar.edu.utn.frc.dsi.bolsines.entity.estado.EstadoDocumentacion;
import ar.edu.utn.frc.dsi.bolsines.entity.estado.EstadoDocumentacionConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

/** Historial de estados de la Documentacion. Duenio: T4 (Trini). */
@Entity
public class CambioEstadoDocumentacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;

    @Convert(converter = EstadoDocumentacionConverter.class)
    @Column(name = "estado")
    private EstadoDocumentacion estado;

    @ManyToOne
    private Empleado responsableCE;

    protected CambioEstadoDocumentacion() {
    }

    /** new(fechaHoraInicio, estado, responsable) del diagrama. */
    public CambioEstadoDocumentacion(LocalDateTime fechaHoraInicio, EstadoDocumentacion estado, Empleado responsable) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.estado = estado;
        this.responsableCE = responsable;
    }

    public boolean esActual() {
        throw new UnsupportedOperationException("TODO T4");
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraActual) {
        throw new UnsupportedOperationException("TODO T4");
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public EstadoDocumentacion getEstado() {
        return estado;
    }

    public Empleado getResponsableCE() {
        return responsableCE;
    }

    public Long getId() {
        return id;
    }
}

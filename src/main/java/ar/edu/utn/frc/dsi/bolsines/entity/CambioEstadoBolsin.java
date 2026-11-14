package ar.edu.utn.frc.dsi.bolsines.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

/** Historial de estados del Bolsin. Duenio: T5 (Agustin). */
@Entity
public class CambioEstadoBolsin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;

    @ManyToOne
    private Estado estado;

    @ManyToOne
    private Empleado responsableCE;

    protected CambioEstadoBolsin() {
    }

    /** new(fechaHoraActual) del diagrama. */
    public CambioEstadoBolsin(LocalDateTime fechaHoraActual, Estado estado, Empleado responsableCE) {
        this.fechaHoraInicio = fechaHoraActual;
        this.estado = estado;
        this.responsableCE = responsableCE;
    }

    public boolean esActual() {
        return fechaHoraFin == null;
    }

    public boolean esEnviado() {
        return estado != null && estado.esEnviado();
    }

    public void setFechaHoraFin(LocalDateTime fechaActual) {
        this.fechaHoraFin = fechaActual;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public Estado getEstado() {
        return estado;
    }

    public Empleado getResponsableCE() {
        return responsableCE;
    }

    public Long getId() {
        return id;
    }
}

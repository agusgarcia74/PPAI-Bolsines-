package ar.edu.utn.frc.dsi.bolsines.entity;

import ar.edu.utn.frc.dsi.bolsines.entity.estado.EstadoDocumentacion;
import ar.edu.utn.frc.dsi.bolsines.entity.estado.EstadoDocumentacionConverter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * CONTEXTO del patron State. Duenio: T4 (Trini).
 *
 * Cada operacion de la maquina de estados es UNA linea que delega en el estado actual:
 *   estadoActual.aceptar(this, fechaHoraActual, empleado, cambiosEstado);
 * Sin ifs ni switch preguntando en que estado esta.
 */
@Entity
public class Documentacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String asunto;
    private LocalDateTime fechaPase;
    private Integer numero;

    @ManyToOne
    private TipoDocumentacion tieneUn;

    @Convert(converter = EstadoDocumentacionConverter.class)
    @Column(name = "estado_actual")
    private EstadoDocumentacion estadoActual;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "documentacion_id")
    @OrderBy("fechaHoraInicio")
    private List<CambioEstadoDocumentacion> cambiosEstado = new ArrayList<>();

    protected Documentacion() {
    }

    /**
     * new(asunto, fechaPase, numero) del diagrama.
     * TODO T4: dejarla en el estado inicial (Registrada) con su primer cambio de estado abierto.
     */
    public Documentacion(String asunto, LocalDateTime fechaPase, Integer numero, TipoDocumentacion tipo) {
        this.asunto = asunto;
        this.fechaPase = fechaPase;
        this.numero = numero;
        this.tieneUn = tipo;
    }

    // ---------- transiciones: delegan en el estado actual (TODO T4) ----------

    public void remitar(LocalDateTime fechaHoraActual, Empleado empleado) {
        throw new UnsupportedOperationException("TODO T4");
    }

    public void cancelarRemito(LocalDateTime fechaHoraActual, Empleado empleado) {
        throw new UnsupportedOperationException("TODO T4");
    }

    public void generarBolsin(LocalDateTime fechaHoraActual, Empleado empleado) {
        throw new UnsupportedOperationException("TODO T4");
    }

    public void modificarBolsin(LocalDateTime fechaHoraActual, Empleado empleado) {
        throw new UnsupportedOperationException("TODO T4");
    }

    public void eliminarBolsin(LocalDateTime fechaHoraActual, Empleado empleado) {
        throw new UnsupportedOperationException("TODO T4");
    }

    public void retirarBolsin(LocalDateTime fechaHoraActual, Empleado empleado) {
        throw new UnsupportedOperationException("TODO T4");
    }

    public void aceptar(LocalDateTime fechaHoraActual, Empleado empleado) {
        throw new UnsupportedOperationException("TODO T4");
    }

    public void rechazar(LocalDateTime fechaHoraActual, Empleado empleado) {
        throw new UnsupportedOperationException("TODO T4");
    }

    public void registrarFaltaDocumentacion(LocalDateTime fechaHoraActual, Empleado empleado) {
        throw new UnsupportedOperationException("TODO T4");
    }

    public void redirigir(LocalDateTime fechaHoraActual, Empleado empleado) {
        throw new UnsupportedOperationException("TODO T4");
    }

    public void reenviar(LocalDateTime fechaHoraActual, Empleado empleado) {
        throw new UnsupportedOperationException("TODO T4");
    }

    public void darDeBaja(LocalDateTime fechaHoraActual, Empleado empleado) {
        throw new UnsupportedOperationException("TODO T4");
    }

    // ---------- usados por los estados concretos al terminar una transicion ----------

    public void setEstado(EstadoDocumentacion estado) {
        this.estadoActual = estado;
    }

    public void agregarCambioEstado(CambioEstadoDocumentacion cambioEstado) {
        cambiosEstado.add(cambioEstado);
    }

    // ---------- consultas ----------

    public String getAsunto() {
        return asunto;
    }

    public TipoDocumentacion getTipoDocumentacion() {
        return tieneUn;
    }

    public EstadoDocumentacion getEstado() {
        return estadoActual;
    }

    public List<CambioEstadoDocumentacion> getCambiosEstado() {
        return cambiosEstado;
    }

    public LocalDateTime getFechaPase() {
        return fechaPase;
    }

    public Integer getNumero() {
        return numero;
    }

    public Long getId() {
        return id;
    }
}

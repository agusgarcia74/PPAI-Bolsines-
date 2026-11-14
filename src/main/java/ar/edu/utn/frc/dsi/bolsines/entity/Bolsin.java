package ar.edu.utn.frc.dsi.bolsines.entity;

import jakarta.persistence.CascadeType;
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

/** Duenio: T5 (Agustin). */
@Entity
public class Bolsin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;
    private Integer numeroBolsin;
    private String numeroPrecinto;
    private Integer peso;

    @ManyToOne
    private ComisionMedica origen;

    @ManyToOne
    private ComisionMedica destino;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bolsin_id")
    @OrderBy("numero")
    private List<Remito> remitos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bolsin_id")
    @OrderBy("fechaHoraInicio")
    private List<CambioEstadoBolsin> cambiosEstado = new ArrayList<>();

    protected Bolsin() {
    }

    public Bolsin(Integer numeroBolsin, String numeroPrecinto, Integer peso, LocalDateTime fecha,
                  ComisionMedica origen, ComisionMedica destino) {
        this.numeroBolsin = numeroBolsin;
        this.numeroPrecinto = numeroPrecinto;
        this.peso = peso;
        this.fecha = fecha;
        this.origen = origen;
        this.destino = destino;
    }

    // ---------- metodos del diagrama de clases ----------

    public Bolsin getBolsin() {
        return this;
    }

    /** Verdadero si el bolsin tiene como destino la CM recibida. */
    public boolean esDeCM(ComisionMedica cm) {
        throw new UnsupportedOperationException("TODO T5");
    }

    /** Verdadero si el cambio de estado actual del bolsin es Enviado. */
    public boolean esEnviado() {
        throw new UnsupportedOperationException("TODO T5");
    }

    public String getNroPrecinto() {
        return numeroPrecinto;
    }

    public ComisionMedica getCmOrigen() {
        return origen;
    }

    public List<Remito> getRemitos() {
        return remitos;
    }

    /**
     * Paso 11 del CU: cierra el cambio de estado actual, crea el nuevo (Recibido en CM destino)
     * y le pide a cada remito que se reciba.
     */
    public void recibirBolsin(LocalDateTime fechaHoraActual, Empleado empleado,
                              Estado estadoBolsin, Estado estadoRemito) {
        throw new UnsupportedOperationException("TODO T5");
    }

    public void crearCambioEstadoBolsin(LocalDateTime fechaHoraActual, Estado estado, Empleado empleado) {
        throw new UnsupportedOperationException("TODO T5");
    }

    // ---------- soporte ----------

    public void agregarRemito(Remito remito) {
        remitos.add(remito);
    }

    public void agregarCambioEstado(CambioEstadoBolsin cambioEstado) {
        cambiosEstado.add(cambioEstado);
    }

    public List<CambioEstadoBolsin> getCambiosEstado() {
        return cambiosEstado;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Integer getNumeroBolsin() {
        return numeroBolsin;
    }

    public Integer getPeso() {
        return peso;
    }

    public ComisionMedica getDestino() {
        return destino;
    }
}

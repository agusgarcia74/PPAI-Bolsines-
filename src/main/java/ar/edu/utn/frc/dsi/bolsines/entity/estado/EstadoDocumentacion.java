package ar.edu.utn.frc.dsi.bolsines.entity.estado;

import ar.edu.utn.frc.dsi.bolsines.entity.CambioEstadoDocumentacion;
import ar.edu.utn.frc.dsi.bolsines.entity.Documentacion;
import ar.edu.utn.frc.dsi.bolsines.entity.Empleado;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * ESTADO del patron State. Duenio: T3 (Trini).
 *
 * Declara todas las operaciones de la maquina de estados de Documentacion.
 * Por defecto TODAS rechazan la transicion: cada estado concreto redefine solo
 * las que salen de el en el diagrama (PPAI-2-ME-V1).
 */
public abstract class EstadoDocumentacion {

    // ---------- operaciones de la maquina de estados ----------

    public void remitar(Documentacion documentacion, LocalDateTime fechaHoraActual,
                        Empleado empleado, List<CambioEstadoDocumentacion> cambiosEstado) {
        throw new TransicionInvalidaException("remitar", this);
    }

    public void cancelarRemito(Documentacion documentacion, LocalDateTime fechaHoraActual,
                               Empleado empleado, List<CambioEstadoDocumentacion> cambiosEstado) {
        throw new TransicionInvalidaException("cancelarRemito", this);
    }

    public void generarBolsin(Documentacion documentacion, LocalDateTime fechaHoraActual,
                              Empleado empleado, List<CambioEstadoDocumentacion> cambiosEstado) {
        throw new TransicionInvalidaException("generarBolsin", this);
    }

    public void modificarBolsin(Documentacion documentacion, LocalDateTime fechaHoraActual,
                                Empleado empleado, List<CambioEstadoDocumentacion> cambiosEstado) {
        throw new TransicionInvalidaException("modificarBolsin", this);
    }

    public void eliminarBolsin(Documentacion documentacion, LocalDateTime fechaHoraActual,
                               Empleado empleado, List<CambioEstadoDocumentacion> cambiosEstado) {
        throw new TransicionInvalidaException("eliminarBolsin", this);
    }

    public void retirarBolsin(Documentacion documentacion, LocalDateTime fechaHoraActual,
                              Empleado empleado, List<CambioEstadoDocumentacion> cambiosEstado) {
        throw new TransicionInvalidaException("retirarBolsin", this);
    }

    public void aceptar(Documentacion documentacion, LocalDateTime fechaHoraActual,
                        Empleado empleado, List<CambioEstadoDocumentacion> cambiosEstado) {
        throw new TransicionInvalidaException("aceptar", this);
    }

    public void rechazar(Documentacion documentacion, LocalDateTime fechaHoraActual,
                         Empleado empleado, List<CambioEstadoDocumentacion> cambiosEstado) {
        throw new TransicionInvalidaException("rechazar", this);
    }

    public void registrarFaltaDocumentacion(Documentacion documentacion, LocalDateTime fechaHoraActual,
                                            Empleado empleado, List<CambioEstadoDocumentacion> cambiosEstado) {
        throw new TransicionInvalidaException("registrarFaltaDocumentacion", this);
    }

    public void redirigir(Documentacion documentacion, LocalDateTime fechaHoraActual,
                          Empleado empleado, List<CambioEstadoDocumentacion> cambiosEstado) {
        throw new TransicionInvalidaException("redirigir", this);
    }

    public void reenviar(Documentacion documentacion, LocalDateTime fechaHoraActual,
                         Empleado empleado, List<CambioEstadoDocumentacion> cambiosEstado) {
        throw new TransicionInvalidaException("reenviar", this);
    }

    public void darDeBaja(Documentacion documentacion, LocalDateTime fechaHoraActual,
                          Empleado empleado, List<CambioEstadoDocumentacion> cambiosEstado) {
        throw new TransicionInvalidaException("darDeBaja", this);
    }

    // ---------- ayudas comunes a todas las transiciones (TODO T3) ----------

    /** Devuelve el cambio de estado vigente (el que no tiene fecha de fin). */
    protected CambioEstadoDocumentacion buscarCEActual(List<CambioEstadoDocumentacion> cambiosEstado) {
        throw new UnsupportedOperationException("TODO T3");
    }

    protected CambioEstadoDocumentacion crearCambioEstado(LocalDateTime fechaHoraActual,
                                                          EstadoDocumentacion estado, Empleado empleado) {
        throw new UnsupportedOperationException("TODO T3");
    }

    // ---------- nombre y reconstruccion desde la base ----------

    /** Nombre con el que se guarda en la base y se muestra en pantalla. Es el nombre de la clase. */
    public String getNombre() {
        return getClass().getSimpleName();
    }

    private static final Map<String, Supplier<EstadoDocumentacion>> ESTADOS = Map.of(
            "Registrada", Registrada::new,
            "EnRemito", EnRemito::new,
            "EnBolsinSaliente", EnBolsinSaliente::new,
            "EnBolsinEnviado", EnBolsinEnviado::new,
            "RecibidaYAceptada", RecibidaYAceptada::new,
            "RecibidaYRechazada", RecibidaYRechazada::new,
            "NoRecibida", NoRecibida::new,
            "ParaRedirigir", ParaRedirigir::new,
            "DeBaja", DeBaja::new);

    /** Crea el objeto de estado a partir del nombre guardado en la base. */
    public static EstadoDocumentacion desdeNombre(String nombre) {
        Supplier<EstadoDocumentacion> fabrica = ESTADOS.get(nombre);
        if (fabrica == null) {
            throw new IllegalArgumentException("Estado de documentacion desconocido: " + nombre);
        }
        return fabrica.get();
    }

    @Override
    public String toString() {
        return getNombre();
    }

    @Override
    public boolean equals(Object otro) {
        return otro != null && otro.getClass() == getClass();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

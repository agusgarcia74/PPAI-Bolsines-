package ar.edu.utn.frc.dsi.bolsines.control.dto;

/**
 * Como llego cada documentacion. La elige el Encargado de Bolsines en la pantalla de control.
 * El gestor la traduce a una operacion de Documentacion (y el estado decide a donde lleva).
 */
public enum SituacionRecepcion {
    /** Flujo principal: aceptar -> RecibidaYAceptada. */
    RECIBIDA("Llego", "Recibida y aceptada"),
    /** A3: registrarFaltaDocumentacion -> NoRecibida. */
    FALTANTE("Falta", "No recibida"),
    /** A4: rechazar -> RecibidaYRechazada. */
    NO_CORRESPONDE("No corresponde", "Recibida y rechazada"),
    /** A5 (solo CMC): redirigir -> ParaRedirigir. */
    REDIRIGIR("Redirigir", "Para redirigir");

    private final String etiqueta;
    private final String estadoFinal;

    SituacionRecepcion(String etiqueta, String estadoFinal) {
        this.etiqueta = etiqueta;
        this.estadoFinal = estadoFinal;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public String getEstadoFinal() {
        return estadoFinal;
    }
}

package ar.edu.utn.frc.dsi.bolsines.entity.estado;

/** Se lanza cuando se pide una operacion que el estado actual no permite. */
public class TransicionInvalidaException extends RuntimeException {

    public TransicionInvalidaException(String operacion, EstadoDocumentacion estado) {
        super("No se puede " + operacion + " una documentacion en estado " + estado.getNombre());
    }
}

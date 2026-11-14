package ar.edu.utn.frc.dsi.bolsines.control;

/** Error de negocio que la pantalla le muestra al usuario (por ejemplo, redirigir fuera de la CMC). */
public class RecepcionException extends RuntimeException {

    public RecepcionException(String mensaje) {
        super(mensaje);
    }
}

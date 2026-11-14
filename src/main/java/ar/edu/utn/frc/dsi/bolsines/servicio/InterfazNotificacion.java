package ar.edu.utn.frc.dsi.bolsines.servicio;

import ar.edu.utn.frc.dsi.bolsines.control.dto.ResumenRecepcion;
import java.util.List;

/**
 * CU 29 Notificar recepcion de bolsin. Duenio: T2 (Vale).
 * El gestor solo conoce esta interfaz: hoy la implementacion es simulada; si mañana se manda
 * un mail real, se cambia la implementacion y el gestor no se entera.
 */
public interface InterfazNotificacion {

    /** Arma y "envia" un aviso por cada CM de origen que mando documentacion en el bolsin. */
    List<AvisoNotificacion> notificarRecepcion(ResumenRecepcion resumen);
}

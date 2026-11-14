package ar.edu.utn.frc.dsi.bolsines.control.dto;

import ar.edu.utn.frc.dsi.bolsines.servicio.AvisoNotificacion;
import java.time.LocalDateTime;
import java.util.List;

/** Respuesta de tomarConfirmacionRegistro(): lo que quedo registrado y los avisos del CU 29. */
public record ResultadoRecepcion(
        LocalDateTime fechaHora,
        String responsable,
        ResumenRecepcion resumen,
        List<AvisoNotificacion> avisos) {
}

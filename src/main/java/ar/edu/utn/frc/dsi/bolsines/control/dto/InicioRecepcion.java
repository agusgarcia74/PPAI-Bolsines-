package ar.edu.utn.frc.dsi.bolsines.control.dto;

import java.util.List;

/** Respuesta de opcionRegistrarRecepcionDeBolsin(): CM del usuario y bolsines enviados hacia ella. */
public record InicioRecepcion(
        String nombreEmpleado,
        String cmUsuario,
        boolean cmEsCentral,
        List<BolsinResumen> bolsines) {
}

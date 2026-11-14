package ar.edu.utn.frc.dsi.bolsines.servicio;

import java.util.List;

/** Un aviso del CU 29 a una CM de origen. La pantalla de exito lo muestra como "Enviando..." -> "Enviado". */
public record AvisoNotificacion(String cmDestino, String email, String asunto, List<String> detalle) {
}

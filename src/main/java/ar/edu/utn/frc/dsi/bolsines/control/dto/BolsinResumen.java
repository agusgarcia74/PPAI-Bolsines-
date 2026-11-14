package ar.edu.utn.frc.dsi.bolsines.control.dto;

import java.time.LocalDateTime;

/** Una fila del listado de bolsines (pasos 3 y 4 del CU). */
public record BolsinResumen(
        Long id,
        Integer numeroBolsin,
        String numeroPrecinto,
        String cmOrigen,
        int cantidadRemitos,
        int cantidadDocumentos,
        Integer peso,
        LocalDateTime fechaEnvio) {
}

package ar.edu.utn.frc.dsi.bolsines.control.dto;

import java.util.List;

/** Respuesta de tomarSeleccionBolsin(): el bolsin elegido con sus remitos y documentacion. */
public record DetalleBolsin(BolsinResumen bolsin, String cmDestino, List<RemitoVista> remitos) {
}

package ar.edu.utn.frc.dsi.bolsines.control.dto;

import java.util.List;

/** Un remito del bolsin con su documentacion (paso 6). */
public record RemitoVista(Integer numero, List<DocumentacionVista> documentacion) {
}

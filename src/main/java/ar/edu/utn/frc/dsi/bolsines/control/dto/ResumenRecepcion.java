package ar.edu.utn.frc.dsi.bolsines.control.dto;

import java.util.List;

/**
 * Respuesta de tomarSeleccionRecepcionBolsin(): como va a quedar todo si se confirma (paso 9).
 */
public record ResumenRecepcion(
        DetalleBolsin bolsin,
        String estadoFinalBolsin,
        List<Remito> remitos,
        List<Documento> documentacion,
        List<String> cmANotificar) {

    public record Remito(Integer numero, String estadoFinal) {
    }

    public record Documento(Long id, Integer remito, String asunto, String tipo,
                            SituacionRecepcion situacion) {

        public String estadoFinal() {
            return situacion.getEstadoFinal();
        }
    }

    public long cantidad(SituacionRecepcion situacion) {
        return documentacion.stream().filter(d -> d.situacion() == situacion).count();
    }
}

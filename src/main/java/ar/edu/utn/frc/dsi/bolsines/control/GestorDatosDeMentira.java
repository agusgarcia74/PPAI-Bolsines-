package ar.edu.utn.frc.dsi.bolsines.control;

import ar.edu.utn.frc.dsi.bolsines.control.dto.BolsinResumen;
import ar.edu.utn.frc.dsi.bolsines.control.dto.DetalleBolsin;
import ar.edu.utn.frc.dsi.bolsines.control.dto.DocumentacionVista;
import ar.edu.utn.frc.dsi.bolsines.control.dto.InicioRecepcion;
import ar.edu.utn.frc.dsi.bolsines.control.dto.RemitoVista;
import ar.edu.utn.frc.dsi.bolsines.control.dto.ResultadoRecepcion;
import ar.edu.utn.frc.dsi.bolsines.control.dto.ResumenRecepcion;
import ar.edu.utn.frc.dsi.bolsines.control.dto.SituacionRecepcion;
import ar.edu.utn.frc.dsi.bolsines.servicio.AvisoNotificacion;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * DATOS DE MENTIRA para que la pantalla (T7/T8) avance antes de que el gestor real exista.
 * No toca la base. SE BORRA EN LA T9.
 */
class GestorDatosDeMentira {

    private final List<BolsinResumen> bolsines = List.of(
            new BolsinResumen(1L, 1287, "004512", "CM Mendoza", 3, 6, 1250, LocalDateTime.now().minusDays(3)),
            new BolsinResumen(2L, 1291, "004533", "CM Cordoba", 1, 3, 480, LocalDateTime.now().minusDays(2)),
            new BolsinResumen(3L, 1302, "004577", "CM Parana", 1, 2, 300, LocalDateTime.now().minusDays(1)));

    private DetalleBolsin seleccionado;
    private ResumenRecepcion resumen;

    InicioRecepcion inicio() {
        return new InicioRecepcion("Silvina Romero", "Comision Medica Central", true, bolsines);
    }

    DetalleBolsin detalle(Long idBolsin) {
        BolsinResumen b = bolsines.stream().filter(x -> x.id().equals(idBolsin)).findFirst()
                .orElseThrow(() -> new RecepcionException("No existe el bolsin " + idBolsin));
        List<RemitoVista> remitos = new ArrayList<>();
        long idDoc = idBolsin * 100;
        String[][] docs = {
                {"Expediente", "Expediente de incapacidad laboral"},
                {"Dictamen", "Dictamen medico de comision"},
                {"Estudio medico", "Radiografia de rodilla"}};
        for (int r = 0; r < b.cantidadRemitos(); r++) {
            List<DocumentacionVista> documentacion = new ArrayList<>();
            int porRemito = Math.max(1, b.cantidadDocumentos() / b.cantidadRemitos());
            for (int d = 0; d < porRemito; d++) {
                String[] doc = docs[(r + d) % docs.length];
                documentacion.add(new DocumentacionVista(++idDoc, (int) idDoc, doc[1], doc[0]));
            }
            remitos.add(new RemitoVista(213 + r, documentacion));
        }
        seleccionado = new DetalleBolsin(b, "Comision Medica Central", remitos);
        return seleccionado;
    }

    ResumenRecepcion resumen(Map<Long, SituacionRecepcion> marcas) {
        if (seleccionado == null) {
            throw new RecepcionException("Primero hay que seleccionar un bolsin");
        }
        List<ResumenRecepcion.Documento> documentos = new ArrayList<>();
        List<ResumenRecepcion.Remito> remitos = new ArrayList<>();
        for (RemitoVista r : seleccionado.remitos()) {
            boolean completo = true;
            for (DocumentacionVista d : r.documentacion()) {
                SituacionRecepcion s = marcas.getOrDefault(d.id(), SituacionRecepcion.RECIBIDA);
                completo &= s == SituacionRecepcion.RECIBIDA;
                documentos.add(new ResumenRecepcion.Documento(d.id(), r.numero(), d.asunto(), d.tipo(), s));
            }
            remitos.add(new ResumenRecepcion.Remito(r.numero(),
                    completo ? "Recibido y aceptado" : "Recibido y aceptado parcial"));
        }
        resumen = new ResumenRecepcion(seleccionado, "Recibido en CM destino", remitos, documentos,
                List.of(seleccionado.bolsin().cmOrigen()));
        return resumen;
    }

    ResultadoRecepcion resultado() {
        if (resumen == null) {
            throw new RecepcionException("Primero hay que elegir como llego la documentacion");
        }
        AvisoNotificacion aviso = new AvisoNotificacion(seleccionado.bolsin().cmOrigen(),
                "mesa@cm.gob.ar", "Recepcion del bolsin " + seleccionado.bolsin().numeroBolsin(),
                List.of("Recibidas y aceptadas: " + resumen.cantidad(SituacionRecepcion.RECIBIDA),
                        "No recibidas: " + resumen.cantidad(SituacionRecepcion.FALTANTE)));
        ResultadoRecepcion resultado = new ResultadoRecepcion(LocalDateTime.now(), "Silvina Romero", resumen,
                List.of(aviso));
        cancelar();
        return resultado;
    }

    void cancelar() {
        seleccionado = null;
        resumen = null;
    }
}

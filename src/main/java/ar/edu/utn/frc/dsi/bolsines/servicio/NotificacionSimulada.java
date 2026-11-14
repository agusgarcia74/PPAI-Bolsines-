package ar.edu.utn.frc.dsi.bolsines.servicio;

import ar.edu.utn.frc.dsi.bolsines.control.dto.ResumenRecepcion;
import java.util.List;
import org.springframework.stereotype.Service;

/** No manda mails: arma los avisos para que la pantalla los muestre. Duenio: T2 (Vale). */
@Service
public class NotificacionSimulada implements InterfazNotificacion {

    @Override
    public List<AvisoNotificacion> notificarRecepcion(ResumenRecepcion resumen) {
        throw new UnsupportedOperationException("TODO T2");
    }
}

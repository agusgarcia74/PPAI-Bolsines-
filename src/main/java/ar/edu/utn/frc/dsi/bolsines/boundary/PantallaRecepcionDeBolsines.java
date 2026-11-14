package ar.edu.utn.frc.dsi.bolsines.boundary;

import ar.edu.utn.frc.dsi.bolsines.control.GestorRecepcionDeBolsines;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <<boundary>> del CU 28. Duenio: T7 y T8 (Aznar).
 *
 * En la web, la "pantalla" es este controller mas sus plantillas Thymeleaf. No tiene logica de
 * negocio: recibe el clic, le pide al gestor y muestra lo que devuelve.
 *
 * Lo que hay ahora es una pantalla minima para probar que todo esta conectado. Se reemplaza en
 * T7/T8 siguiendo las pantallas V3 de la UX. Los metodos del diagrama que faltan
 * (habilitarPantalla, mostrarCM, mostrarNroRemito, solicitarConfirmacionRegistro, etc.)
 * los agrega Aznar.
 */
@Controller
public class PantallaRecepcionDeBolsines {

    private final GestorRecepcionDeBolsines gestor;

    public PantallaRecepcionDeBolsines(GestorRecepcionDeBolsines gestor) {
        this.gestor = gestor;
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/recepcion";
    }

    /** Paso 1: el EB selecciona la opcion para registrar la recepcion de un bolsin. */
    @GetMapping("/recepcion")
    public String opcionRegistrarRecepcionDelBolsin(Model model) {
        model.addAttribute("inicio", gestor.opcionRegistrarRecepcionDeBolsin());
        return "recepcion/bandeja";
    }

    /** Paso 5: el EB selecciona un bolsin del listado. */
    @GetMapping("/recepcion/{idBolsin}")
    public String tomarSeleccionBolsin(@PathVariable Long idBolsin, Model model) {
        model.addAttribute("detalle", gestor.tomarSeleccionBolsin(idBolsin));
        return "recepcion/control";
    }
}

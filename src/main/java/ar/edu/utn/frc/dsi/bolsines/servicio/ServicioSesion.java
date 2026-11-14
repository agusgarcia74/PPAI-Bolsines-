package ar.edu.utn.frc.dsi.bolsines.servicio;

import ar.edu.utn.frc.dsi.bolsines.entity.Empleado;
import ar.edu.utn.frc.dsi.bolsines.entity.Sesion;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

/**
 * Login simple y usuario logueado. Duenio: T2 (Vale).
 * Vive en la sesion HTTP: cada navegador tiene su propio usuario logueado.
 */
@Service
@SessionScope
public class ServicioSesion {

    private Sesion sesionActual;

    /** Valida usuario y contraseña y crea la Sesion. Devuelve false si los datos son incorrectos. */
    public boolean iniciarSesion(String usuario, String contrasena) {
        throw new UnsupportedOperationException("TODO T2");
    }

    public void cerrarSesion() {
        throw new UnsupportedOperationException("TODO T2");
    }

    public boolean haySesion() {
        return sesionActual != null;
    }

    public Sesion getSesionActual() {
        return sesionActual;
    }

    /** Camino del diagrama: Sesion.getUsuario() -> Empleado.esTuUsuario() -> el empleado. */
    public Empleado getEmpleadoLogueado() {
        throw new UnsupportedOperationException("TODO T2");
    }
}

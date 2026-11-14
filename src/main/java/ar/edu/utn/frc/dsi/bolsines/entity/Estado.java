package ar.edu.utn.frc.dsi.bolsines.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Estado de un Bolsin o de un Remito (se distinguen por el ambito).
 * OJO: la Documentacion NO usa esta clase. Sus estados son el patron State,
 * en el paquete entity.estado.
 */
@Entity
public class Estado {

    public static final String AMBITO_BOLSIN = "Bolsin";
    public static final String AMBITO_REMITO = "Remito";

    public static final String ENVIADO = "Enviado";
    public static final String RECIBIDO_EN_CM_DESTINO = "Recibido en CM destino";
    public static final String RECIBIDO_Y_ACEPTADO = "Recibido y aceptado";
    public static final String RECIBIDO_Y_ACEPTADO_PARCIAL = "Recibido y aceptado parcial";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String ambito;

    protected Estado() {
    }

    public Estado(String nombre, String descripcion, String ambito) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ambito = ambito;
    }

    public String getName() {
        return nombre;
    }

    public boolean esAmbito(String ambito) {
        return this.ambito != null && this.ambito.equalsIgnoreCase(ambito);
    }

    public boolean esEnviado() {
        return ENVIADO.equalsIgnoreCase(nombre);
    }

    public boolean esRecibidoEnCMDestino() {
        return RECIBIDO_EN_CM_DESTINO.equalsIgnoreCase(nombre);
    }

    public boolean esRecibidoYAceptado() {
        return RECIBIDO_Y_ACEPTADO.equalsIgnoreCase(nombre);
    }

    public boolean esRecibidoYAceptadoParcial() {
        return RECIBIDO_Y_ACEPTADO_PARCIAL.equalsIgnoreCase(nombre);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getAmbito() {
        return ambito;
    }

    public Long getId() {
        return id;
    }
}

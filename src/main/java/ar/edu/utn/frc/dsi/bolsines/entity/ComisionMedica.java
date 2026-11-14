package ar.edu.utn.frc.dsi.bolsines.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ComisionMedica {

    /** Codigo de la Comision Medica Central, la unica que puede redirigir a un area interna. */
    public static final String CODIGO_CENTRAL = "CMC";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String direccion;
    private String email;
    private String name;
    private String telefono;

    protected ComisionMedica() {
    }

    public ComisionMedica(String codigo, String name, String direccion, String email, String telefono) {
        this.codigo = codigo;
        this.name = name;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    public String getName() {
        return name;
    }

    public boolean esCentral() {
        return CODIGO_CENTRAL.equals(codigo);
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }
}

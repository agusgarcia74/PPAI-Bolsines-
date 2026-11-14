package ar.edu.utn.frc.dsi.bolsines.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;

    @OneToOne
    private Usuario usuario;

    @ManyToOne
    private ComisionMedica asignadoA;

    protected Empleado() {
    }

    public Empleado(String nombre, String apellido, String email, Usuario usuario, ComisionMedica asignadoA) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.usuario = usuario;
        this.asignadoA = asignadoA;
    }

    public boolean esTuUsuario(Usuario usuario) {
        return this.usuario != null && usuario != null
                && this.usuario.getName().equals(usuario.getName());
    }

    public ComisionMedica getCM() {
        return asignadoA;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}

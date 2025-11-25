package bdd.webApp.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Jugador")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodJugador")
    private Integer codJugador;

    @Column(name = "Nombre1", length = 50)
    private String nombre1;

    @Column(name = "Nombre2", length = 50)
    private String nombre2;

    @Column(name = "Apellido1", length = 50)
    private String apellido1;

    @Column(name = "Apellido2", length = 50)
    private String apellido2;

    @Column(name = "CodCiudadNacimiento")
    private Integer codCiudadNacimiento;

    @Column(name = "FechaNacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "Numero")
    private Integer numero;

    @Column(name = "CodEquipo")
    private Integer codEquipo;

    public Integer getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(Integer codJugador) {
        this.codJugador = codJugador;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Integer getCodCiudadNacimiento() {
        return codCiudadNacimiento;
    }

    public void setCodCiudadNacimiento(Integer codCiudadNacimiento) {
        this.codCiudadNacimiento = codCiudadNacimiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(Integer codEquipo) {
        this.codEquipo = codEquipo;
    }
}
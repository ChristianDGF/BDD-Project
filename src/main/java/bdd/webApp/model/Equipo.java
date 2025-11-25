package bdd.webApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Equipo")
public class Equipo {

    @Id
    @Column(name = "CodEquipo")
    private Integer codEquipo;

    @Column(name = "Nombre", length = 100)
    private String nombre;

    @Column(name = "CodCiudad")
    private Integer codCiudad;

    public Integer getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(Integer codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(Integer codCiudad) {
        this.codCiudad = codCiudad;
    }
}

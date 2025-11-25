package bdd.webApp.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Juego")
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodJuego")
    private Integer codJuego;

    @Column(name = "Descripcion", length = 200)
    private String descripcion;

    @Column(name = "EquipoLocal")
    private Integer equipoLocal;

    @Column(name = "EquipoVisitante")
    private Integer equipoVisitante;

    @Column(name = "Fecha")
    private LocalDate fecha;

    public Integer getCodJuego() {
        return codJuego;
    }

    public void setCodJuego(Integer codJuego) {
        this.codJuego = codJuego;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Integer equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Integer getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Integer equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
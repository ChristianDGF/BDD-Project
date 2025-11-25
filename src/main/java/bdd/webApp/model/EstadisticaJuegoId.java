package bdd.webApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EstadisticaJuegoId implements Serializable {

    @Column(name = "CodJuego")
    private Integer codJuego;

    @Column(name = "CodEstadistica")
    private Integer codEstadistica;

    @Column(name = "CodJugador")
    private Integer codJugador;

    public EstadisticaJuegoId() {
    }

    public EstadisticaJuegoId(Integer codJuego, Integer codEstadistica, Integer codJugador) {
        this.codJuego = codJuego;
        this.codEstadistica = codEstadistica;
        this.codJugador = codJugador;
    }

    public Integer getCodJuego() {
        return codJuego;
    }

    public void setCodJuego(Integer codJuego) {
        this.codJuego = codJuego;
    }

    public Integer getCodEstadistica() {
        return codEstadistica;
    }

    public void setCodEstadistica(Integer codEstadistica) {
        this.codEstadistica = codEstadistica;
    }

    public Integer getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(Integer codJugador) {
        this.codJugador = codJugador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EstadisticaJuegoId that)) return false;
        return Objects.equals(codJuego, that.codJuego)
                && Objects.equals(codEstadistica, that.codEstadistica)
                && Objects.equals(codJugador, that.codJugador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codJuego, codEstadistica, codJugador);
    }
}

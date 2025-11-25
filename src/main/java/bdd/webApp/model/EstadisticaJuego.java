package bdd.webApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "EstadisticaJuego")
public class EstadisticaJuego {

    @EmbeddedId
    private EstadisticaJuegoId id;

    @Column(name = "Cantidad")
    private Integer cantidad;

    public EstadisticaJuego() {
    }

    public EstadisticaJuego(EstadisticaJuegoId id, Integer cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public EstadisticaJuegoId getId() {
        return id;
    }

    public void setId(EstadisticaJuegoId id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    // Helpers para acceder directamente
    @Transient
    public Integer getCodJuego() {
        return id != null ? id.getCodJuego() : null;
    }

    @Transient
    public Integer getCodEstadistica() {
        return id != null ? id.getCodEstadistica() : null;
    }

    @Transient
    public Integer getCodJugador() {
        return id != null ? id.getCodJugador() : null;
    }
}

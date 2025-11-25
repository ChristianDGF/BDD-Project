package bdd.webApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "EstadisticaJuego")
public class EstadisticaJuego {

    @EmbeddedId
    private EstadisticaJuegoId id;

    @Column(name = "Cantidad")
    private Integer cantidad;

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
}

package bdd.webApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Estadistica")
public class Estadistica {

    @Id
    @Column(name = "CodEstadistica")
    private Integer codEstadistica;

    @Column(name = "Descripcion", length = 100)
    private String descripcion;

    @Column(name = "Valor")
    private Integer valor;

    public Integer getCodEstadistica() {
        return codEstadistica;
    }

    public void setCodEstadistica(Integer codEstadistica) {
        this.codEstadistica = codEstadistica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}

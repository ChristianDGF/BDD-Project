package bdd.webApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Estadistica")
public class Estadistica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodEstadistica")
    private Integer codEstadistica;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Valor")
    private Integer valor;

    public Estadistica() {
    }

    public Estadistica(Integer codEstadistica, String descripcion, Integer valor) {
        this.codEstadistica = codEstadistica;
        this.descripcion = descripcion;
        this.valor = valor;
    }

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

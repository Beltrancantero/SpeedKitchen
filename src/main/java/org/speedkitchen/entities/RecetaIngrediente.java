package org.speedkitchen.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "recetas_ingredientes", schema = "speedkitchen")
public class RecetaIngrediente {

    @EmbeddedId
    private RecetaIngredienteId id = new RecetaIngredienteId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idReceta")
    @JoinColumn(name = "id_receta", nullable = false)
    private Receta receta;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idIngrediente")
    @JoinColumn(name = "id_ingrediente", nullable = false)
    private Ingrediente ingrediente;

    @Column(name = "cantidad", columnDefinition = "NUMERIC", nullable = false)
    private double cantidad;

    @Column(name = "unidad_medida", nullable = false)
    private String unidadMedida;

    public RecetaIngredienteId getId() {
        return id;
    }

    public void setId(RecetaIngredienteId id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }
}

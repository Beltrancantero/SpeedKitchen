package org.speedkitchen.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredientes", schema = "speedkitchen")
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingrediente", unique = true)
    private Long idIngredientes;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombreIngrediente;

    public Long getIdIngredientes() {
        return idIngredientes;
    }

    public void setIdIngredientes(Long idIngredientes) {
        this.idIngredientes = idIngredientes;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }
}



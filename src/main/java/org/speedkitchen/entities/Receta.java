package org.speedkitchen.entities;

import org.speedkitchen.entities.Usuario;
import jakarta.persistence.*;

    @Entity
    @Table(name = "recetas", schema = "speedkitchen")
    public class Receta  {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_receta")
        private Long idReceta;

// @Column(name = "nombre", nullable = false, length = 100)
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id_autor", nullable = false)
        private Usuario autor;

        @Column(name = "nombre", nullable = false, length = 150)
        private String nombreReceta;

        @Column(name = "descripcion", columnDefinition = "TEXT")
        private String descripcionReceta;

        @Column(name = "modo_juego", nullable = false, length = 50)
        private String modoJuego;

        public Long getIdReceta() {
            return idReceta;
        }

        public void setIdReceta(Long idReceta) {
            this.idReceta = idReceta;
        }

        public Usuario getAutor() {
            return autor;
        }

        public void setAutor(Usuario autor) {
            this.autor = autor;
        }

        public String getNombreReceta() {
            return nombreReceta;
        }

        public void setNombreReceta(String nombreReceta) {
            this.nombreReceta = nombreReceta;
        }

        public String getDescripcionReceta() {
            return descripcionReceta;
        }

        public void setDescripcionReceta(String descripcionReceta) {
            this.descripcionReceta = descripcionReceta;
        }

        public String getModoJuego() {
            return modoJuego;
        }

        public void setModoJuego(String modoJuego) {
            this.modoJuego = modoJuego;
        }
    }

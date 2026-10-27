package org.speedkitchen.entities;

import jakarta.persistence.*;

    @Entity
    @Table(name = "amigos", schema = "speedkitchen")
    public class Amigo {

        @EmbeddedId
        private AmigoId id = new AmigoId();

        @ManyToOne(fetch = FetchType.LAZY)
        @MapsId("idUsuarioOrigen")
        @JoinColumn(name = "id_usuario_origen", nullable = false)
        private Usuario usuarioOrigen;

        @ManyToOne(fetch = FetchType.LAZY)
        @MapsId("idUsuarioDestino")
        @JoinColumn(name = "id_usuario_destino", nullable = false)
        private Usuario usuarioDestino;

        @Column(name = "estado_solicitud", nullable = false, length = 20)
        private String estadoSolicitud;

        public AmigoId getId() {
            return id;
        }

        public void setId(AmigoId id) {
            this.id = id;
        }

        public String getEstadoSolicitud() {
            return estadoSolicitud;
        }

        public void setEstadoSolicitud(String estadoSolicitud) {
            this.estadoSolicitud = estadoSolicitud;
        }

        public Usuario getUsuarioDestino() {
            return usuarioDestino;
        }

        public void setUsuarioDestino(Usuario usuarioDestino) {
            this.usuarioDestino = usuarioDestino;
        }

        public Usuario getUsuarioOrigen() {
            return usuarioOrigen;
        }

        public void setUsuarioOrigen(Usuario usuarioOrigen) {
            this.usuarioOrigen = usuarioOrigen;
        }
    }

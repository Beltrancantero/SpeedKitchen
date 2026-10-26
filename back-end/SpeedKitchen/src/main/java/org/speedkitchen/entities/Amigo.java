//package org.speedkitchen.entities;
//
//import jakarta.persistence.*;
//
//    @Entity
//    @Table(name = "amigos", schema = "speedkitchen")
//    public class Amigo {
//
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        @Column(name = "id_usuario_origen")
//        private Long idUsuarioOrigen;
//
//        @ManyToOne(fetch = FetchType.LAZY)
//        @JoinColumn(name = "id_usuario_destino", nullable = false)
//        private Receta idReceta;
//
//        @Column(name = "estado_solitud", nullable = false, columnDefinition = "BOOLEAN")
//        private boolean estadoSolitud;
//    }

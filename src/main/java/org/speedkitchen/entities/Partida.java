package org.speedkitchen.entities;

import org.speedkitchen.entities.Receta;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "partidas", schema = "speedkitchen")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partida")
    private Long idPartida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_receta", nullable = false)
    private Receta idReceta;

    @Column(name = "fecha_creacion", insertable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaCreacionPartida;

    @Column(name = "estado", nullable = false, length = 20)
    private String estadoPartida;

    public Long getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Long idPartida) {
        this.idPartida = idPartida;
    }

    public String getEstadoPartida() {
        return estadoPartida;
    }

    public void setEstadoPartida(String estadoPartida) {
        this.estadoPartida = estadoPartida;
    }

    public LocalDateTime getFechaCreacionPartida() {
        return fechaCreacionPartida;
    }

    public void setFechaCreacionPartida(LocalDateTime fechaCreacionPartida) {
        this.fechaCreacionPartida = fechaCreacionPartida;
    }

    public Receta getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Receta idReceta) {
        this.idReceta = idReceta;
    }
}

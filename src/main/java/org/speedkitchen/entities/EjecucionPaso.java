package org.speedkitchen.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ejecucion_pasos", schema = "speedkitchen")
public class EjecucionPaso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejecucion")
    private Long idEjecucionPaso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jugador_partida", nullable = false)
    private JugadorPartida jugadorPartida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paso", nullable = false)
    private PasosReceta pasoReceta;

    @Column(name = "timestamp_inicio", columnDefinition = "TIMESTAMP")
    private LocalDateTime timestampInicio;

    @Column(name = "timestamp_fin", columnDefinition = "TIMESTAMP")
    private LocalDateTime timestampFin;

    public Long getIdEjecucionPaso() {
        return idEjecucionPaso;
    }

    public void setIdEjecucionPaso(Long idEjecucionPaso) {
        this.idEjecucionPaso = idEjecucionPaso;
    }

    public LocalDateTime getTimestampFin() {
        return timestampFin;
    }

    public void setTimestampFin(LocalDateTime timestampFin) {
        this.timestampFin = timestampFin;
    }

    public LocalDateTime getTimestampInicio() {
        return timestampInicio;
    }

    public void setTimestampInicio(LocalDateTime timestampInicio) {
        this.timestampInicio = timestampInicio;
    }

    public PasosReceta getPasoReceta() {
        return pasoReceta;
    }

    public void setPasoReceta(PasosReceta pasoReceta) {
        this.pasoReceta = pasoReceta;
    }

    public JugadorPartida getJugadorPartida() {
        return jugadorPartida;
    }

    public void setJugadorPartida(JugadorPartida jugadorPartida) {
        this.jugadorPartida = jugadorPartida;
    }
}

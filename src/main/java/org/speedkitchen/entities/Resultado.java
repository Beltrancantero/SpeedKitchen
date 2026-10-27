package org.speedkitchen.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "resultados", schema = "speedkitchen")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resultado")
    private Long idResultado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jugador_partida", nullable = false)
    private JugadorPartida idJugadorPartida;

    @Column(name = "puntuacion_tiempo", nullable = false)
    private Integer puntuacionTiempo;

    @Column(name = "puntuacion_proceso", nullable = false)
    private Integer puntuacionProceso;

    @Column(name = "puntuacion_visual", nullable = false)
    private Integer puntuacionVisual;

    @Column (name = "puntuacion_total", nullable = false)
    private Integer puntuacionTotal;

    public Long getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(Long idResultado) {
        this.idResultado = idResultado;
    }

    public Integer getPuntuacionProgreso() {
        return puntuacionProceso;
    }

    public void setPuntuacionProgreso(Integer puntuacionProgreso) {
        this.puntuacionProceso = puntuacionProgreso;
    }

    public Integer getPuntuacionVisual() {
        return puntuacionVisual;
    }

    public void setPuntuacionVisual(Integer puntuacionVisual) {
        this.puntuacionVisual = puntuacionVisual;
    }

    public Integer getPuntuacionTotal() {
        return puntuacionTotal;
    }

    public void setPuntuacionTotal(Integer puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }

    public Integer getPuntuacionTiempo() {
        return puntuacionTiempo;
    }

    public void setPuntuacionTiempo(Integer puntuacionTiempo) {
        this.puntuacionTiempo = puntuacionTiempo;
    }

    public JugadorPartida getIdJugadorPartida() {
        return idJugadorPartida;
    }

    public void setIdJugadorPartida(JugadorPartida idJugadorPartida) {
        this.idJugadorPartida = idJugadorPartida;
    }
}

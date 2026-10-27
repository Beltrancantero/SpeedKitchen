package org.speedkitchen.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "jugadores_partidas", schema = "speedkitchen")
public class JugadorPartida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador_partida")
    private Long idJugadorPartida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_partida", nullable = false)
    private Partida partida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Long getIdJugadorPartida() {
        return idJugadorPartida;
    }

    public void setIdJugadorPartida(Long idJugadorPartida) {
        this.idJugadorPartida = idJugadorPartida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
}

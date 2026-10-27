package org.speedkitchen.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class AmigoId {

    @Column (name = "id_usuario_origen")
    private Long idUsuarioOrigen;

    @Column (name = "id_usuario_destino")
    private Long idUsuarioDestino;

    public AmigoId() {}

    public Long getIdUsuarioOrigen() {
        return idUsuarioOrigen;
    }

    public void setIdUsuarioOrigen(Long idUsuarioOrigen) {
        this.idUsuarioOrigen = idUsuarioOrigen;
    }

    public Long getIdUsuarioDestino() {
        return idUsuarioDestino;
    }

    public void setIdUsuarioDestino(Long idUsuarioDestino) {
        this.idUsuarioDestino = idUsuarioDestino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmigoId amigoId = (AmigoId) o;
        return Objects.equals(idUsuarioOrigen, amigoId.idUsuarioOrigen) && Objects.equals(idUsuarioDestino, amigoId.idUsuarioDestino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuarioOrigen, idUsuarioDestino);
    }
}

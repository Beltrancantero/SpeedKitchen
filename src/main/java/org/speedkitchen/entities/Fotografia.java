package org.speedkitchen.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "fotografias", schema = "speedkitchen")
public class Fotografia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_fotografia")
    private Long idFotografia;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ejecucion", nullable = false)
    private EjecucionPaso ejecucion;

    @Column (name = "url_fotografia", length = 255, nullable = false)
    private String urlFotografia;

    @Column (name = "puntuacion_ia", columnDefinition = "NUMERIC", nullable = false)
    private Double puntuacionIa;

    public Long getIdFotografia() {
        return idFotografia;
    }

    public void setIdFotografia(Long idFotografia) {
        this.idFotografia = idFotografia;
    }

    public Double getPuntuacionIa() {
        return puntuacionIa;
    }

    public void setPuntuacionIa(Double puntuacionIa) {
        this.puntuacionIa = puntuacionIa;
    }

    public String getUrlFotografia() {
        return urlFotografia;
    }

    public void setUrlFotografia(String urlFotografia) {
        this.urlFotografia = urlFotografia;
    }

    public EjecucionPaso getEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(EjecucionPaso ejecucion) {
        this.ejecucion = ejecucion;
    }
}

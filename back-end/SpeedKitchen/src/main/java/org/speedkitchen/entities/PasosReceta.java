package org.speedkitchen.entities;

import org.speedkitchen.entities.Receta;
import jakarta.persistence.*;

@Entity
@Table(name = "pasos_receta", schema = "speedkitchen")
public class PasosReceta  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paso")
    private Long idPaso;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_receta", nullable = false)
    private Receta receta;

    @Column(name = "orden", nullable = false)
    private Integer ordenPaso;

    @Column(name = "descripcion", columnDefinition = "TEXT", nullable = false)
    private String descripcionPaso;

    @Column(name = "es_critico", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean esCritico;

    @Column(name = "url_imagen_referencia", length = 255)
    private String urlImagenReferencia;

    public Long getIdPaso() {
        return idPaso;
    }

    public void setIdPaso(Long idPaso) {
        this.idPaso = idPaso;
    }

    public String getUrlImagenReferencia() {
        return urlImagenReferencia;
    }

    public void setUrlImagenReferencia(String urlImagenReferencia) {
        this.urlImagenReferencia = urlImagenReferencia;
    }

    public Boolean getEsCritico() {
        return esCritico;
    }

    public void setEsCritico(Boolean esCritico) {
        this.esCritico = esCritico;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Integer getOrdenPaso() {
        return ordenPaso;
    }

    public void setOrdenPaso(Integer ordenPaso) {
        this.ordenPaso = ordenPaso;
    }

    public String getDescripcionPaso() {
        return descripcionPaso;
    }

    public void setDescripcionPaso(String descripcionPaso) {
        this.descripcionPaso = descripcionPaso;
    }
}
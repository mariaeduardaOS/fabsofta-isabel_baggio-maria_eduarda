package br.univille.restochefmaisa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Substituicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ingredienteOriginal;
    private String ingredienteSubstituto;
    private String motivo; // exemplo: "alergia", "falta na despensa", etc.

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIngredienteOriginal() {
        return ingredienteOriginal;
    }

    public void setIngredienteOriginal(String ingredienteOriginal) {
        this.ingredienteOriginal = ingredienteOriginal;
    }

    public String getIngredienteSubstituto() {
        return ingredienteSubstituto;
    }

    public void setIngredienteSubstituto(String ingredienteSubstituto) {
        this.ingredienteSubstituto = ingredienteSubstituto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    // Métodos esperados pelo controller
    public String getJustificativa() {
        return this.motivo;
    }

    public void setJustificativa(String justificativa) {
        this.motivo = justificativa;
    }
}
package br.univille.restochefmaisa.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ElementCollection
    private List<String> ingredientes;
    private String modoPreparo;

    private Long idUsuario;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<String> getIngredientes() { return ingredientes; }
    public void setIngredientes(List<String> ingredientes) { this.ingredientes = ingredientes; }

    public String getModoPreparo() { return modoPreparo; }
    public void setModoPreparo(String modoPreparo) { this.modoPreparo = modoPreparo; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
}
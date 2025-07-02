package br.univille.restochefmaisa.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

<<<<<<< HEAD
    @ElementCollection
    private List<String> ingredientes;
    private String modoPreparo;

    private Long idUsuario;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
=======
    private String modoPreparo;

    @ElementCollection
    @CollectionTable(name = "receita_ingredientes", joinColumns = @JoinColumn(name = "receita_id"))
    private List<Ingrediente> ingredientes;
>>>>>>> 30f1ba3926ed262b67813604846f5357708b7146

    // getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

<<<<<<< HEAD
    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
=======
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
>>>>>>> 30f1ba3926ed262b67813604846f5357708b7146
}
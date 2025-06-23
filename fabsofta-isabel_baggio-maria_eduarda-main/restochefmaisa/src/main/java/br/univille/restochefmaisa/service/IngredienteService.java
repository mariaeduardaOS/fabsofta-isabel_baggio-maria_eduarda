package br.univille.restochefmaisa.service;

import java.util.List;

import br.univille.restochefmaisa.entity.Ingrediente;

public interface IngredienteService {
    Ingrediente save(Ingrediente acessorios);
    List<Ingrediente> getAll();
    Ingrediente getById(long id);
    Ingrediente delete(long id);
}

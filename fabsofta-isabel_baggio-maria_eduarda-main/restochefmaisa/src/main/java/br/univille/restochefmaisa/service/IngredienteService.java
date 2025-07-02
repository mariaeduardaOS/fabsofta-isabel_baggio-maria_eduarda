package br.univille.restochefmaisa.service;

import java.util.List;

import br.univille.restochefmaisa.entity.Ingrediente;

public interface IngredienteService {
    Ingrediente save(Ingrediente ingrediente);
    Ingrediente delete(long id);
    List<Ingrediente> getAll();
    Ingrediente getById(long id);
}

package br.univille.restochefmaisa.service;

import java.util.List;

import br.univille.restochefmaisa.entity.Receita;

public interface ReceitaService {
    Receita save(Receita a);
    List<Receita> getAll();
    Receita getById(long id);
    void delete(long id);
    List<Receita> findByIdUsuario(Long idUsuario);
    List<Receita> findByIngredientes(List<String> ingredientes);
}
package br.univille.restochefmaisa.service;

import java.util.List;

import br.univille.restochefmaisa.entity.Receita;

public interface ReceitaService {

    Receita save(Receita receita);

    void delete(long id);

    Receita getById(long id);

    List<Receita> getAll();

    List<Receita> buscarPorIngredientes(List<String> ingredientes);

}
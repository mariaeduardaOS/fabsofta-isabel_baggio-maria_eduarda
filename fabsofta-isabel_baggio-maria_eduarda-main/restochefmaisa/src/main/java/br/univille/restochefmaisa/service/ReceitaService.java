package br.univille.restochefmaisa.service;

import java.util.List;

import br.univille.restochefmaisa.entity.Receita;

public interface ReceitaService {

    Receita save(Receita receita);

    void delete(long id);

    Receita getById(long id);
<<<<<<< HEAD
    void delete(long id);
    List<Receita> findByIdUsuario(Long idUsuario);
    List<Receita> findByIngredientes(List<String> ingredientes);
=======

    List<Receita> getAll();

    List<Receita> buscarPorIngredientes(List<String> ingredientes);

>>>>>>> 30f1ba3926ed262b67813604846f5357708b7146
}
package br.univille.restochefmaisa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.restochefmaisa.entity.Receita;
import br.univille.restochefmaisa.repository.ReceitaRepository;
import br.univille.restochefmaisa.service.ReceitaService;

@Service
public class ReceitaServiceImpl implements ReceitaService {

    @Autowired
    private ReceitaRepository repository;

    @Override
    public Receita save(Receita receita) {
        return repository.save(receita);
    }

    @Override
    public Receita delete(long id) {
        Receita receita = getById(id);
        if (receita != null)
            repository.deleteById(id);
        return receita;
    }

    @Override
    public Receita getById(long id) {
        java.util.Optional<Receita> retorno = repository.findById(id);
        return retorno.orElse(null);
    }

    @Override
    public List<Receita> buscarPorIngredientes(List<String> ingredientes) {
        return repository.buscarReceitasPorIngredientes(ingredientes, ingredientes.size());
    }

    @Override
    public List<Receita> getAll() {
        return repository.findAll();
    }
}
package br.univille.restochefmaisa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.restochefmaisa.entity.Ingrediente;
import br.univille.restochefmaisa.repository.IngredienteRepository;
import br.univille.restochefmaisa.service.IngredienteService;

@Service
public class IngredienteServiceImpl implements IngredienteService {

    @Autowired
    private IngredienteRepository repository;

    @Override
    public Ingrediente save(Ingrediente ingrediente) {
        return repository.save(ingrediente);
    }

    @Override
    public Ingrediente delete(long id) {
        var ingrediente = getById(id);
        if (ingrediente != null)
            repository.deleteById(id);
        return ingrediente;
    }

    @Override
    public List<Ingrediente> getAll() {
        return repository.findAll();
    }

    @Override
    public Ingrediente getById(long id) {
        var retorno = repository.findById(id);
        return retorno.orElse(null);
    }
}

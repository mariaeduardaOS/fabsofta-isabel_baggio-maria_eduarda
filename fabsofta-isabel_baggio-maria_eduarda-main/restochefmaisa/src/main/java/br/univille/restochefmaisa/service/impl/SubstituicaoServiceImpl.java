package br.univille.restochefmaisa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.restochefmaisa.entity.Substituicao;
import br.univille.restochefmaisa.repository.SubstituicaoRepository;
import br.univille.restochefmaisa.service.SubstituicaoService;

@Service
public class SubstituicaoServiceImpl implements SubstituicaoService {

    @Autowired
    private SubstituicaoRepository repository;

    @Override
    public Substituicao save(Substituicao substituicao) {
        return repository.save(substituicao);
    }

    @Override
    public Substituicao delete(long id) {
        var substituicao = getById(id);
        if (substituicao != null)
            repository.deleteById(id);
        return substituicao;
    }

    @Override
    public List<Substituicao> getAll() {
        return repository.findAll();
    }

    @Override
    public Substituicao getById(long id) {
        var retorno = repository.findById(id);
        return retorno.orElse(null);
    }
}

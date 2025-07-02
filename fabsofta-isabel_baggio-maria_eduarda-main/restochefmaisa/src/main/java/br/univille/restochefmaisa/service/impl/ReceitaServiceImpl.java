package br.univille.restochefmaisa.service.impl;

import br.univille.restochefmaisa.entity.Receita;
import br.univille.restochefmaisa.repository.ReceitaRepository;
import br.univille.restochefmaisa.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceitaServiceImpl implements ReceitaService {

    @Autowired
    private ReceitaRepository repository;

    @Override
    public Receita save(Receita receita) {
        return repository.save(receita);
    }

    @Override
    public List<Receita> getAll() {
        return repository.findAll();
    }

    @Override
    public Receita getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Receita> findByIdUsuario(Long idUsuario) {
        return repository.findByIdUsuario(idUsuario);
    }

    @Override
    public List<Receita> findByIngredientes(List<String> ingredientes) {
        List<Receita> todasReceitas = repository.findAll();
        return todasReceitas.stream()
                .filter(receita -> ingredientes.stream()
                        .allMatch(ing -> receita.getIngredientes().contains(ing)))
                .collect(Collectors.toList());
    }
}
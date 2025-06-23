package br.univille.restochefmaisa.service;

import java.util.List;

import br.univille.restochefmaisa.entity.Substituicao;

public interface SubstituicaoService {
    Substituicao save(Substituicao acessorios);
    List<Substituicao> getAll();
    Substituicao getById(long id);
    Substituicao delete(long id);

}

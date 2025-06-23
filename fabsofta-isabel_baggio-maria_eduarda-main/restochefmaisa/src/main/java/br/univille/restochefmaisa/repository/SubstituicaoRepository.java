package br.univille.restochefmaisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.restochefmaisa.entity.Substituicao;

@Repository
public interface SubstituicaoRepository extends JpaRepository<Substituicao, Long> {
}

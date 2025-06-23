package br.univille.restochefmaisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.restochefmaisa.entity.Receita;

@Repository
public interface ReceitaRepository 
    extends JpaRepository<Receita, Long> {
}

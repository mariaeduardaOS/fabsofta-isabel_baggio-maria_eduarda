package br.univille.restochefmaisa.repository;

import br.univille.restochefmaisa.entity.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    List<Receita> findByIdUsuario(Long idUsuario);
}
package br.univille.restochefmaisa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.restochefmaisa.entity.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    @Query("SELECT r FROM Receita r JOIN r.ingredientes i WHERE i IN :ingredientes GROUP BY r.id HAVING COUNT(DISTINCT i) = :qtd")
    List<Receita> buscarReceitasPorIngredientes(@Param("ingredientes") List<String> ingredientes, @Param("qtd") long qtd);

}
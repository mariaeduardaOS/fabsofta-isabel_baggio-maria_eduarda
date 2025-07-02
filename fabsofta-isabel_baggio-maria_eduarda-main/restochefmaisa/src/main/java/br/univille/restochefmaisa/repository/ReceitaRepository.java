package br.univille.restochefmaisa.repository;

<<<<<<< HEAD
import br.univille.restochefmaisa.entity.Receita;
=======
import java.util.List;

>>>>>>> 30f1ba3926ed262b67813604846f5357708b7146
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
<<<<<<< HEAD
    List<Receita> findByIdUsuario(Long idUsuario);
=======

    @Query("SELECT r FROM Receita r JOIN r.ingredientes i WHERE i IN :ingredientes GROUP BY r.id HAVING COUNT(DISTINCT i) = :qtd")
    List<Receita> buscarReceitasPorIngredientes(@Param("ingredientes") List<String> ingredientes, @Param("qtd") long qtd);

>>>>>>> 30f1ba3926ed262b67813604846f5357708b7146
}
package br.univille.restochefmaisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.univille.restochefmaisa.entity.Receita;
import br.univille.restochefmaisa.service.ReceitaService;

@RestController
@RequestMapping("/api/v1/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService service;

    @GetMapping
    public ResponseEntity<List<Receita>> getReceitas() {
        var listaReceitas = service.getAll();
        return new ResponseEntity<>(listaReceitas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> getReceitaById(@PathVariable long id) {
        var receita = service.getById(id);
        if (receita == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(receita, HttpStatus.OK);
    }

    @GetMapping("/usuarios/{idUsuario}")
    public ResponseEntity<List<Receita>> getReceitasByUsuario(@PathVariable Long idUsuario) {
        var listaReceitas = service.findByIdUsuario(idUsuario);
        if (listaReceitas.isEmpty()) {
            return new ResponseEntity<>(listaReceitas, HttpStatus.OK);
        }
        return new ResponseEntity<>(listaReceitas, HttpStatus.OK);
    }

    @GetMapping("/buscar-por-ingredientes")
    public ResponseEntity<List<Receita>> buscarReceitasPorIngredientes(@RequestParam List<String> ingredientes) {
        var receitasEncontradas = service.findByIngredientes(ingredientes);
        if (receitasEncontradas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(receitasEncontradas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Receita> postReceita(@RequestBody Receita receita) {
        if (receita == null || receita.getId() != 0) {
            return ResponseEntity.badRequest().build();
        }
        service.save(receita);
        return new ResponseEntity<>(receita, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> putReceita(@PathVariable long id, @RequestBody Receita receita) {
        if (id <= 0 || receita == null) {
            return ResponseEntity.badRequest().build();
        }

        var receitaAntiga = service.getById(id);
        if (receitaAntiga == null) {
            return ResponseEntity.notFound().build();
        }

        receitaAntiga.setIdUsuario(receita.getIdUsuario());
        receitaAntiga.setIngredientes(receita.getIngredientes());
        receitaAntiga.setModoPreparo(receita.getModoPreparo());
        receitaAntiga.setNome(receita.getNome());

        service.save(receitaAntiga);
        return new ResponseEntity<>(receitaAntiga, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceita(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }

        var receitaExcluir = service.getById(id);
        if (receitaExcluir == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
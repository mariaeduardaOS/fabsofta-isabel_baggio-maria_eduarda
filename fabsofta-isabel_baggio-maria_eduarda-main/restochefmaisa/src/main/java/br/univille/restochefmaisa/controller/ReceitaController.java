package br.univille.restochefmaisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

        return new ResponseEntity<List<Receita>>(listaReceitas, HttpStatus.OK);
    }


    // Criar nova receita
    @PostMapping
    public ResponseEntity<Receita> postReceita(@RequestBody Receita receita) {
        if (receita == null || receita.getNome() == null || receita.getNome().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Não deve vir ID definido na criação, o banco gera
        if (receita.getId() != null && receita.getId() > 0) {
            return ResponseEntity.badRequest().build();
        }

        Receita novaReceita = service.save(receita);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaReceita);
    }

    // Atualizar receita existente
    @PutMapping("/{id}")
    public ResponseEntity<Receita> putReceita(@PathVariable long id, @RequestBody Receita receita) {
        if (id <= 0 || receita == null) {
            return ResponseEntity.badRequest().build();
        }

        Receita receitaAntiga = service.getById(id);
        if (receitaAntiga == null) {
            return ResponseEntity.notFound().build();
        }

        receitaAntiga.setIngredientes(receita.getIngredientes());
        receitaAntiga.setModoPreparo(receita.getModoPreparo());
        receitaAntiga.setNome(receita.getNome());

        Receita atualizada = service.save(receitaAntiga);
        return ResponseEntity.ok(atualizada);
    }

    // Deletar receita por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceita(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }

        Receita receitaExcluir = service.getById(id);
        if (receitaExcluir == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar receitas por lista de ingredientes
    @GetMapping("/buscar")
    public ResponseEntity<List<Receita>> buscarPorIngredientes(@RequestParam List<String> ingredientes) {
        if (ingredientes == null || ingredientes.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        List<Receita> receitas = service.buscarPorIngredientes(ingredientes);
        return ResponseEntity.ok(receitas);
    }
}

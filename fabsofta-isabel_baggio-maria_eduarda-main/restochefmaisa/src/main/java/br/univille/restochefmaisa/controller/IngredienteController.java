package br.univille.restochefmaisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.restochefmaisa.entity.Ingrediente;
import br.univille.restochefmaisa.service.IngredienteService;

@RestController
@RequestMapping("/api/v1/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteService service;

    @GetMapping
    public ResponseEntity<List<Ingrediente>> getAllIngredientes() {
        List<Ingrediente> ingredientes = service.getAll();
        return ResponseEntity.ok(ingredientes);
    }

    @PostMapping
    public ResponseEntity<Ingrediente> createIngrediente(@RequestBody Ingrediente ingrediente) {
        if (ingrediente == null || ingrediente.getId() != null) {
            return ResponseEntity.badRequest().build();
        }

        Ingrediente novoIngrediente = service.save(ingrediente);
        return ResponseEntity.status(201).body(novoIngrediente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingrediente> updateIngrediente(@PathVariable Long id,
                                                         @RequestBody Ingrediente ingrediente) {
        if (ingrediente == null || id == null || id <= 0) {
            return ResponseEntity.badRequest().build();
        }

        Ingrediente existente = service.getById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        existente.setNome(ingrediente.getNome());

        Ingrediente atualizado = service.save(existente);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngrediente(@PathVariable Long id) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().build();
        }

        Ingrediente existente = service.getById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
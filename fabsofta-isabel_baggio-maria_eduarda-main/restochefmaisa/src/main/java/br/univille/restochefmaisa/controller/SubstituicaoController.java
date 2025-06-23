package br.univille.restochefmaisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.univille.restochefmaisa.entity.Substituicao;
import br.univille.restochefmaisa.service.SubstituicaoService;

@RestController
@RequestMapping("/api/v1/substituicoes")
public class SubstituicaoController {

    @Autowired
    private SubstituicaoService service;

    @GetMapping
    public ResponseEntity<List<Substituicao>> getSubstituicoes() {
        var lista = service.getAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Substituicao> postSubstituicao(@RequestBody Substituicao substituicao) {
        if (substituicao == null) {
            return ResponseEntity.badRequest().build();
        }
        if (substituicao.getId() == 0) {
            service.save(substituicao);
            return new ResponseEntity<>(substituicao, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Substituicao> putSubstituicao(@PathVariable long id,
                                                        @RequestBody Substituicao substituicao) {
        if (id <= 0 || substituicao == null) {
            return ResponseEntity.badRequest().build();
        }

        var substituicaoAntiga = service.getById(id);
        if (substituicaoAntiga == null) {
            return ResponseEntity.notFound().build();
        }

        substituicaoAntiga.setIngredienteOriginal(substituicao.getIngredienteOriginal());
        substituicaoAntiga.setIngredienteSubstituto(substituicao.getIngredienteSubstituto());
        substituicaoAntiga.setJustificativa(substituicao.getJustificativa());

        service.save(substituicaoAntiga);
        return new ResponseEntity<>(substituicaoAntiga, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Substituicao> deleteSubstituicao(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }

        var substituicaoExcluir = service.getById(id);
        if (substituicaoExcluir == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return new ResponseEntity<>(substituicaoExcluir, HttpStatus.OK);
    }
}

package br.univille.restochefmaisa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/") 
public class HomeController {

    @GetMapping
    public String home() {
        return "Bem-vindo à minha API de Receitas!";
    }
}
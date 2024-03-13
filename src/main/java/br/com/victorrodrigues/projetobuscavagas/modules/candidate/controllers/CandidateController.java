package br.com.victorrodrigues.projetobuscavagas.modules.candidate.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorrodrigues.projetobuscavagas.modules.candidate.CandidateEntity;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/candidate")
@RestController
public class CandidateController {
    @PostMapping("/") 
    public void create(@Valid @RequestBody CandidateEntity candidateEntity){
        System.out.println("Candidato");
        System.out.println(candidateEntity.getEmail());
    }
}

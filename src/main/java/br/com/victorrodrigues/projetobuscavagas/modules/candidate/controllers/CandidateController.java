package br.com.victorrodrigues.projetobuscavagas.modules.candidate.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorrodrigues.projetobuscavagas.modules.candidate.CandidateEntity;
import br.com.victorrodrigues.projetobuscavagas.modules.candidate.CandidateRepository;
import br.com.victorrodrigues.projetobuscavagas.modules.exceptions.UserFoundException;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequestMapping("/candidate")
@RestController
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;
    @PostMapping("/") 
    public CandidateEntity create(@Valid @RequestBody CandidateEntity candidateEntity){
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(),candidateEntity.getEmail()).ifPresent((user)->{
            throw new UserFoundException();
        });
        
        return this.candidateRepository.save(candidateEntity);
    
    }
}

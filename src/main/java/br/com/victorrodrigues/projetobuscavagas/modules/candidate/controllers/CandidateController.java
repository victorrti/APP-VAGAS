package br.com.victorrodrigues.projetobuscavagas.modules.candidate.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorrodrigues.projetobuscavagas.modules.candidate.CandidateEntity;
import br.com.victorrodrigues.projetobuscavagas.modules.candidate.CandidateRepository;
import br.com.victorrodrigues.projetobuscavagas.modules.candidate.useCases.CreateCandidateUseCase;
import br.com.victorrodrigues.projetobuscavagas.modules.exceptions.UserFoundException;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequestMapping("/candidate")
@RestController
public class CandidateController {
    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;
    @PostMapping("/") 
    public ResponseEntity<Object>  create(@Valid @RequestBody CandidateEntity candidateEntity){
        try{
            var result =  createCandidateUseCase.execute(candidateEntity);          
            return ResponseEntity.ok().body(result);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage()) ;
        }
       
    
    }
}

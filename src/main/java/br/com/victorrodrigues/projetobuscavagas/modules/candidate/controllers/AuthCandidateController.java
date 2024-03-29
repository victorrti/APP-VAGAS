package br.com.victorrodrigues.projetobuscavagas.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.victorrodrigues.projetobuscavagas.modules.candidate.dto.AuthCandidateRequestDTO;
import br.com.victorrodrigues.projetobuscavagas.modules.candidate.useCases.AuthCandidateUseCase;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/candidate")
public class AuthCandidateController {
    @Autowired
    private AuthCandidateUseCase authCandidateUseCase;
    @PostMapping("/auth/")
    public ResponseEntity<Object> auth(@RequestBody AuthCandidateRequestDTO authCandidateRequestDTO) {
        try{
            var token = this.authCandidateUseCase.execute(authCandidateRequestDTO);
            return ResponseEntity.ok().body(token);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
        
        
    }
    
}

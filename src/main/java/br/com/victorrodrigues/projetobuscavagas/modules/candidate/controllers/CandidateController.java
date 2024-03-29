package br.com.victorrodrigues.projetobuscavagas.modules.candidate.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorrodrigues.projetobuscavagas.modules.candidate.dto.ProfileCandidateResponseDTO;
import br.com.victorrodrigues.projetobuscavagas.modules.candidate.entity.CandidateEntity;

import br.com.victorrodrigues.projetobuscavagas.modules.candidate.useCases.CreateCandidateUseCase;
import br.com.victorrodrigues.projetobuscavagas.modules.candidate.useCases.ProfileCandidateUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequestMapping("/candidate")
@RestController
public class CandidateController {
    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @Autowired
    private ProfileCandidateUseCase profileCandidateUseCase;

    @PostMapping("/") 
    public ResponseEntity<Object>  create(@Valid @RequestBody CandidateEntity candidateEntity){
        try{
            var result =  createCandidateUseCase.execute(candidateEntity);          
            return ResponseEntity.ok().body(result);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('candidate')")
    public ResponseEntity<Object> getprofile(HttpServletRequest request){
        try{
            var id = request.getAttribute("candidate_id");
            var profile = this.profileCandidateUseCase.execute(UUID.fromString(id.toString()));
            return ResponseEntity.ok().body(profile);
        }catch(Exception e){
          return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

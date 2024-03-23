package br.com.victorrodrigues.projetobuscavagas.modules.company.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.victorrodrigues.projetobuscavagas.modules.company.entities.CompanyEntities;
import br.com.victorrodrigues.projetobuscavagas.modules.company.useCase.CreateCompanyUseCase;
import br.com.victorrodrigues.projetobuscavagas.modules.exceptions.UserFoundException;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;
        @PostMapping("/")
        public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntities companyEntities) {
        try{
           var result = this.createCompanyUseCase.execute(companyEntities);
           return ResponseEntity.ok().body(result);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
            
    }
              
        
}

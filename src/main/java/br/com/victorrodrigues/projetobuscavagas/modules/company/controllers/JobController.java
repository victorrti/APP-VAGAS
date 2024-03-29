package br.com.victorrodrigues.projetobuscavagas.modules.company.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorrodrigues.projetobuscavagas.modules.company.dto.CreateJobDTO;
import br.com.victorrodrigues.projetobuscavagas.modules.company.entities.JobEntity;
import br.com.victorrodrigues.projetobuscavagas.modules.company.useCase.CreateJobUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private CreateJobUseCase  createJobUseCase;
    @RequestMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody  CreateJobDTO createJobDTO,HttpServletRequest request){
        try{
            var companyId = request.getAttribute("company_id");
            
           var jobEntity = JobEntity.builder()
            .benefits(createJobDTO.getBenefits())
            .companyId(UUID.fromString(companyId.toString()))
            .description(createJobDTO.getDescription())
            .level(createJobDTO.getLevel()).build();

            var result = this.createJobUseCase.execute(jobEntity);            
            return ResponseEntity.status(201).body(result);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

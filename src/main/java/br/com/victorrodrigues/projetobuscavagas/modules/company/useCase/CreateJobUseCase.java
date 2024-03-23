package br.com.victorrodrigues.projetobuscavagas.modules.company.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.victorrodrigues.projetobuscavagas.modules.company.entities.JobEntity;
import br.com.victorrodrigues.projetobuscavagas.modules.company.repositories.JobRepository;
import br.com.victorrodrigues.projetobuscavagas.modules.exceptions.UserFoundException;
import jakarta.validation.Valid;

@Service
public class CreateJobUseCase {
    @Autowired
    JobRepository JobRepository;
    public JobEntity execute( JobEntity jobEntity){  
          return this.JobRepository.save(jobEntity);
    }
}

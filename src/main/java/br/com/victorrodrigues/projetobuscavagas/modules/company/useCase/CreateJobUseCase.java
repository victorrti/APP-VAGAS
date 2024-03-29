package br.com.victorrodrigues.projetobuscavagas.modules.company.useCase;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import br.com.victorrodrigues.projetobuscavagas.modules.company.entities.JobEntity;
import br.com.victorrodrigues.projetobuscavagas.modules.company.repositories.JobRepository;


@Service
public class CreateJobUseCase {
    @Autowired
    JobRepository JobRepository;
    public JobEntity execute( JobEntity jobEntity){  
          return this.JobRepository.save(jobEntity);
    }
}

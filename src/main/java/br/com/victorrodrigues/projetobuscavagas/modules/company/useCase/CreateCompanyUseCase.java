package br.com.victorrodrigues.projetobuscavagas.modules.company.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorrodrigues.projetobuscavagas.modules.company.entities.CompanyEntities;
import br.com.victorrodrigues.projetobuscavagas.modules.company.repositories.CompanyRepository;
import br.com.victorrodrigues.projetobuscavagas.modules.exceptions.UserFoundException;

@Service
public class CreateCompanyUseCase{
    @Autowired
    private CompanyRepository companyRepository;
    public CompanyEntities execute(CompanyEntities companyEntities){
        this.companyRepository.findByUsernameOrEmail(companyEntities.getUsername(), companyEntities.getEmail())
        .ifPresent((user)->{
            throw new UserFoundException();       
         });
        return this.companyRepository.save(companyEntities);
    }
}

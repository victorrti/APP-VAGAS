package br.com.victorrodrigues.projetobuscavagas.modules.company.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.victorrodrigues.projetobuscavagas.modules.company.entities.CompanyEntities;
import br.com.victorrodrigues.projetobuscavagas.modules.company.repositories.CompanyRepository;
import br.com.victorrodrigues.projetobuscavagas.modules.exceptions.UserFoundException;

@Service
public class CreateCompanyUseCase{
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public CompanyEntities execute(CompanyEntities companyEntities){
        this.companyRepository.findByUsernameOrEmail(companyEntities.getUsername(), companyEntities.getEmail())
        .ifPresent((user)->{
            throw new UserFoundException();       
         });
         var password = passwordEncoder.encode(companyEntities.getPassword());
         companyEntities.setPassword(password);
        return this.companyRepository.save(companyEntities);
    }
}

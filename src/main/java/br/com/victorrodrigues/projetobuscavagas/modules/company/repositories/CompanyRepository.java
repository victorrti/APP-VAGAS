package br.com.victorrodrigues.projetobuscavagas.modules.company.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victorrodrigues.projetobuscavagas.modules.company.entities.CompanyEntities;

public interface CompanyRepository extends JpaRepository<CompanyEntities,UUID>{
    Optional<CompanyEntities> findByUsernameOrEmail(String username,String  email);
   Optional<CompanyEntities> findByUsername(String username);
}

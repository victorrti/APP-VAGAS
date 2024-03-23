package br.com.victorrodrigues.projetobuscavagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NonNull;

@Entity(name="company")
@Data
public class CompanyEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank()
    
    @Pattern(regexp = "\\S+", message="O campo [username] não deve conter espaços vazios")
    private String username;
    @Email(message="digite o campo (E-mail) valido")
    private String email;
    @Length(min=10,max=100)
    private String password;
    private String name;
    private String description;

    @CreationTimestamp
    private LocalDateTime createAt;
 
}

package br.com.victorrodrigues.projetobuscavagas.modules.candidate;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {
    private String UUID;
    private String name;
    @NotBlank()
    @Pattern(regexp = "\\S+", message="O campo [username] não deve conter espaços vazios")
    private String username;
    @Email(message="digite o campo (E-mail) valido")
    private String email;
    @Length(min=10,max=100)
    private String password;
    private String description;
    private String curriculo;
    
}

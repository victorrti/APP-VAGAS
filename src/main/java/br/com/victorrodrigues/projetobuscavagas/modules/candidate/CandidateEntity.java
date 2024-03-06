package br.com.victorrodrigues.projetobuscavagas.modules.candidate;

import lombok.Data;

@Data
public class CandidateEntity {
    private String UUID;
    private String name;
    private String username;
    private String email;
    private String password;
    private String description;
    private String curriculo;
    
}

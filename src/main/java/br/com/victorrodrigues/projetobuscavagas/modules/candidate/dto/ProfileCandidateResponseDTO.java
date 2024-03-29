package br.com.victorrodrigues.projetobuscavagas.modules.candidate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileCandidateResponseDTO {
    private String name;
    private String email;
    private String description;
    private String curriculo;
    private String id;
}

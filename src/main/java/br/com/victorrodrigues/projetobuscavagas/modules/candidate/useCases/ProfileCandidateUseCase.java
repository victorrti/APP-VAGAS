package br.com.victorrodrigues.projetobuscavagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.victorrodrigues.projetobuscavagas.modules.candidate.dto.ProfileCandidateResponseDTO;
import br.com.victorrodrigues.projetobuscavagas.modules.candidate.repository.CandidateRepository;

@Service
public class ProfileCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;
    public ProfileCandidateResponseDTO execute(UUID idCandidate){
        var candidate = this.candidateRepository.findById(idCandidate).orElseThrow(()->{
            throw new UsernameNotFoundException("User not faund");
        });
        var candidateDTO = ProfileCandidateResponseDTO.builder()
        .description(candidate.getDescription())
        .email(candidate.getEmail())
        .name(candidate.getName())
        .curriculo(candidate.getCurriculo())
        .id(candidate.getId().toString()).build();

        return candidateDTO;
    }
}

package br.com.victorrodrigues.projetobuscavagas.modules.candidate.useCases;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.victorrodrigues.projetobuscavagas.modules.candidate.CandidateRepository;
import br.com.victorrodrigues.projetobuscavagas.modules.candidate.dto.AuthCandidateRequestDTO;
import br.com.victorrodrigues.projetobuscavagas.modules.candidate.dto.AuthCandidateResponseDTO;


public class AuthCandidateUseCase {
    @Value("${security.token.secret.candidate}")
    private String secretKey;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public AuthCandidateResponseDTO execute(AuthCandidateRequestDTO authCandidateRequestDTO ) throws AuthenticationException{
        var candidate = this.candidateRepository.findByUsername(authCandidateRequestDTO.password()).orElseThrow(()->{
            throw new UsernameNotFoundException("Username/password incorrect");
        });
        var passwordMatches = this.passwordEncoder.matches(authCandidateRequestDTO.password(), candidate.getPassword());
        if(!passwordMatches){
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var token = JWT.create()
        .withIssuer("victor")
        .withSubject(candidate.getId().toString())
        .withClaim("roles",Arrays.asList("candidate"))
        .withExpiresAt(Instant.now().plus(Duration.ofMinutes(10)))
        .sign(algorithm);
        
        
       var authCandidateResponseDTO =  AuthCandidateResponseDTO.builder().acess_token(token).build();
       return authCandidateResponseDTO;
    }
}

package br.com.victorrodrigues.projetobuscavagas.security;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.victorrodrigues.projetobuscavagas.providers.JWTProvider;
import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
   @Autowired
    private JWTProvider jwtProvider;
    @Override
    protected void doFilterInternal(@Nonnull HttpServletRequest request,@Nonnull HttpServletResponse response,@Nonnull FilterChain filterChain)
            throws ServletException, IOException {
                SecurityContextHolder.getContext().setAuthentication(null);
               String header = request.getHeader("Authorization");
               if(header != null){
                   var subject = this.jwtProvider.validateToken(header);
                   if(subject.isEmpty()){
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                   }
                   request.setAttribute("company_id", subject);
                   UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(subject,null,Collections.emptyList());
                   SecurityContextHolder.getContext().setAuthentication(auth);
               }

                filterChain.doFilter(request, response);

        
    }   
    
}

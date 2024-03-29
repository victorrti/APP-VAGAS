package br.com.victorrodrigues.projetobuscavagas.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;



@Service
public class JWTProvider {
      @Autowired
     @Value("${security.token.secret}")
     private String secretKey;

    public String validateToken(String token){

        token = token.replace("Bearer ","");
        try{
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
          var subject =  JWT.require(algorithm)
            .build()
            .verify(token)
            .getSubject();
            return subject;
        }catch(JWTVerificationException e){
            e.printStackTrace();;
            return"";
        }
    }
}

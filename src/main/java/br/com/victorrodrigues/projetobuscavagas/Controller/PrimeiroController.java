package br.com.victorrodrigues.projetobuscavagas.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;





@RestController
@RequestMapping("/primeiraController")
public class PrimeiroController {
    @GetMapping("/primeiroMetodo/{id}")
    public String primeiroMetodo(@PathVariable String id) {
        return "O parametro e : "+id;
    }

   
   
    @GetMapping("/queryParams")
    public String MetodoQueryParams(@RequestParam String id){
        return "query params :"+id;
    }

    @GetMapping("/queryParams2")
    public String MetodoQueryParams2(@RequestParam Map<String,String> allParams){
        
        return "query params :"+ allParams;
    }
    
    @PostMapping("/body")
    public String postMethodName(@RequestBody Usuario usuario) {
        return "username :"+usuario.username();
        
        
    }
    @PostMapping("/headers")
    public String headersMethodName(@RequestHeader("name") String name) {
        return "username :"+name;
        
        
    }
    @PostMapping("/listHeaders")
    public String headersMethodName(@RequestHeader Map<String,String> headers) {
        return "username :"+headers.entrySet();

    }

    @GetMapping("/responseteste/{id}")
    public ResponseEntity<Object> metodoResponseenty(@PathVariable Long id) {
        if(id>3){
            var usuario = new Usuario("victor");
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        }
        return ResponseEntity.badRequest().body("numero errado");
        
    }
    

    /**
     * InnerPrimeiroController
     */
    public record Usuario(String username) {
    }
    
}

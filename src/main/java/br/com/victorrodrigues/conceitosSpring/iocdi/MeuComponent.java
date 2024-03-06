package br.com.victorrodrigues.conceitosSpring.iocdi;


import org.springframework.stereotype.Service;

@Service
public class MeuComponent {
    public String chamarMeuComponent(){
        return "chamando meu component ";
    }
}

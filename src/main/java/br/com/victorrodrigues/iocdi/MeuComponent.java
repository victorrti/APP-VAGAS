package br.com.victorrodrigues.iocdi;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MeuComponent {
    public String chamarMeuComponent(){
        return "chamando meu component ";
    }
}

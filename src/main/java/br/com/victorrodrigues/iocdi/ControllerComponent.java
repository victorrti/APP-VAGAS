package br.com.victorrodrigues.iocdi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/component")
public class ControllerComponent {
    @Autowired
    MeuComponent meuComponent;

    
    @GetMapping("/")    
    public String chamandoComponent(){
        var teste = meuComponent.chamarMeuComponent();
        return teste;
    }
}

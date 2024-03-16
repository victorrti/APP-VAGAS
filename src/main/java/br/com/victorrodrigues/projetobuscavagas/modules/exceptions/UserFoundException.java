package br.com.victorrodrigues.projetobuscavagas.modules.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException(){
        super("Usuario já existe");
    }
}

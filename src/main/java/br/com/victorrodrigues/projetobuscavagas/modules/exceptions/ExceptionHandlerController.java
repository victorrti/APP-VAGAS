package br.com.victorrodrigues.projetobuscavagas.modules.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.micrometer.core.ipc.http.HttpSender.Response;

@ControllerAdvice
public class ExceptionHandlerController {
    private MessageSource messageSource;

    public ExceptionHandlerController(MessageSource message){
        this.messageSource = message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessageDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<ErrorMessageDTO> dto = new ArrayList<>();     
        e.getBindingResult().getFieldErrors().forEach(err ->{
            String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
         
            ErrorMessageDTO error = new ErrorMessageDTO(message, err.getField());
            dto.add(error);
        });

        return new ResponseEntity<>(dto,HttpStatus.BAD_REQUEST);
    }

    
}

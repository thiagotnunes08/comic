package br.com.orange.comics.compartilhado.handler;

import br.com.orange.comics.compartilhado.handler.dto.ResponseHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

import static java.lang.String.valueOf;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseHandler> validationHandler(MethodArgumentNotValidException ex) {
        var fieldErrors = ex.getBindingResult().getFieldErrors();
        var campos = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(" - "));
        var mensagens = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(" - "));

        var response = new ResponseHandler(campos, mensagens, valueOf(BAD_REQUEST));

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ResponseHandler> validationResponseStatus(ResponseStatusException ex) {
        var mensagem = ex.getReason();
        var status = ex.getStatus();

        var response = new ResponseHandler("Erro na requisição", mensagem, valueOf(status));

        return ResponseEntity.badRequest().body(response);
    }
}

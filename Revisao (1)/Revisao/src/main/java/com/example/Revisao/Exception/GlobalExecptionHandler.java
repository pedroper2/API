package com.example.Revisao.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExecptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity <Map<String, Object >> handlerIIlegalArgumentException (IllegalArgumentException erro){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Mensagem",erro.getMessage()));
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity <Map< String, Object >> handlerMethodArgumentNotValidException(MethodArgumentNotValidException erro){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Mensagem",erro.getFieldErrors().get(0).getDefaultMessage()));
    }
}

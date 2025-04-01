package com.example.aula04.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String,Object>>handlerIIlegalArgument(IllegalArgumentException erro){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("mensagem",erro.getMessage()));
    }


}

package com.example.aula.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping ("/")
@RestController
public class Welcome {
    @GetMapping
    public String welcome () {
        return "Bem-vindo";
    }

}

package com.example.Atividade05.controller;


import com.example.Atividade05.model.Cliente;
import com.example.Atividade05.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @GetMapping
    public List <Cliente> ListarTodos (){
        return clienteService.ListarTodos();
    }
    @PostMapping
    public ResponseEntity <Map <String , Object>> salvar (@Valid @RequestBody Cliente cliente){
        clienteService.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem","Usuario cadastrado com sucesso"));
    }

    @PutMapping
    public  ResponseEntity <Map<String, Object>> atualizar (@Valid @RequestBody Cliente cliente){
        clienteService.atualizar(cliente);
        return ResponseEntity.ok().body(Map.of( "Mensagem", "cliente atualizado com sucesso"));
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity <Map<String,Object >> excluir (@PathVariable Long id){
        clienteService.excluir(id);
        return  ResponseEntity.ok().body(Map.of("Mensagem","Usuario felipe"));
    }

}

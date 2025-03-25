package com.example.aula.controller;

import com.example.aula.model.Funcionario;
import com.example.aula.repository.FuncionarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Funcionario")
@RestController
public class FuncionarioController {

    private final FuncionarioRepository  funcionarioRepository;

    public FuncionarioController (FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }
    @GetMapping
    public List<Funcionario> Listartodos(){
        return funcionarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity <Funcionario> Salvar (@RequestBody Funcionario funcionario){
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
        return  ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
    }
    @PutMapping
    public  ResponseEntity <Funcionario> atualizar (@RequestBody Funcionario funcionario) {
        if(funcionarioRepository.existsById(funcionario.getId())){
            funcionarioRepository.save(funcionario);
        }
        return  funcionarioRepository.ok().body(funcionario);
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity <Void> excluir (@PathVariable long id){
        funcionarioRepository.deleteBYId(id);
        return  ResponseEntity.noContent().build();
    }


}

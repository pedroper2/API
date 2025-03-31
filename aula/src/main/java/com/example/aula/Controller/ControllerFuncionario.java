package com.example.aula.Controller;

import com.example.aula.Model.Funcionario;
import com.example.aula.Repository.RepositoryFuncionario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/funcionario")
public class ControllerFuncionario {

    private RepositoryFuncionario repositoryFuncionario;

    public ControllerFuncionario(RepositoryFuncionario repositoryFuncionario) {
        this.repositoryFuncionario = repositoryFuncionario;
    }

    @GetMapping
    public List<Funcionario> ListarTodos() {
        return repositoryFuncionario.findAll();

    }

    @PostMapping
    public ResponseEntity<Funcionario> Salvar(@RequestBody Funcionario funcionario) {
        Funcionario funcionarioSalvo = repositoryFuncionario.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);

    }

    @PutMapping
    public ResponseEntity<Funcionario> Atualizar(@RequestBody Funcionario funcionario) {
        if (repositoryFuncionario.existsById(funcionario.getId())) {
            repositoryFuncionario.save(funcionario);
        }
        return ResponseEntity.ok().body(funcionario);
    }
    @DeleteMapping ("/{Id}")
    public ResponseEntity <Void> excluir (@PathVariable long id){
        repositoryFuncionario.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

}

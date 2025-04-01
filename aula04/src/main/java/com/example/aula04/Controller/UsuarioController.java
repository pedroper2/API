package com.example.aula04.Controller;

import com.example.aula04.model.Usuario;
import com.example.aula04.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping
    public List<Usuario> listartodos(){
        return usuarioService.ListarTodos();
    }

    @PostMapping

    public ResponseEntity  <String> salvar (@Valid @RequestBody Usuario usuario){
        usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario cadstrado com sucesso");
    }
    @PutMapping
    public  ResponseEntity<Usuario>atualizar(@Valid @RequestBody Usuario usuario){
        usuarioService.atualizar(usuario);
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <String> excluir (@PathVariable Long id){
        usuarioService.excluir(id);
        return ResponseEntity.ok().body("Usuario não encontrado");
    }
}

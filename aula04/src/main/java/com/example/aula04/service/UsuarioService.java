package com.example.aula04.service;

import com.example.aula04.model.Usuario;
import com.example.aula04.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List <Usuario> ListarTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario salvar(@Valid Usuario usuario){
        if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
            throw new IllegalArgumentException("O email informado ja esta cadastrado");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar (@Valid Usuario usuario){
        Usuario usuarioatualizado = usuarioRepository.findByEmail(usuario.getEmail())
                .orElseThrow (()-> new IllegalCallerException("Usuario não encontrado"));
        usuarioatualizado.setNome(usuario.getNome());
        usuarioatualizado.setEmail(usuario.getEmail());
        usuarioatualizado.setSenha(usuario.getEmail());
        return  usuarioRepository.save(usuarioatualizado);

    }
    public void  excluir (Long id){
        Usuario usuarioExcluir = usuarioRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("usuario não encontrado"));
        usuarioRepository.delete(usuarioExcluir);
    }
}

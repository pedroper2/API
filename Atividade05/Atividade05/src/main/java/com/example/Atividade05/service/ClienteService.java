package com.example.Atividade05.service;

import com.example.Atividade05.model.Cliente;
import com.example.Atividade05.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class ClienteService{
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List <Cliente>ListarTodos(){
        return clienteRepository.findAll();
    }
    public Cliente salvar(@Valid Cliente cliente){
        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()){
            throw new IllegalArgumentException("Esse email ja esta cadastrado");
        }
        return clienteRepository.save(cliente);
    }
    public Cliente atualizar (@Valid Cliente cliente){
        Cliente clientesalvo = clienteRepository.findByEmail(cliente.getEmail())
                 .orElseThrow (()-> new IllegalCallerException("Usuario não encontrado"));
        clientesalvo.setNome(cliente.getNome());
        clientesalvo.setEmail(cliente.getEmail());
        clientesalvo.setSexo(cliente.getSexo());
        clientesalvo.setSalario(cliente.getSalario());
        clientesalvo.setEndereco(cliente.getEndereco());
        return clienteRepository.save(clientesalvo);
    }

    public void excluir (Long id){
        Cliente clienteExcluir = clienteRepository.findById(id).
                orElseThrow (()-> new IllegalArgumentException("Usuario não encontrado"));
        clienteRepository.delete(clienteExcluir);
    }
}

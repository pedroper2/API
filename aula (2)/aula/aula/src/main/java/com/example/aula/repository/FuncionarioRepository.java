package com.example.aula.repository;
import com.example.aula.model.Funcionario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    
}
package com.example.aula.Repository;

import com.example.aula.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryFuncionario extends JpaRepository <Funcionario, Long> {

}

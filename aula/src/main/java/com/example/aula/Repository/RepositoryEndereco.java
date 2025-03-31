package com.example.aula.Repository;

import com.example.aula.Model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEndereco extends JpaRepository <Endereco, Long> {
}

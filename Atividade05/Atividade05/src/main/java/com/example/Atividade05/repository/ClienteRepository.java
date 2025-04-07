package com.example.Atividade05.repository;

import com.example.Atividade05.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long > {
    Optional<Cliente> findByEmail(String email);
}

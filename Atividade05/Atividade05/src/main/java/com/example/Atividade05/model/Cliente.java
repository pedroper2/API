package com.example.Atividade05.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Tab_usuario")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Nome não deve ser vazio")
    private String nome;

    @NotBlank(message = "Email não deve ser vazio")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotNull(message = "Sexo não pode ser nulo")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @NotNull(message = "Salário não pode ser nulo")
    private Double salario;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(long id, String nome, String email, Sexo sexo, Double salario, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.salario = salario;
        this.endereco = endereco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", sexo=" + sexo +
                ", salario=" + salario +
                ", endereco=" + endereco +
                '}';
    }
}

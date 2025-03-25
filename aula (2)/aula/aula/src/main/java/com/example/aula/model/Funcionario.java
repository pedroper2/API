package com.example.aula.model;

import jakarta.persistence.*;

@Entity
@Table (name = "Tab-funcionario")
public class Funcionario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  long id;

    @Column (nullable = false)
    private String cpf;
    private String nome;
    private String matricula;
    private  String setor;
    private  double salario;

    public Funcionario() {
    }

    public Funcionario(long id, String cpf, String nome, String matricula, String setor, double salario) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.matricula = matricula;
        this.setor = setor;
        this.salario = salario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", setor='" + setor + '\'' +
                ", salario=" + salario +
                '}';
    }
}

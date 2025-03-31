package com.example.aula.Model;

import jakarta.persistence.*;

@Entity
@Table (name = "Tab-usuario")
public class Funcionario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false)
    private String nome;
    private String cpf;
    private String rg;
    private String matricula;
    private String dataNascimento;
    private double salario;
    private String telefone;
    private String email;


    @Enumerated (EnumType.STRING)
    private Setor setor;
    private  Sexo sexo;

    @OneToOne (cascade = CascadeType.ALL)
    private  Endereco endereco;

    public Funcionario() {
    }

    public Funcionario(long id, Endereco endereco, String nome, String cpf, String rg, String dataNascimento, String email, Sexo sexo, Setor setor, String telefone, double salario, String matricula) {
        this.id = id;
        this.endereco = endereco;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.sexo = sexo;
        this.setor = setor;
        this.telefone = telefone;
        this.salario = salario;
        this.matricula = matricula;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", matricula='" + matricula + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", salario=" + salario +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", setor=" + setor +
                ", sexo=" + sexo +
                ", endereco=" + endereco +
                '}';
    }
}

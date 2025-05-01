package com.example.sistemaimobiliario.usuario;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String senha;

    public Pessoa(String nome, String cpf, String telefone, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getCpf() {return cpf;}

    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String getEmail() {return email;}

    public String getSenha() {return senha;}

    public void exibirDetalhesPerfil() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
    }

}

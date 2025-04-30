package com.example.sistemaimobiliario.usuario;

import com.example.sistemaimobiliario.imoveis.Imovel;

import java.util.ArrayList;
import java.util.List;

public class Corretor extends Pessoa {
    private String nomeEmpresa;
    private String cnpj;
    private List<Interesse> interesses;
    private static int contador = 0;
    private String senha;

    public Corretor(String nome, String cpf, String telefone, String email, String cnpj, String nomeEmpresa, String senha) {
        super(nome, cpf, telefone, email, senha);
        this.cnpj = cnpj;
        this.nomeEmpresa = nomeEmpresa;
        this.interesses = new ArrayList<>();
        contador++;
    }
    public String getNomeEmpresa() {return nomeEmpresa;}
    public void setNomeEmpresa(String nomeEmpresa) {this.nomeEmpresa = nomeEmpresa;}

    public String getCnpj() {return cnpj;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}

    public List<Interesse> getInteresses() {return interesses;}

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Nome da Empresa: " + nomeEmpresa);
        System.out.println("CNPJ: " + cnpj);
    }

    public void exibirResumo(){
        System.out.println("Nome da Empresa: "+ nomeEmpresa);
        System.out.println("CNPJ: " + cnpj);
    }
}

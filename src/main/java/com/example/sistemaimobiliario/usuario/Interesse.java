package com.example.sistemaimobiliario.usuario;

import com.example.sistemaimobiliario.imoveis.Imovel;

public class Interesse {
    private Pessoa pessoa;
    private Imovel imovel;
    private String nomeCliente;
    private String telefoneCliente;

    public Interesse(Pessoa pessoa, Imovel imovel) {
        this.imovel = imovel;
        this.nomeCliente = pessoa.getNome();
        this.telefoneCliente = pessoa.getTelefone();
    }

    public Interesse(Imovel imovel) {
        this.imovel = imovel;
    }

    public Pessoa getPessoa() {return pessoa;}
    public void setPessoa(Pessoa pessoa) {this.pessoa = pessoa;}

    public Imovel getImovel() {return imovel;}
    public void setImovel(Imovel imovel) {this.imovel = imovel;}
}

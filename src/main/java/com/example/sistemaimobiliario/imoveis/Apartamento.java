package com.example.sistemaimobiliario.imoveis;

import com.example.sistemaimobiliario.usuario.Corretor;

public class Apartamento extends Imovel{
    private boolean temElevador;
    private boolean temSacada;
    private int andar;

    public Apartamento(String endereco, double preco, int quartos, int banheiros, double area, String descricao, String proprietario, String status, boolean temElevador, boolean temSacada, Corretor corretor, String tipoImovel, String tipoVenda) {
        super(endereco, preco, quartos, banheiros, area, descricao, proprietario, status, corretor, tipoImovel, tipoVenda);
        this.temElevador = temElevador;
        this.temSacada = temSacada;
    }

    public Apartamento(String endereco, double preco, int quartos, int banheiros, double area, String descricao, String proprietario, String status, boolean temElevador, boolean temSacada, int andar, Corretor corretor, String tipoImovel, String tipoVenda) {
        super(endereco, preco, quartos, banheiros, area, descricao, proprietario, status, corretor, tipoImovel, tipoVenda);
        this.temElevador = temElevador;
        this.temSacada = temSacada;
        this.andar = andar;
    }

    public boolean isTemElevador() {return temElevador;}
    public void setTemElevador(boolean temElevador) {this.temElevador = temElevador;}

    public boolean isTemSacada() {return temSacada;}
    public void setTemSacada(boolean temSacada) {this.temSacada = temSacada;}

    public int getAndar() {return andar;}
    public void setAndar(int andar) {this.andar = andar;}

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tem Elevador: " + (temElevador ? "Sim" : "Não"));
        System.out.println("Tem Sacada: " + (temSacada ? "Sim" : "Não"));
        System.out.println("Andares: " + andar);
    }
}

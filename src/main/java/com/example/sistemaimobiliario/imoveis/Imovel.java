package com.example.sistemaimobiliario.imoveis;
import com.example.sistemaimobiliario.usuario.Corretor;

public class Imovel {
    private String endereco;
    private double preco;
    private int quartos;
    private int banheiros;
    private double area;
    private String descricao;
    private String proprietario;
    private String status;
    private Corretor corretor;
    private static int contador = 0;
    private String tipoImovel;
    private String tipoVenda;

    public Imovel(String endereco, double preco, int quartos, int banheiros, double area, String descricao, String proprietario, String status, Corretor corretor, String tipoImovel, String tipoVenda) {
        this.endereco = endereco;
        this.preco = preco;
        this.quartos = quartos;
        this.banheiros = banheiros;
        this.area = area;
        this.descricao = descricao;
        this.proprietario = proprietario;
        this.status = status;
        this.corretor = corretor;
        this.tipoImovel = tipoImovel;
        this.tipoVenda = tipoVenda;
        contador++;
    }

    public String getEndereco() {return endereco;}
    public void setEndereco(String endereco) {this.endereco = endereco;}

    public double getPreco() {return preco;}
    public void setPreco(double preco) {this.preco = preco;}

    public int getQuartos() {return quartos;}
    public void setQuartos(int quartos) {this.quartos = quartos;}

    public int getBanheiros() {return banheiros;}
    public void setBanheiros(int banheiros) {this.banheiros = banheiros;}

    public double getArea() {return area;}
    public void setArea(double area) {this.area = area;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public String getProprietario() {return proprietario;}
    public void setProprietario(String proprietario) {this.proprietario = proprietario;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public Corretor getCorretor() {return corretor;}
    public void setCorretor(Corretor corretor) {this.corretor = corretor;}

    public String getTipoImovel() {return tipoImovel;}

    public String getTipoVenda() {return tipoVenda;}

    public void exibirDetalhes() {
        System.out.println("Endereço: " + endereco);
        System.out.println("Preço: " + preco);
        System.out.println("Quartos: " + quartos);
        System.out.println("Banheiros: " + banheiros);
        System.out.println("Área: " + area);
        System.out.println("Descrição: " + descricao);
        System.out.println("Proprietário: " + proprietario);
        System.out.println("Status: " + status);
        corretor.exibirDetalhes();
    }
}

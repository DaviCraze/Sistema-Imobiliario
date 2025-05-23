package com.example.sistemaimobiliario.imoveis;
import com.example.sistemaimobiliario.usuario.Corretor;
import com.example.sistemaimobiliario.utilitario.ListaImoveis;
import com.example.sistemaimobiliario.utilitario.ListaInteresse;

import java.util.ArrayList;
import java.util.List;

public abstract class Imovel {
    private String endereco;
    private double preco;
    private int quartos;
    private int banheiros;
    private double area;
    private String descricao;
    private String proprietario;
    private String status;
    private List<Corretor> corretores = new ArrayList<>();
    private static int contador = 0;
    private List<String> tags = new ArrayList<>();
    private String tipoImovel;
    private String tipoVenda;

    public Imovel(String endereco, double preco, int quartos, int banheiros, double area, String descricao, String proprietario, String status, String tipoImovel, String tipoVenda) {
        this.endereco = endereco;
        this.preco = preco;
        this.quartos = quartos;
        this.banheiros = banheiros;
        this.area = area;
        this.descricao = descricao;
        this.proprietario = proprietario;
        this.status = status;
        tags.add(tipoImovel);
        tags.add(tipoVenda);
        this.tipoImovel = tipoImovel;
        this.tipoVenda = tipoVenda;
        contador++;
    }

    public String getEndereco() {return endereco;}
    public void setEndereco(String endereco) {this.endereco = endereco;}

    public double getPreco() {return preco;}
    public void setPreco(double preco) {
        if(preco < 0) {
            System.out.println("Digite um preço maior que zero");
        } else {
            this.preco = preco;
        }
    }

    public int getQuartos() {return quartos;}
    public void setQuartos(int quartos) {
        if(quartos < 1) {
            System.out.println("Digite um numero de quartos maior que zero");
        } else {
            this.quartos = quartos;
        }
    }

    public int getBanheiros() {return banheiros;}
    public void setBanheiros(int banheiros) {
        if(banheiros < 1) {
            System.out.println("Digite um numero de banheiros maior que zero");
        } else {
            this.banheiros = banheiros;
        }
    }

    public double getArea() {return area;}
    public void setArea(double area) {this.area = area;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public String getProprietario() {return proprietario;}
    public void setProprietario(String proprietario) {this.proprietario = proprietario;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public List<Corretor> getCorretores() {return corretores;}

    public List<Corretor> getCorretoresOrdenadosAvaliacao(){
        List<Corretor> corretoresOrdenados = new ArrayList<>(corretores);

        for(int i = 0; i < corretores.size() - 1; i++) {
            for(int j = i + 1; j < corretores.size(); j++) {
                if(corretoresOrdenados.get(i).getAvaliacao() < corretoresOrdenados.get(j).getAvaliacao()) {
                    Corretor aux = corretoresOrdenados.get(i);
                    corretoresOrdenados.set(i, corretoresOrdenados.get(j));
                    corretoresOrdenados.set(j, aux);
                }
            }
        }
        return corretoresOrdenados;
    }

    public void adicionarCorretor(Corretor corretor) {
        if(!corretores.contains(corretor)) {
            corretores.add(corretor);
        }
    }

    public List<String> getTags() {return tags;}
    public void setTags(String tags) {this.tags.add(tags);}

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

    }

    public void exibirResumo(){
        System.out.println("Endereço: "+ endereco);
        System.out.println("Preferencias: "+ tags);
        System.out.println("Status: "+ status);
    }
}

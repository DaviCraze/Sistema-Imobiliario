package com.example.sistemaimobiliario.utilitario;

import java.util.ArrayList;
import com.example.sistemaimobiliario.imoveis.Imovel;
import com.example.sistemaimobiliario.imoveis.Casa;
import com.example.sistemaimobiliario.imoveis.Apartamento;
import com.example.sistemaimobiliario.usuario.IRepositorio;

public class ListaImoveis implements IRepositorio {

    private static ArrayList<Imovel> listaImoveis = new ArrayList<>();

    static {
        listaImoveis.add(new Casa("Rua Adolfo", 300000, 3, 2, 150, "Casa Verde na Praia", "Davi Vieira", "Venda-se/Aluga-se", true, true, false, "Casa", "Venda"));
        listaImoveis.add(new Apartamento("Rua Adolfo", 300000, 3, 2, 150, "Apartamento Verde na Praia", "Davi Vieira", "Venda-se/Aluga-se", true, false, 7, "Apartamento", "Alugar"));
    }

    public ArrayList<Imovel> getListaImoveis() {
        return listaImoveis;
    }

    @Override
    public void add(Object objeto) {
        if(objeto instanceof Imovel imovel) {
            listaImoveis.add(imovel);
        } else {
            System.out.println("Objeto não é um Imovel!");
        }
    }

    @Override
    public void remove(Object objeto) {
        if(objeto instanceof Imovel imovel) {
            listaImoveis.remove(imovel);
        } else {
            System.out.println("Objeto não é um Imovel!");
        }
    }

    @Override
    public void update(Object objeto) {
        if(objeto instanceof Imovel imovel) {
            for(int i = 0; i < listaImoveis.size(); i++) {
                if(listaImoveis.get(i).getEndereco().equals(imovel.getEndereco())) {
                    listaImoveis.set(i, imovel);
                    return;
                }
            }
            System.out.println("Imovel não foi encontrado na lista.");
        } else {
            System.out.println("Objeto não é um Imovel!");
        }
    }

    @Override
    public Imovel busca(String endereco) {
        for(Imovel imovel : listaImoveis){
            if(imovel.getEndereco().equals(endereco)) {
                return imovel;
            }
        }
        System.out.println("Imovel não foi encontrado na lista.");
        return null;
    }

    public void printaImoveis() {
        for(Imovel imovel : listaImoveis) {
            imovel.exibirResumo();
        }
    }
}

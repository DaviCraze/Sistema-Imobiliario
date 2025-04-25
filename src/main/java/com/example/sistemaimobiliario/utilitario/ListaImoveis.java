package com.example.sistemaimobiliario.utilitario;

import java.util.ArrayList;
import com.example.sistemaimobiliario.imoveis.Imovel;
import com.example.sistemaimobiliario.imoveis.Casa;
import com.example.sistemaimobiliario.imoveis.Apartamento;

public class ListaImoveis {

    private static ArrayList<Imovel> listaImoveis = new ArrayList<>();

    static {
        listaImoveis.add(new Casa("Rua Adolfo", 300000, 3, 2, 150, "Casa Verde na Praia", "Davi Vieira", "Venda-se/Aluga-se", true, true, false, "Casa", "Venda"));
        listaImoveis.add(new Apartamento("Rua Adolfo", 300000, 3, 2, 150, "Apartamento Verde na Praia", "Davi Vieira", "Venda-se/Aluga-se", true, false, 7, "Apartamento", "Alugar"));
    }

    public ArrayList<Imovel> getListaImoveis() {
        return listaImoveis;
    }

    public void printaImoveis() {
        for(Imovel imovel : listaImoveis) {
            imovel.exibirResumo();
        }
    }
}

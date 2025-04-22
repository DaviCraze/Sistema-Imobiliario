package com.example.sistemaimobiliario.utilitario;

import java.util.ArrayList;
import com.example.sistemaimobiliario.imoveis.Imovel;
import com.example.sistemaimobiliario.imoveis.Casa;
import com.example.sistemaimobiliario.imoveis.Apartamento;

public class ListaImoveis {

    private ArrayList<Imovel> listaImoveis = new ArrayList<>();
    Imovel imovel1 = new Casa("Rua Adolfo", 300000, 3, 2, 150, "Casa Verde na Praia", "Davi Vieira", "Venda-se/Aluga-se", true, true, false, ListaCorretor.getListaCorretores(0), "Casa", "Venda");
    Imovel imovel2 = new Apartamento("Rua Adolfo", 300000, 3, 2, 150, "Apartamento Verde na Praia", "Davi Vieira", "Venda-se/Aluga-se", true, false, 7, ListaCorretor.getListaCorretores(1), "Apartamento", "Alugar");

    public ListaImoveis() {
        listaImoveis.add(imovel1);
        listaImoveis.add(imovel2);
    }

    public ArrayList<Imovel> getListaImoveis() {
        return listaImoveis;
    }
}

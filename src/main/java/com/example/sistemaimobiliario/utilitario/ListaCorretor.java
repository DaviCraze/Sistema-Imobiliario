package com.example.sistemaimobiliario.utilitario;

import com.example.sistemaimobiliario.usuario.Corretor;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListaCorretor {
    private static ArrayList<Corretor> listaDeCorretores = new ArrayList<>();
    Corretor corretor1 = new Corretor("Davi", "06505593390","85991912232", "davi.vieira@", "24759124", "Corretor de Imóveis", "davi2448");
    Corretor corretor2 = new Corretor("Lucas", "86400912349","88984730086", "lucas.vieira@", "85940345", "Corretor de Imóveis", "baguga2007");

    public ListaCorretor() {
        listaDeCorretores.add(corretor1);
        listaDeCorretores.add(corretor2);
    }
    public static void adicionarCorretor(Corretor corretor) {
        listaDeCorretores.add(corretor);
    }
    public static ArrayList<Corretor> getListaCorretores() {return listaDeCorretores;}

    public static Corretor getListaCorretores(int i) {return listaDeCorretores.get(i);}

}

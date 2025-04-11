package com.example.sistemaimobiliario.utilitario;

import com.example.sistemaimobiliario.usuario.Corretor;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListaCorretor {

    private static final Corretor[] listaCorretores = new Corretor[]{
            new Corretor("Davi", "065-055-933-90","85991912232", "davi.vieira@", "24759124", "Corretor de Imóveis"),
            new Corretor("Lucas", "864-009-123-49","88984730086", "lucas.vieira@", "85940345", "Corretor de Imóveis"),
    };

    public static Corretor getListaCorretores(int contador){return listaCorretores[contador];}
}

package com.example.sistemaimobiliario.utilitario;

import com.example.sistemaimobiliario.usuario.Corretor;
import com.example.sistemaimobiliario.usuario.IRepositorio;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListaCorretor implements IRepositorio {
    private static ArrayList<Corretor> listaDeCorretores = new ArrayList<>();

    static {
        listaDeCorretores.add(new Corretor("Davi", "06505593390", "85991912232", "davi.vieira@", "24759124", "Corretor de Imóveis", "davi2448"));
        listaDeCorretores.add(new Corretor("Lucas", "86400912349", "88984730086", "lucas.vieira@", "85940345", "Corretor de Imóveis", "baguga2007"));
    }
    @Override
    public void add(Object objeto) {
        if(objeto instanceof Corretor corretor) {
            listaDeCorretores.add(corretor);
        } else {
            System.out.println("Objeto não é um Corretor!");
        }
    }

    @Override
    public void remove(Object objeto) {
        if(objeto instanceof Corretor corretor) {
            listaDeCorretores.remove(corretor);
        } else {
            System.out.println("Objeto não é um Corretor!");
        }
    }

    @Override
    public void update(Object objeto) {
        if(objeto instanceof Corretor corretor){
            for(int i = 0; i < listaDeCorretores.size(); i++){
                if(listaDeCorretores.get(i).getCpf().equals(corretor.getCpf())){
                    listaDeCorretores.set(i, corretor);
                    return;
                }
            }
            System.out.println("Corretor não encontrado na lista.");
        } else {
            System.out.println("Objeto não é um Corretor!");
        }
    }

    @Override
    public Corretor busca(String cpf) {
        for(Corretor corretor : listaDeCorretores){
            if(corretor.getCpf().equals(cpf)) {
                return corretor;
            }
        }
        System.out.println("Corretor não encontrado na lista.");
        return null;
    }

    public static ArrayList<Corretor> getListaCorretores() {return listaDeCorretores;}

    public static Corretor getListaCorretoresPorID(int i) {return listaDeCorretores.get(i);}

}

package com.example.sistemaimobiliario.utilitario;

import com.example.sistemaimobiliario.usuario.Corretor;
import com.example.sistemaimobiliario.usuario.IRepositorio;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListaCorretor implements IRepositorio {
    private static ArrayList<Corretor> listaDeCorretores = new ArrayList<>();

    static {
        Corretor c1 = new Corretor("Luana", "06505593390", "85991912232", "luana.matos@gmail.com", "24759124", "LM Corretora", "luana123");
        Corretor c2 = new Corretor("Lucas", "86400912349", "88984730086", "lucas.vieira@gmail.com", "85940345", "Lucas Imoveis", "lucas123");
        listaDeCorretores.add(c1);
        listaDeCorretores.add(c2);
        c1.atualizarAvaliacao(4.5);
        c2.atualizarAvaliacao(3.5);
        c1.adicionarImovel(ListaImoveis.getListaImoveis().get(0));
        c1.adicionarImovel(ListaImoveis.getListaImoveis().get(1));
        c2.adicionarImovel(ListaImoveis.getListaImoveis().get(0));
        c2.adicionarImovel(ListaImoveis.getListaImoveis().get(1));

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
    public Corretor busca(String email) {
        for(Corretor corretor : listaDeCorretores){
            if(corretor.getCpf().equals(email)) {
                return corretor;
            }
        }
        System.out.println("Corretor não encontrado na lista.");
        return null;
    }

    public static ArrayList<Corretor> getListaCorretores() {return listaDeCorretores;}

    public static Corretor getListaCorretoresPorID(int i) {return listaDeCorretores.get(i);}

}

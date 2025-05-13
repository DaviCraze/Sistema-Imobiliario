package com.example.sistemaimobiliario.utilitario;

import java.util.ArrayList;
import java.util.List;

import com.example.sistemaimobiliario.imoveis.Imovel;
import com.example.sistemaimobiliario.imoveis.Casa;
import com.example.sistemaimobiliario.imoveis.Apartamento;
import com.example.sistemaimobiliario.usuario.IRepositorio;

public class ListaImoveis implements IRepositorio {

    private static ArrayList<Imovel> listaImoveis = new ArrayList<>();

    static {
        Casa casa1 = new Casa("Rua Adolfo", 300000, 3, 2, 150, "Casa Verde na Praia", "Davi Vieira", "Disponivel", true, true, false, "Casa", "Venda");
        Apartamento casa2 = new Apartamento("Rua Adolfo", 300000, 3, 2, 150, "Apartamento Verde na Praia", "Davi Vieira", "Disponivel", true, false, 7, "Apartamento", "Alugar");
        listaImoveis.add(casa1);
        listaImoveis.add(casa2);

        casa1.adicionarCorretor(ListaCorretor.getListaCorretoresPorID(0));
        casa1.adicionarCorretor(ListaCorretor.getListaCorretoresPorID(1));
        casa2.adicionarCorretor(ListaCorretor.getListaCorretoresPorID(0));
        casa2.adicionarCorretor(ListaCorretor.getListaCorretoresPorID(1));


    }

    public List<Imovel> getImoveisOrdenadosPorStatus() {
        List<Imovel> imoveisOrdenados = ListaImoveis.getListaImoveis();

        for (int i = 0; i < imoveisOrdenados.size() - 1; i++) {
            for (int j = i + 1; j < imoveisOrdenados.size(); j++) {
                if (imoveisOrdenados.get(i).getStatus().equalsIgnoreCase("Indisponivel") &&
                        imoveisOrdenados.get(j).getStatus().equalsIgnoreCase("Disponivel")) {
                    Imovel aux = imoveisOrdenados.get(i);
                    imoveisOrdenados.set(i, imoveisOrdenados.get(j));
                    imoveisOrdenados.set(j, aux);
                }
            }
        }

        return imoveisOrdenados;
    }
    public static ArrayList<Imovel> getListaImoveis() {
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

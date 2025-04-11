package com.example.sistemaimobiliario.utilitario;

import com.example.sistemaimobiliario.imoveis.Imovel;
import com.example.sistemaimobiliario.usuario.Cliente;
import java.util.List;
import java.util.ArrayList;

public class BuscaImovel {
    private final ArrayList<Imovel> imoveisOrdenados;

    public BuscaImovel(){
        imoveisOrdenados = new ArrayList<>();
    }

    public void criaImoveisOrdenados(Cliente cliente){
        List<Imovel> listaImoveis = new ListaImoveis().getListaImoveis();
        List<String> preferencias = cliente.getPreferencias();

        for(Imovel imovel : listaImoveis){
            if(preferencias.contains(imovel.getTipoImovel())){
                imoveisOrdenados.add(imovel);
            } else if(preferencias.contains(imovel.getTipoVenda())){
                imoveisOrdenados.add(imovel);
            }
        }
    }
    public List<Imovel> getImoveisOrdenados(){
        return imoveisOrdenados;
    }

    public void resumoImovel(){
        System.out.println("Imoveis encontrados: "+imoveisOrdenados.size());
        for(Imovel imovel : imoveisOrdenados){
            System.out.println("Tipo: "+imovel.getTipoImovel());
            System.out.println("Endereço: "+imovel.getEndereco());
        }
    }

}

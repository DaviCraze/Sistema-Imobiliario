package com.example.sistemaimobiliario.usuario;

import com.example.sistemaimobiliario.imoveis.Imovel;
import com.example.sistemaimobiliario.utilitario.ListaImoveis;

import java.util.ArrayList;
import java.util.List;
//Alocar classe BuscaImoveis na classe Cliente
public class Cliente extends Pessoa{
    private List<Interesse> interesses;
    private List<String> preferencias;
    private List<Imovel> imoveisOrdenados;

    public Cliente(String nome, String cpf, String telefone, String email, String senha) {
        super(nome, cpf, telefone, email, senha);
        this.interesses = new ArrayList<>();
        this.preferencias = new ArrayList<>();
        this.imoveisOrdenados = new ArrayList<>();
    }

    public List<Interesse> getInteresses() {return interesses;}

    public List<String> getPreferencias() {return preferencias;}

    public void addImovelInteresse(Imovel imovel) {
        if(!interesses.contains(imovel)){
            interesses.add(new Interesse(imovel));
        }
    }

    public void removeImovelInteresse(Imovel imovel){
        for(Interesse interesse : interesses){
            if(interesse.getImovel().equals(imovel)){
                interesses.remove(interesse);
                break;
            }
        }
    }

    public void addPreferencia(int preferencia) {
        switch (preferencia) {
            case 1 :
                if(!preferencias.contains("Casa")) {
                    preferencias.add("Casa");
                } else {
                    System.out.println("Preferencia já adicionada(Casa)");
                }
            case 2 :
                if(!preferencias.contains("Apartamento")){
                    preferencias.add("Apartamento");
                } else {
                    System.out.println("Preferencia já adicionada(Apartamento)");
                }
            case 3 :
                if(!preferencias.contains("Venda")){
                    preferencias.add("Venda");
                } else {
                    System.out.println("Preferencia já adicionada(Venda)");
                }
            case 4 :
                if(!preferencias.contains("Aluguel")){
                    preferencias.add("Aluguel");
                } else {
                    System.out.println("Preferencia já adicionada(Aluguel)");
                }
            case 5 :
                if(!preferencias.contains("Tem piscina")){
                    preferencias.add("Tem piscina");
                } else {
                    System.out.println("Preferencia já adicionada(Tem piscina)");
                }
            case 6 :
                if(!preferencias.contains("Tem quintal")){
                    preferencias.add("Tem quintal");
                } else {
                    System.out.println("Preferencia já adiconada(Tem quintal");
                }
            case 7 :
                if(!preferencias.contains("Tem garagem")){
                    preferencias.add("Tem garagem");
                } else {
                    System.out.println("Preferencia já adicionada(Tem garagem)");
                }
            case 8 :
                if(!preferencias.contains("Tem elevador")){
                    preferencias.add("Tem elevador");
                } else {
                    System.out.println("Preferencia já adicionada(Tem elevador)");
                }
            case 9 :
                if(!preferencias.contains("Tem sacada")){
                    preferencias.add("Tem sacada");
                } else {
                    System.out.println("Preferencia já adicionada(Tem sacada)");
                }
            default :
                System.out.println("Preferência inválida.");
        }

    }

    public void removePreferencia(String preferencia){
            preferencias.remove(preferencia);
    }

    public void ordenaImoveisCliente(){
        ListaImoveis listaImoveis = new ListaImoveis();

        for(Imovel imovel : listaImoveis.getListaImoveis()){
            int contd = 0;

            for(String preferencia : preferencias){
                if(imovel.getTags().contains(preferencia)) {
                    contd++;
                }
            }
            if(contd == preferencias.size()){
                imoveisOrdenados.add(imovel);
            }

        }
    }
}

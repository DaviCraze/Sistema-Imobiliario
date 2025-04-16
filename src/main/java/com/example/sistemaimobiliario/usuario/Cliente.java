package com.example.sistemaimobiliario.usuario;

import com.example.sistemaimobiliario.imoveis.Imovel;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{
    private List<Interesse> interesses;
    private List<String> preferencias;

    public Cliente(String nome, String cpf, String telefone, String email, String senha) {
        super(nome, cpf, telefone, email, senha);
        this.interesses = new ArrayList<>();
        this.preferencias = new ArrayList<>();
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
        if(!preferencias.contains(preferencia)){
            switch (preferencia) {
                case 1 -> preferencias.add("Casa");
                case 2 -> preferencias.add("Apartamento");
                case 3 -> preferencias.add("Venda");
                case 4 -> preferencias.add("Aluguel");
                default -> System.out.println("Preferência inválida.");
            }
        } else {
            System.out.println("Preferência já adicionada.");
        }
    }

    public void removePreferencia(String preferencia){
            preferencias.remove(preferencia);
    }
}

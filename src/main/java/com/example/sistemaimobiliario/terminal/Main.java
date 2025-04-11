package com.example.sistemaimobiliario.terminal;

import java.util.Scanner;
import com.example.sistemaimobiliario.usuario.Cliente;
import com.example.sistemaimobiliario.utilitario.BuscaImovel;

public class Main {
    public static void main(String[] args){
        Cliente cliente1 = new Cliente("Davi","065-055-933-90","85991912232", "davi.vieira@");
        Scanner sc = new Scanner(System.in);
        System.out.println("Sistema de Imobiliário");
        System.out.println("Bem-vindo ao sistema de gerenciamento imobiliário!");
        System.out.println("Escolha uma opção:");
        System.out.println("Preferencias(1-Casa, 2-Apartamento, 3-Venda, 4-Aluguel): ");
        int opcao = sc.nextInt();
        cliente1.addPreferencia(opcao);
        BuscaImovel buscaImovel = new BuscaImovel();
        buscaImovel.criaImoveisOrdenados(cliente1);
        buscaImovel.resumoImovel();


    }
}

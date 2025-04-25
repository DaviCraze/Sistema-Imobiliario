package com.example.sistemaimobiliario.terminal;

import com.example.sistemaimobiliario.usuario.Cliente;
import com.example.sistemaimobiliario.usuario.Pessoa;
import com.example.sistemaimobiliario.utilitario.ListaImoveis;

import java.util.Scanner;

public class MenuCliente {
    static Scanner sc = new Scanner(System.in);

    public static void iniciaCliente(Pessoa cliente){
        Cliente clienteC = (Cliente) cliente;
        int opcao;
        do{
            System.out.println("Bem vindo: "+clienteC.getNome());
            System.out.println("1 - Ver perfil");
            System.out.println("2 - Buscar Imoveis");
            System.out.println("3 - Lista de Imoveis Favoritos");
            System.out.println("4 - Log out");
            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao){
                case 1:
                    System.out.println("Perfil do cliente: ");
                    break;
                case 2:
                    System.out.println("1 - Todos os Imoveis");
                    System.out.println("2 - Filtrar moveis");
                    System.out.println("3 - Sair");
                    opcao = sc.nextInt();
                    sc.nextLine();
                    switch(opcao){
                        case 1:
                            System.out.println("Todos os imoveis disponiveis: ");
                            ListaImoveis listaImoveis = new ListaImoveis();
                            clienteC.exibirImoveisPaginados(listaImoveis.getListaImoveis());
                            break;
                        case 2:

                    }
            }
        }

    }
}

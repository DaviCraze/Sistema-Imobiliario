package com.example.sistemaimobiliario.terminal;

import com.example.sistemaimobiliario.usuario.Cliente;
import com.example.sistemaimobiliario.usuario.Pessoa;
import com.example.sistemaimobiliario.utilitario.ListaImoveis;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
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
                    clienteC.exibirDetalhesPerfil();
                    break;
                case 2:
                    System.out.println("1 - Todos os Imoveis");
                    System.out.println("2 - Filtrar imoveis");
                    System.out.println("3 - Voltar");
                    int opcao1 = sc.nextInt();
                    sc.nextLine();
                    switch(opcao1){
                        case 1:
                            System.out.println("Todos os imoveis disponiveis: ");
                            ListaImoveis listaImoveis = new ListaImoveis();
                            clienteC.exibirImoveisPaginados(listaImoveis.getListaImoveis());
                            break;
                        case 2:
                            System.out.print("Preferencias adicionadas: ");
                            List<String> preferencias = clienteC.getPreferencias();
                            if(preferencias.isEmpty()) {
                                System.out.print("Nenhuma");
                            } else {
                                for(String preferencia : preferencias){
                                    System.out.print(preferencia+" | ");
                                }
                            }
                            System.out.println("1 - Adicionar Preferencia");
                            System.out.println("2 - Remover Preferencia");
                            System.out.println("3 - Mostrar Imoveis de acordo com as preferencias");
                            System.out.println("4 - Voltar");
                            int opcao2 = sc.nextInt();
                            sc.nextLine();
                            switch (opcao2){
                                case 1:
                                    System.out.println("1 - Casa");
                                    System.out.println("2 - Apartamento");
                                    System.out.println("3 - Venda");
                                    System.out.println("4 - Aluguel");
                                    System.out.println("5 - Tem piscina");
                                    System.out.println("6 - Tem quintal");
                                    System.out.println("7 - Tem garagem");
                                    System.out.println("8 - Tem elevador");
                                    System.out.println("9 - Tem sacada");
                                    int opcao3 = sc.nextInt();
                                    sc.nextLine();
                                    switch (opcao3){
                                        case 1:
                                            clienteC.addPreferencia(1);
                                            break;
                                        case 2:
                                            clienteC.addPreferencia(2);
                                            break;
                                        case 3:
                                            clienteC.addPreferencia(3);
                                            break;
                                        case 4:
                                            clienteC.addPreferencia(4);
                                            break;
                                        case 5:
                                            clienteC.addPreferencia(5);
                                            break;
                                        case 6:
                                            clienteC.addPreferencia(6);
                                            break;
                                        case 7:
                                            clienteC.addPreferencia(7);
                                            break;
                                        case 8:
                                            clienteC.addPreferencia(8);
                                            break;
                                        case 9:
                                            clienteC.addPreferencia(9);
                                            break;
                                        default:
                                            System.out.println("Opção invalida.");
                                    }
                            }
                    }
            }
        }

    }
}

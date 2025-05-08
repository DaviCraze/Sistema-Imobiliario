package com.example.sistemaimobiliario.usuario;

import com.example.sistemaimobiliario.imoveis.Imovel;
import com.example.sistemaimobiliario.utilitario.ListaClientes;

import java.util.List;
import java.util.Scanner;

public class Admin {
    static Scanner sc = new Scanner(System.in);

    public static void removerCliente(List<Cliente> listaClientes){
        int totalClientes = listaClientes.size();
        int totalPaginas = (int) Math.ceil(totalClientes / 10);
        if(totalPaginas == 0) {
            totalPaginas = 1;
        }
        int paginaAtual = 1;

        while (true) {
            System.out.println("Pagina "+paginaAtual+"/"+totalPaginas);
            System.out.println("---------------------------------------------------------------");
            int inicio = (paginaAtual - 1) * 10;
            int fim = Math.min(inicio + 10, totalClientes);

            for(int i = inicio; i < fim; i++){
                System.out.print((i + 1) + " - ");
                listaClientes.get(i).exibirDetalhes();
            }
            System.out.println("---------------------------------------------------------------");
            System.out.println("Digite o numero do corretor(1 - "+fim+") ou:");
            System.out.println("[N] - Proxima pagina | [P] - Voltar a pagina anterior | [S] - Sair");
            String opcao = sc.nextLine();

            if(opcao.equalsIgnoreCase("N") && paginaAtual < totalPaginas) {
                paginaAtual++;
            } else if(opcao.equalsIgnoreCase("P") && paginaAtual > 1) {
                paginaAtual--;
            } else if(opcao.equalsIgnoreCase("S")){
                System.out.println("Saindo...");
                break;
            } else {
                try {
                    int escolha = Integer.parseInt(opcao);
                    if(escolha >= 1 && escolha <= fim ){
                        Cliente clienteSelecionado = listaClientes.get(inicio + escolha - 1);
                        System.out.println("Deseja remover o cliente: " + clienteSelecionado.getNome() + " ?");
                        System.out.println("[S] - Sim | [N] - Nao");
                        String opcao2 = sc.nextLine();
                        if(opcao2.equalsIgnoreCase("S")) {
                            listaClientes.remove(clienteSelecionado);
                            System.out.println("Cliente removido com sucesso!");
                            break;
                        } else if(opcao2.equalsIgnoreCase("N")) {
                            System.out.println("Operacao cancelada.");
                        } else {
                            System.out.println("Opcao invalida.");
                        }
                    }
                    } catch (NumberFormatException e) {
                        System.out.println("Digite um numero valido.");
                    }
                }

        }
    }

    public static void removerImovel(List<Imovel> listaImoveis){
        int totalImoveis = listaImoveis.size();
        int totalPaginas = (int) Math.ceil(totalImoveis / 10);
        if(totalPaginas == 0) {
            totalPaginas = 1;
        }
        int paginaAtual = 1;

        while (true) {
            System.out.println("Pagina "+paginaAtual+"/"+totalPaginas);
            System.out.println("---------------------------------------------------------------");
            int inicio = (paginaAtual - 1) * 10;
            int fim = Math.min(inicio + 10, totalImoveis);

            for(int i = inicio; i < fim; i++){
                System.out.print((i + 1) + " - ");
                listaImoveis.get(i).exibirDetalhes();
            }
            System.out.println("---------------------------------------------------------------");
            System.out.println("Digite o numero do corretor(1 - "+fim+") ou:");
            System.out.println("[N] - Proxima pagina | [P] - Voltar a pagina anterior | [S] - Sair");
            String opcao = sc.nextLine();

            if(opcao.equalsIgnoreCase("N") && paginaAtual < totalPaginas) {
                paginaAtual++;
            } else if(opcao.equalsIgnoreCase("P") && paginaAtual > 1) {
                paginaAtual--;
            } else if(opcao.equalsIgnoreCase("S")){
                System.out.println("Saindo...");
                break;
            } else {
                try {
                    int escolha = Integer.parseInt(opcao);
                    if(escolha >= 1 && escolha <= fim ){
                        Imovel imovelSelecionado = listaImoveis.get(inicio + escolha - 1);
                        System.out.println("Deseja remover o imovel: " + imovelSelecionado.getEndereco() + " ?");
                        System.out.println("[S] - Sim | [N] - Nao");
                        String opcao2 = sc.nextLine();
                        if(opcao2.equalsIgnoreCase("S")) {
                            listaImoveis.remove(imovelSelecionado);
                            System.out.println("Imovel removido com sucesso!");
                            break;
                        } else if(opcao2.equalsIgnoreCase("N")) {
                            System.out.println("Operacao cancelada.");
                        } else {
                            System.out.println("Opcao invalida.");
                        }
                    }
                }catch (NumberFormatException e) {
                    System.out.println("Digite um numero valido.");
                }
            }
        }
    }

    public static void removerCorretor(List<Corretor> listaCorretores){
        int totalCorretores = listaCorretores.size();
        int totalPaginas = (int) Math.ceil(totalCorretores / 10);
        if(totalPaginas == 0) {
            totalPaginas = 1;
        }
        int paginaAtual = 1;

        while (true) {
            System.out.println("Pagina "+paginaAtual+"/"+totalPaginas);
            System.out.println("---------------------------------------------------------------");
            int inicio = (paginaAtual - 1) * 10;
            int fim = Math.min(inicio + 10, totalCorretores);

            for(int i = inicio; i < fim; i++){
                System.out.print((i + 1) + " - ");
                listaCorretores.get(i).exibirDetalhes();
            }
            System.out.println("---------------------------------------------------------------");
            System.out.println("Digite o numero do corretor(1 - "+fim+") ou:");
            System.out.println("[N] - Proxima pagina | [P] - Voltar a pagina anterior | [S] - Sair");
            String opcao = sc.nextLine();

            if(opcao.equalsIgnoreCase("N") && paginaAtual < totalPaginas) {
                paginaAtual++;
            } else if(opcao.equalsIgnoreCase("P") && paginaAtual > 1) {
                paginaAtual--;
            } else if(opcao.equalsIgnoreCase("S")){
                System.out.println("Saindo...");
                break;
            } else {
                try {
                    int escolha = Integer.parseInt(opcao);
                    if(escolha >= 1 && escolha <= fim ){
                        Corretor corretorSelecionado = listaCorretores.get(inicio + escolha - 1);
                        System.out.println("Deseja remover o corretor: " + corretorSelecionado.getNome() + " ?");
                        System.out.println("[S] - Sim | [N] - Nao");
                        String opcao2 = sc.nextLine();
                        if(opcao2.equalsIgnoreCase("S")) {
                            listaCorretores.remove(corretorSelecionado);
                            System.out.println("Corretor removido com sucesso!");
                            break;
                        } else if(opcao2.equalsIgnoreCase("N")) {
                            System.out.println("Operacao cancelada.");
                        } else {
                            System.out.println("Opcao invalida.");
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Digite um numero valido.");
                }
            }
        }
    }

    public static void adicionarCorretorNoImovel(List<Corretor> listaCorretores, Imovel imovel){
        int totalCorretores = listaCorretores.size();
        int totalPaginas = (int) Math.ceil(totalCorretores / 10);
        if(totalPaginas == 0) {
            totalPaginas = 1;
        }
        int paginaAtual = 1;

        while (true) {
            System.out.println("Pagina "+paginaAtual+"/"+totalPaginas);
            System.out.println("---------------------------------------------------------------");
            int inicio = (paginaAtual - 1) * 10;
            int fim = Math.min(inicio + 10, totalCorretores);

            for(int i = inicio; i < fim; i++){
                System.out.print((i + 1) + " - ");
                listaCorretores.get(i).exibirDetalhes();
            }
            System.out.println("---------------------------------------------------------------");
            System.out.println("Digite o numero do corretor(1 - "+fim+") ou:");
            System.out.println("[N] - Proxima pagina | [P] - Voltar a pagina anterior | [S] - Sair");
            String opcao = sc.nextLine();

            if(opcao.equalsIgnoreCase("N") && paginaAtual < totalPaginas) {
                paginaAtual++;
            } else if(opcao.equalsIgnoreCase("P") && paginaAtual > 1) {
                paginaAtual--;
            } else if(opcao.equalsIgnoreCase("S")){
                System.out.println("Saindo...");
                break;
            } else {
                try {
                    int escolha = Integer.parseInt(opcao);
                    if (escolha >= 1 && escolha <= fim) {
                        Corretor corretorSelecionado = listaCorretores.get(inicio + escolha - 1);
                        System.out.println("Deseja adicionar o corretor: " + corretorSelecionado.getNome() + " ao imovel?: (S/N)");
                        String opcao2 = sc.nextLine();
                        if (opcao2.equalsIgnoreCase("S")) {
                            imovel.adicionarCorretor(corretorSelecionado);
                            corretorSelecionado.adicionarImovel(imovel);
                            System.out.println("Corretor adicionado com sucesso!");
                            break;
                        } else if (opcao2.equalsIgnoreCase("N")) {
                            System.out.println("Operacao cancelada.");
                        } else {
                            System.out.println("Opcao invalida.");
                        }
                    }
                }catch (NumberFormatException e) {
                    System.out.println("Digite um numero valido.");
                }
            }
        }
    }

}

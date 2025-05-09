package com.example.sistemaimobiliario.usuario;

import com.example.sistemaimobiliario.imoveis.Apartamento;
import com.example.sistemaimobiliario.imoveis.Casa;
import com.example.sistemaimobiliario.imoveis.Imovel;
import com.example.sistemaimobiliario.utilitario.ListaClientes;
import com.example.sistemaimobiliario.utilitario.ListaCorretor;
import com.example.sistemaimobiliario.utilitario.ListaImoveis;

import java.util.List;
import java.util.Scanner;

public class Admin {
    static Scanner sc = new Scanner(System.in);
    static ListaImoveis listaImoveis = new ListaImoveis();

    public static void getResumoMes(){
        int totalAlugadas = 0;
        int totalVendidas = 0;
        for(Corretor corretor : ListaCorretor.getListaCorretores()){
            totalAlugadas += corretor.getQuantidadeAlugadas();
            totalVendidas += corretor.getQuantidadeVendas();
        }
        System.out.println("Casas alugadas esse mês: "+ totalAlugadas);
        System.out.println("Casas vendidas esse mês: "+ totalVendidas);
    }

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
                listaCorretores.get(i).exibirResumo();
            }
            System.out.println("---------------------------------------------------------------");
            System.out.println("Digite o numero do corretor(1 - "+fim+") ou:");
            System.out.println("[N] - Proxima pagina | [P] - Voltar a pagina anterior");
            String opcao = sc.nextLine();

            if(opcao.equalsIgnoreCase("N") && paginaAtual < totalPaginas) {
                paginaAtual++;
            } else if(opcao.equalsIgnoreCase("P") && paginaAtual > 1) {
                paginaAtual--;
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

    public static void adicionarImovel(){
        String tipoImovel = null;
        String tipoVendaAluguel = null;
        String status = null;
        double valorImovel = 0;
        int quantidadeQuartos = 0;
        int quantidadeBanheiros = 0;
        String endereco = null;
        double area = 0;
        String descricao = null;
        String proprietario = null;
        boolean temPiscina = false;
        boolean temGaragem = false;
        boolean temQuintal = false;
        boolean temSacada = false;
        boolean temElevador = false;
        int andar = 0;
            try{
                while(true){
                    System.out.println("Qual o tipo de imovel?(1-Casa, 2-Apartamento)");
                    int opcao6 = sc.nextInt();
                    sc.nextLine();
                    if(opcao6 == 1){
                        tipoImovel = "Casa";
                        break;
                    } else if(opcao6 == 2){
                        tipoImovel = "Apartamento";
                        break;
                    } else {
                        System.out.println("Digite um numero entre 1 e 2.");
                    }
                }
                while(true){
                    System.out.println("Para venda ou aluguel?(1-Venda, 2-Aluguel)");
                    int opcao7 = sc.nextInt();
                    sc.nextLine();
                    if(opcao7 == 1){
                        tipoVendaAluguel = "Venda";
                        status = "Disponivel para Venda";
                        break;
                    } else if(opcao7 == 2){
                        tipoVendaAluguel = "Alugar";
                        status = "Disponivel para Aluguel";
                        break;
                    } else {
                        System.out.println("Digite um numero entre 1 e 2.");
                    }
                }
                while(true){
                    System.out.println("Qual o valor do imovel?(R$)");
                    valorImovel = sc.nextDouble();
                    sc.nextLine();
                    if(valorImovel > 0){
                        break;
                    } else {
                        System.out.println("Digite um valor maior que zero.");
                    }
                }
                while(true){
                    System.out.println("Qual a quantidade de quartos?(Numero Inteiro)");
                    quantidadeQuartos = sc.nextInt();
                    sc.nextLine();
                    if(quantidadeQuartos > 0){
                        break;
                    } else {
                        System.out.println("Digite um numero maior que zero.");
                    }
                }
                while(true){
                    System.out.println("Qual a quantidade de banheiros?(Numero Inteiro)");
                    quantidadeBanheiros = sc.nextInt();
                    sc.nextLine();
                    if(quantidadeBanheiros > 0){
                        break;
                    } else {
                        System.out.println("Digite um numero maior que zero.");
                    }
                }
                while(true){
                    System.out.println("Endereço do Imovel?");
                    endereco = sc.nextLine();
                    if(!endereco.isEmpty()){
                        break;
                    } else {
                        System.out.println("Digite algum endereço, não pode ser vazio.");
                    }
                }
                while(true){
                    System.out.println("Digite a area do imovel(Em metros quadrados)");
                    area = sc.nextDouble();
                    sc.nextLine();
                    if(area > 0){
                        break;
                    } else {
                        System.out.println("Digite um valor maior que zero.");
                    }
                }
                while(true){
                    System.out.println("Dê uma descrição do imovel");
                    descricao = sc.nextLine();
                    if(!descricao.isEmpty()){
                        break;
                    } else {
                        System.out.println("Dîgite alguma descrição, não pode ser vazia.");
                    }
                }
                while(true){
                    System.out.println("Digite o nome do Proprietario: ");
                    proprietario = sc.nextLine();
                    if(!proprietario.isEmpty()){
                        break;
                    } else {
                        System.out.println("Proprietario não pode ser vazio.");
                    }
                }
                if(tipoImovel.equals("Casa")){
                    while(true){
                        System.out.println("A casa tem piscina?(S/N)");
                        String opcao8 = sc.nextLine();
                        if(opcao8.equalsIgnoreCase("S")){
                            temPiscina = true;
                            break;
                        } else if(opcao8.equalsIgnoreCase("N")){
                            temPiscina = false;
                            break;
                        } else {
                            System.out.println("Digite S ou N.");
                        }
                    }
                    while(true) {
                        System.out.println("A casa tem garagem?(S/N)");
                        String opcao9 = sc.nextLine();
                        if(opcao9.equalsIgnoreCase("S")){
                            temGaragem = true;
                            break;
                        } else if(opcao9.equalsIgnoreCase("N")){
                            temGaragem = false;
                            break;
                        } else {
                            System.out.println("Digite S ou N.");
                        }
                    }
                    while(true){
                        System.out.println("A casa tem quintal?(S/N)");
                        String opcao10 = sc.nextLine();
                        if(opcao10.equalsIgnoreCase("S")){
                            temQuintal = true;
                            break;
                        } else if(opcao10.equalsIgnoreCase("N")){
                            temQuintal = false;
                            break;
                        } else {
                            System.out.println("Digite S ou N.");
                        }
                    }
                } else {
                    while(true){
                        System.out.println("Qual o andar do apartamento?(Numero Inteiro)");
                        andar = sc.nextInt();
                        sc.nextLine();
                        if(andar > 0){
                            break;
                        } else {
                            System.out.println("Digite um numero maior que zero.");
                        }
                    }
                    while(true) {
                        System.out.println("O apartamento tem sacada?(S/N)");
                        String opcao11 = sc.nextLine();
                        if(opcao11.equalsIgnoreCase("S")){
                            temSacada = true;
                            break;
                        } else if(opcao11.equalsIgnoreCase("N")){
                            temSacada = false;
                            break;
                        } else {
                            System.out.println("Digite S ou N.");
                        }

                    }
                    while(true){
                        System.out.println("O apartamento tem elevador?(S/N)");
                        String opcao12 = sc.nextLine();
                        if(opcao12.equalsIgnoreCase("S")){
                            temElevador = true;
                            break;
                        } else if(opcao12.equalsIgnoreCase("N")){
                            temElevador = false;
                            break;
                        } else {
                            System.out.println("Digite S ou N.");
                        }
                    }

                }
                if(tipoImovel.equals("Casa")){
                    Casa casaCriada = new Casa(endereco, valorImovel, quantidadeQuartos, quantidadeBanheiros, area, descricao, proprietario, status, temQuintal, temGaragem, temPiscina, tipoImovel, tipoVendaAluguel);
                    System.out.println("Adicione Corretores afiliados ao Imovel");
                    adicionarCorretorNoImovel(ListaCorretor.getListaCorretores(), casaCriada);
                    listaImoveis.add(casaCriada);
                } else {
                    Apartamento apCriado = new Apartamento(endereco, valorImovel, quantidadeQuartos, quantidadeBanheiros, area, descricao, proprietario, status, temElevador, temSacada, andar, tipoImovel, tipoVendaAluguel);
                    System.out.println("Adicione Corretores afiliados ao Imovel");
                    adicionarCorretorNoImovel(ListaCorretor.getListaCorretores(), apCriado);
                    listaImoveis.add(apCriado);
                }
                System.out.println("Processo Concluido!");
            }catch(Exception e){
                System.out.println("Entrada inválida. Por favor, digite um numero");
                sc.nextLine();
            }

    }

}

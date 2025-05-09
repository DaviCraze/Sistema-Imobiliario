package com.example.sistemaimobiliario.terminal;

import com.example.sistemaimobiliario.imoveis.Apartamento;
import com.example.sistemaimobiliario.imoveis.Casa;
import com.example.sistemaimobiliario.imoveis.Imovel;
import com.example.sistemaimobiliario.usuario.Admin;
import com.example.sistemaimobiliario.usuario.Cliente;
import com.example.sistemaimobiliario.utilitario.ListaClientes;
import com.example.sistemaimobiliario.utilitario.ListaCorretor;
import com.example.sistemaimobiliario.utilitario.ListaImoveis;

import java.util.Scanner;

public class MenuAdmin {
    static Scanner sc = new Scanner(System.in);
    static ListaClientes listaClientes = new ListaClientes();
    static ListaImoveis listaImoveis = new ListaImoveis();

    public static void iniciaAdmin(){
        int opcao;
        boolean executando = true;

        do{
            try{
                System.out.println("Bem vindo Administrador!");
                System.out.println("1 - Gerenciar Clientes");
                System.out.println("2 - Gerenciar Corretores");
                System.out.println("3 - Gerenciar Imoveis");
                System.out.println("4 - Dados do mês");
                System.out.println("5 - Log out");
                opcao = sc.nextInt();
                sc.nextLine();
                switch(opcao){
                    case 1:
                        System.out.println("Gerenciamento de Clientes");
                        System.out.println("1 - Cadastrar Cliente");
                        System.out.println("2 - Remover Cliente");
                        System.out.println("3 - Buscar Cliente");
                        System.out.println("4 - Atualizar informações do cliente");
                        System.out.println("5 - Voltar");
                        int opcao1 = sc.nextInt();
                        sc.nextLine();
                        switch(opcao1){
                            case 1:
                                System.out.println("Cadastrando novo cliente...");
                                CriarConta.criarContaCliente();
                                break;
                            case 2:
                                System.out.println("Remover um cliente da lista...");
                                Admin.removerCliente(ListaClientes.getListaClientes());
                                break;
                            case 3:
                                System.out.println("Digite o email do cliente: ");
                                String email = sc.nextLine();
                                Cliente clienteBuscado = listaClientes.busca(email);
                                clienteBuscado.exibirDetalhes();
                                break;
                            case 4:
                                System.out.println("Digite o email do cliente: ");
                                String email1 = sc.nextLine();
                                Cliente clienteAtualizado = listaClientes.busca(email1);
                                System.out.println("1 - Nome");
                                System.out.println("2 - Telefone");
                                System.out.println("3 - Voltar");
                                int opcao2 = sc.nextInt();
                                sc.nextLine();
                                switch(opcao2){
                                    case 1:
                                        String novoNome = CriarConta.criarVariavel("nome");
                                        clienteAtualizado.setNome(novoNome);
                                        System.out.println("Nome alterado com sucesso!");
                                        break;
                                    case 2:
                                        String novoTelefone = CriarConta.criarVariavel("telefone");
                                        clienteAtualizado.setTelefone(novoTelefone);
                                        System.out.println("Telefone alterado com sucesso!");
                                        break;
                                    case 3:
                                        System.out.println("Voltando...");
                                        break;
                                    default :
                                        System.out.println("Digite um numero entre 1 e 3.");
                                }
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Digite um numero entre 1 e 5.");
                        }
                        break;
                    case 2:
                        System.out.println("Gerenciamento de Corretores");
                        System.out.println("1 - Cadastrar Corretor");
                        System.out.println("2 - Remover Corretor");
                        System.out.println("3 - Buscar Corretor");
                        System.out.println("4 - Atualizar informações do Corretor");
                        System.out.println("5 - Voltar");
                        int opcao3 = sc.nextInt();
                        sc.nextLine();
                        switch(opcao3){
                            case 1:
                                System.out.println("Cadastrando novo Corretor...");
                                CriarConta.criarContaCorretor();
                                break;
                            case 2:
                                System.out.println("Remover um Corretor da lista...");
                                Admin.removerCorretor(ListaCorretor.getListaCorretores());
                                break;
                            case 3:
                                System.out.println("Digite o email do Corretor: ");
                                String email2 = sc.nextLine();
                                Cliente clienteBuscado2 = listaClientes.busca(email2);
                                clienteBuscado2.exibirDetalhes();
                                break;
                            case 4:
                                System.out.println("Digite o email do Corretor: ");
                                String email3 = sc.nextLine();
                                Cliente clienteAtualizado2 = listaClientes.busca(email3);
                                System.out.println("1 - Nome");
                                System.out.println("2 - Telefone");
                                System.out.println("3 - Voltar");
                                int opcao4 = sc.nextInt();
                                sc.nextLine();
                                switch(opcao4){
                                    case 1:
                                        String novoNome2 = CriarConta.criarVariavel("nome");
                                        clienteAtualizado2.setNome(novoNome2);
                                        System.out.println("Nome alterado com sucesso!");
                                        break;
                                    case 2:
                                        String novoTelefone2 = CriarConta.criarVariavel("telefone");
                                        clienteAtualizado2.setTelefone(novoTelefone2);
                                        System.out.println("Telefone alterado com sucesso!");
                                        break;
                                    case 3:
                                        System.out.println("Voltando...");
                                        break;
                                    default:
                                        System.out.println("Digite um numero entre 1 e 3.");
                                }
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Digite um numero entre 1 e 5.");
                        }
                        break;
                    case 3:
                        System.out.println("Gerenciamento de Imoveis");
                        System.out.println("1 - Adicionar novo Imovel");
                        System.out.println("2 - Remover Imovel");
                        System.out.println("3 - Buscar Imovel");
                        System.out.println("4 - Atualizar");
                        System.out.println("5 - Voltar");
                        int opcao5 = sc.nextInt();
                        sc.nextLine();

                        switch (opcao5) {
                            case 1:
                                String tipoImovel;
                                String tipoVendaAluguel;
                                String status;
                                double valorImovel;
                                int quantidadeQuartos;
                                int quantidadeBanheiros;
                                String endereco;
                                double area;
                                String descricao;
                                String proprietario;
                                boolean temPiscina = false;
                                boolean temGaragem = false;
                                boolean temQuintal = false;
                                boolean temSacada = false;
                                boolean temElevador = false;
                                int andar = 0;
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
                                    sc.nextLine();
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
                                    sc.nextLine();
                                    if(!descricao.isEmpty()){
                                        break;
                                    } else {
                                        System.out.println("Dîgite alguma descrição, não pode ser vazia.");
                                    }
                                }
                                while(true){
                                    System.out.println("Digite o nome do Proprietario: ");
                                    proprietario = sc.nextLine();
                                    sc.nextLine();
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
                                        if(opcao8.equals("S")){
                                            temPiscina = true;
                                            break;
                                        } else if(opcao8.equals("N")){
                                            temPiscina = false;
                                            break;
                                        } else {
                                            System.out.println("Digite S ou N.");
                                        }
                                    }
                                    while(true) {
                                        System.out.println("A casa tem garagem?(S/N)");
                                        String opcao9 = sc.nextLine();
                                        if(opcao9.equals("S")){
                                            temGaragem = true;
                                            break;
                                        } else if(opcao9.equals("N")){
                                            temGaragem = false;
                                            break;
                                        } else {
                                            System.out.println("Digite S ou N.");
                                        }
                                    }
                                    while(true){
                                        System.out.println("A casa tem quintal?(S/N)");
                                        String opcao10 = sc.nextLine();
                                        if(opcao10.equals("S")){
                                            temQuintal = true;
                                            break;
                                        } else if(opcao10.equals("N")){
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
                                        if(opcao11.equals("S")){
                                            temSacada = true;
                                            break;
                                        } else if(opcao11.equals("N")){
                                            temSacada = false;
                                            break;
                                        } else {
                                            System.out.println("Digite S ou N.");
                                        }

                                    }
                                    while(true){
                                        System.out.println("O apartamento tem elevador?(S/N)");
                                        String opcao12 = sc.nextLine();
                                        if(opcao12.equals("S")){
                                            temElevador = true;
                                            break;
                                        } else if(opcao12.equals("N")){
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
                                    Admin.adicionarCorretorNoImovel(ListaCorretor.getListaCorretores(), casaCriada);
                                } else if(tipoImovel.equals("Apartamento")) {
                                    Apartamento apCriado = new Apartamento(endereco, valorImovel, quantidadeQuartos, quantidadeBanheiros, area, descricao, proprietario, status, temElevador, temSacada, andar, tipoImovel, tipoVendaAluguel);
                                    System.out.println("Adicione Corretores afiliados ao Imovel");
                                    Admin.adicionarCorretorNoImovel(ListaCorretor.getListaCorretores(), apCriado);
                                }
                                System.out.println("Processo Concluido!");
                                break;
                            case 2:
                                Admin.removerImovel(ListaImoveis.getListaImoveis());
                                break;
                            case 3:
                                System.out.println("Digite o endereço do Imovel: ");
                                String endereco1 = sc.nextLine();
                                sc.nextLine();
                                Cliente clienteBuscado = listaClientes.busca(endereco1);
                                clienteBuscado.exibirDetalhes();
                                break;
                            case 4:
                                System.out.println("Digite o endereço do imovel no qual deseja atualizar: ");
                                String endereco2 = sc.nextLine();
                                sc.nextLine();
                                Imovel imovelAtualizado = listaImoveis.busca(endereco2);
                                System.out.println("1 - Preço");
                                System.out.println("2 - Quantidade de Quartos");
                                System.out.println("3 - Quantidade de Banheiros");
                                System.out.println("4 - Descrição");
                                System.out.println("5 - Status");
                                int opcao13 = sc.nextInt();
                                sc.nextLine();
                                switch(opcao13){
                                    case 1:
                                        System.out.println("Digite o novo preço do imovel: ");
                                        double novoPreco = sc.nextDouble();
                                        sc.nextLine();
                                        if(novoPreco < 0){
                                            System.out.println("Digite um preço maior que zero.");
                                        } else {
                                            imovelAtualizado.setPreco(novoPreco);
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Digite a nova quantidade de quartos: ");
                                        int novaQtdQuartos = sc.nextInt();
                                        sc.nextLine();
                                        if()
                                }
                        }
                }
            }
        }
    }
}

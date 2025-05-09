package com.example.sistemaimobiliario.terminal;

import com.example.sistemaimobiliario.imoveis.Apartamento;
import com.example.sistemaimobiliario.imoveis.Casa;
import com.example.sistemaimobiliario.imoveis.Imovel;
import com.example.sistemaimobiliario.usuario.Admin;
import com.example.sistemaimobiliario.usuario.Cliente;
import com.example.sistemaimobiliario.utilitario.ListaClientes;
import com.example.sistemaimobiliario.utilitario.ListaCorretor;
import com.example.sistemaimobiliario.utilitario.ListaImoveis;

import java.util.InputMismatchException;
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
                                Admin.adicionarImovel();
                                break;
                            case 2:
                                Admin.removerImovel(ListaImoveis.getListaImoveis());
                                break;
                            case 3:
                                System.out.println("Digite o endereço do Imovel: ");
                                String endereco1 = sc.nextLine();
                                Imovel imovelBuscado = listaImoveis.busca(endereco1);
                                imovelBuscado.exibirDetalhes();
                                break;
                            case 4:
                                System.out.println("Digite o endereço do imovel no qual deseja atualizar: ");
                                String endereco2 = sc.nextLine();
                                Imovel imovelAtualizado = listaImoveis.busca(endereco2);
                                System.out.println("1 - Preço");
                                System.out.println("2 - Quantidade de Quartos");
                                System.out.println("3 - Quantidade de Banheiros");
                                System.out.println("4 - Descrição");
                                System.out.println("5 - Status");
                                System.out.println("6 - Voltar");
                                int opcao13 = sc.nextInt();
                                sc.nextLine();
                                switch(opcao13){
                                    case 1:
                                        System.out.println("Digite o novo preço do imovel: ");
                                        double novoPreco = sc.nextDouble();
                                        sc.nextLine();
                                        imovelAtualizado.setPreco(novoPreco);
                                        break;
                                    case 2:
                                        System.out.println("Digite a nova quantidade de quartos: ");
                                        int novaQtdQuartos = sc.nextInt();
                                        sc.nextLine();
                                        imovelAtualizado.setQuartos(novaQtdQuartos);
                                        break;
                                    case 3:
                                        System.out.println("Digite a nova quantidade de banheiros: ");
                                        int novaQtdBanheiros = sc.nextInt();
                                        sc.nextLine();
                                        imovelAtualizado.setBanheiros(novaQtdBanheiros);
                                        break;
                                    case 4:
                                        System.out.println("Digite uma nova descrição para o imovel");
                                        String novaDescricao = sc.nextLine();
                                        sc.nextLine();
                                        imovelAtualizado.setDescricao(novaDescricao);
                                        break;
                                    case 5:
                                        System.out.println("1 - Indisponivel, 2 - Disponivel");
                                        int opcao14 = sc.nextInt();
                                        sc.nextLine();
                                        if(opcao14 == 1){
                                            imovelAtualizado.setStatus("Indisponivel");
                                        } else if(opcao14 == 2){
                                            imovelAtualizado.setStatus("Disponivel");
                                        } else {
                                            System.out.println("Digite um numero entre 1 e 2.");
                                        }
                                        break;
                                    case 6:
                                        break;
                                    default:
                                        System.out.println("Digite um numero entre 1 e 6.");
                                }
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Digite um numero entre 1 e 5");
                        }
                        break;
                    case 4:
                        Admin.getResumoMes();
                        break;
                    case 5:
                        System.out.println("Deseja sair mesmo?(S/N)");
                        String opcao6 = sc.nextLine();
                        if(opcao6.equalsIgnoreCase("s")){
                            System.out.println("Saindo...");
                            executando = false;
                        } else if(opcao6.equalsIgnoreCase("n")){
                            System.out.println("Voltando...");
                        } else {
                            System.out.println("Digite S ou N.");
                        }
                        break;
                    default:
                        System.out.println("Digite um numero entre 1 e 5.");
                }
            }catch (InputMismatchException e){
                System.out.println("Digite um numero inteiro.");
                sc.nextLine();
            }
        }while(executando);
    }
}


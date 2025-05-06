package com.example.sistemaimobiliario.terminal;

import java.util.Scanner;

public class MenuAdmin {
    static Scanner sc = new Scanner(System.in);

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
                        }
                }
            }
        }
    }
}

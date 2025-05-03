package com.example.sistemaimobiliario.terminal;

import com.example.sistemaimobiliario.usuario.Corretor;

import java.util.Scanner;

public class MenuCorretor {
    static Scanner sc = new Scanner(System.in);

    public static void iniciaCorretor(Corretor corretor) {
        int opcao;
        boolean executando = true;

        do {
            try {
                System.out.println("Bem vindo: "+corretor.getNome());
                System.out.println("1 - Ver perfil");
                System.out.println("2 - Sua lista de imoveis");
                System.out.println("3 - Dados do mes");
                System.out.println("4 - Log out");
                opcao = sc.nextInt();
                sc.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.println("Perfil do corretor: ");
                        corretor.exibirDetalhesPerfil();
                        System.out.println("1 - Editar perfil");
                        System.out.println("2 - Voltar");
                        int opcao1 = sc.nextInt();
                        sc.nextLine();
                        switch (opcao1) {
                            case 1:
                                System.out.println("1 - Nome");
                                System.out.println("2 - Telefone");
                                System.out.println("3 - Voltar");
                                int opcao2 = sc.nextInt();
                                sc.nextLine();
                                switch (opcao2) {
                                    case 1:
                                        String novoNome = CriarConta.criarVariavel("nome");
                                        corretor.setNome(novoNome);
                                        System.out.println("Nome alterado com sucesso!");
                                        break;
                                    case 2:
                                        String novoTelefone = CriarConta.criarVariavel("telefone");
                                        corretor.setTelefone(novoTelefone);
                                        System.out.println("Telefone alterado com sucesso!");
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        System.out.println("Digite um numero de 1 a 3.");
                                }
                            case 2:
                                break;
                        }
                        break;
                    case 2:
                }
            }
        }
    }
}

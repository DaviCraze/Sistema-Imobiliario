package com.example.sistemaimobiliario.terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.example.sistemaimobiliario.usuario.Cliente;
import com.example.sistemaimobiliario.usuario.Corretor;
import com.example.sistemaimobiliario.usuario.Pessoa;
import com.example.sistemaimobiliario.utilitario.ListaClientes;
import com.example.sistemaimobiliario.utilitario.ListaCorretor;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("Sistema de Imobiliário");
            System.out.println("Bem-vindo ao sistema de gerenciamento imobiliário!");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Criar conta Cliente");
            System.out.println("2 - Cria conta Corretor");
            System.out.println("3 - Log in");
            System.out.println("4 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();
            switch(opcao){
                case 1:
                    CriarConta.criarContaCliente();
                    break;
                case 2:
                    CriarConta.criarContaCorretor();
                    break;
                case 3:
                    System.out.println("Digite seu email: ");
                    String email = sc.nextLine();
                    System.out.println("Digite sua senha: ");
                    String senha = sc.nextLine();

                    List<Pessoa> usuarios = new ArrayList<>();
                    usuarios.addAll(ListaClientes.getListaClientes());
                    usuarios.addAll(ListaCorretor.getListaCorretores());
                    Pessoa conta = null;
                    boolean loginValido = false;
                    for(Pessoa usuario : usuarios){
                        if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)){
                            conta = usuario;
                            loginValido = true;
                            break;
                        }
                    }

                    if(loginValido && conta instanceof Cliente contaCliente){
                        MenuCliente.iniciaCliente(contaCliente);
                    } else if(loginValido && conta instanceof Corretor contaCorretor){
                        MenuCorretor.iniciaCorretor(contaCorretor);
                    } else if(email.equals("admin") && senha.equals("admin")){
                        System.out.println("Logado como administrador.");
                        MenuAdmin.iniciaAdmin();
                    }
                    break;
                case 4:
                    System.out.println("Saindo....");
                    break;
                default :
                    System.out.println("Opção invalida.");
            }

        }while(opcao != 4);
    }
}

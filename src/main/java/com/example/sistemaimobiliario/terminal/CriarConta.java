package com.example.sistemaimobiliario.terminal;

import com.example.sistemaimobiliario.usuario.Cliente;
import com.example.sistemaimobiliario.utilitario.ListaClientes;
import java.util.Scanner;

public class CriarConta {
    Scanner sc = new Scanner(System.in);

    public void criarContaCliente() {
        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite seu CPF: ");
        String cpf = sc.nextLine();

        System.out.println("Digite seu telefone: ");
        String telefone = sc.nextLine();

        System.out.println("Digite seu email: ");
        String email = sc.nextLine();

        System.out.println("Digite sua senha: ");
        String senha = sc.nextLine();

        System.out.println("Verifique sua senha: ");
        String senhaVerificada = sc.nextLine();

        Cliente cliente = new Cliente(nome, cpf, telefone, email, senha);
        for(Cliente clienteC : ListaClientes.getListaClientes()) {
            if(clienteC.getCpf().equals(cliente.getCpf())) {
                System.out.println("Já existe um cliente cadastrado com esse CPF.");
                return;
            }

        }

    }
}

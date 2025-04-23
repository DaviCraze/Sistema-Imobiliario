package com.example.sistemaimobiliario.terminal;

import com.example.sistemaimobiliario.usuario.Cliente;
import com.example.sistemaimobiliario.usuario.Corretor;
import com.example.sistemaimobiliario.usuario.Pessoa;
import com.example.sistemaimobiliario.utilitario.ListaClientes;
import com.example.sistemaimobiliario.utilitario.ListaCorretor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CriarConta {
    static Scanner sc = new Scanner(System.in);

    public static String criarVariavel(String tipo) {
        boolean achou;
        String variavel;
        List<Pessoa> usuarios = new ArrayList<>();
        usuarios.addAll(ListaClientes.getListaClientes());
        usuarios.addAll(ListaCorretor.getListaCorretores());
        do {
            System.out.println("Digite seu " + tipo + ": ");
            variavel = sc.nextLine();
            achou = false;

            for(Pessoa usuario : usuarios){
                switch (tipo.toLowerCase()) {
                    case "cpf" :
                        if(usuario.getCpf() != null && usuario.getCpf().equals(variavel)){
                            System.out.println("Já existe uma conta com esse "+tipo+" cadastrada.");
                            achou = true;
                            break;
                        }
                        break;
                    case "email" :
                        if(usuario.getEmail() != null && usuario.getEmail().equals(variavel)){
                            System.out.println("Já existe uma conta com esse "+tipo+" cadastrada.");
                            achou = true;
                            break;
                        }
                        break;
                    case "telefone" :
                        if(usuario.getTelefone() != null && usuario.getTelefone().equals(variavel)){
                            System.out.println("Já existe uma conta com esse "+tipo+" cadastrada.");
                            achou = true;
                            break;
                        }
                        break;
                    case "cnpj" :
                        if (usuario instanceof Corretor corretor){
                            if(corretor.getCnpj() != null && corretor.getCnpj().equals(variavel)){
                                System.out.println("Já existe uma conta com esse "+tipo+" cadastrada.");
                                achou = true;
                                break;
                            }
                            break;
                        }

                    case "nomeempresa" :
                        if (usuario instanceof Corretor corretor){
                            if(corretor.getNomeEmpresa() != null && corretor.getNomeEmpresa().equals(variavel)){
                                System.out.println("Já existe uma conta com esse "+tipo+" cadastrada.");
                                achou = true;
                                break;
                            }
                        }
                        break;
                }
                if (achou) break;
            }
        }while (achou);
        return variavel;
    }


    public static String criarSenha(){
        boolean senhaVerificada = false;
        String senha;
        String senhaV;
        do{
            System.out.println("Digite sua senha: ");
            senha = sc.nextLine();
            System.out.println("Verifique sua senha: ");
            senhaV = sc.nextLine();
            if(senha.equals(senhaV)){
                senhaVerificada = true;
            } else {
                System.out.println("Verifique sua senha novamente.");
            }
        }while(!senhaVerificada);
        return senha;
    }

    public static void criarContaCliente() {
        String nome = criarVariavel("nome");
        String cpf = criarVariavel("cpf");
        String telefone = criarVariavel("telefone");
        String email = criarVariavel("email");
        String senha = criarSenha();
        Cliente cliente = new Cliente(nome, cpf, telefone, email, senha);
        ListaClientes.adicionarCliente(cliente);
        System.out.println("Conta criada com sucesso!");
    }

    public static void criarContaCorretor() {
        String nome = criarVariavel("nome");
        String cpf = criarVariavel("cpf");
        String telefone = criarVariavel("telefone");
        String email = criarVariavel("email");
        String cnpj = criarVariavel("cnpj");
        String empresaNome = criarVariavel("nomeempresa");
        String senha = criarSenha();
        Corretor corretor = new Corretor(nome, cpf, telefone, email, senha, cnpj, empresaNome);
        ListaCorretor.adicionarCorretor(corretor);
        System.out.println("Conta criada com sucesso!");
    }
}

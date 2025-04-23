package com.example.sistemaimobiliario.terminal;

import com.example.sistemaimobiliario.usuario.Cliente;
import com.example.sistemaimobiliario.usuario.Pessoa;

import java.util.Scanner;

public class MenuCliente {
    Scanner sc = new Scanner(System.in);

    public static void iniciaCliente(Pessoa cliente){
        Cliente clienteC = (Cliente) cliente;
        int opcao;
        do{
            System.out.println("Bem vindo: "+clienteC.getNome());
            System.out.println("1 - Ver perfil");
            System.out.println("2 - Buscar Imoveis");
            System.out.println("3 - Lista de Imoveis Favoritos");
        }

    }
}

package com.example.sistemaimobiliario.utilitario;

import com.example.sistemaimobiliario.usuario.Cliente;
import com.example.sistemaimobiliario.usuario.IRepositorio;

import java.util.ArrayList;

public class ListaClientes implements IRepositorio {
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();

    @Override
    public void add(Object objeto) {
        if(objeto instanceof Cliente cliente) {
            listaClientes.add(cliente);
        } else {
            System.out.println("Objeto não é um Cliente!");
        }
    }

    @Override
    public void remove(Object objeto) {
        if(objeto instanceof Cliente cliente) {
            listaClientes.remove(cliente);
        } else {
            System.out.println("Objeto não é um Cliente!");
        }
    }

    @Override
    public void update(Object objeto) {
        if(objeto instanceof Cliente cliente) {
            for(int i = 0; i < listaClientes.size(); i++) {
                if(listaClientes.get(i).getCpf().equals(cliente.getCpf())) {
                    listaClientes.set(i, cliente);
                    return;
                }
            }
            System.out.println("Cliente não foi encontrado na lista.");
        } else {
            System.out.println("Objeto não é um Cliente!");
        }

    }
    @Override
    public Cliente busca(String email) {
        for(Cliente clienteC : listaClientes){
            if(clienteC.getCpf().equals(email)) {
                return clienteC;
            }
        }
        System.out.println("Cliente não encontrado");
        return null;
    }


    public static ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
}

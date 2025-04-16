package com.example.sistemaimobiliario.utilitario;

import com.example.sistemaimobiliario.usuario.Cliente;
import java.util.ArrayList;

public class ListaClientes {
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();

    public static void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public static ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
}

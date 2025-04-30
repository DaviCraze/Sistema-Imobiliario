package com.example.sistemaimobiliario.usuario;

public interface IRepositorio {
    void add(Object objeto);
    void remove(Object objeto);
    void update(Object objeto);
    void busca(String cpf);

}

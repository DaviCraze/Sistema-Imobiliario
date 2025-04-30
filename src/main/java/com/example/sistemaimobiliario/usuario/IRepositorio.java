package com.example.sistemaimobiliario.usuario;

public interface IRepositorio {
    void add(Object objeto);
    void remove(Object objeto);
    void update(Object objeto);
    Object busca(String cpf);

}

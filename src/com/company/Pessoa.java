package com.company;

import java.util.List;

public class Pessoa {
    public int id;
    public String Nome;
    public List<String> telefones;

    public Pessoa(int id, String nome, List<String> telefones) {
        this.id = id;
        Nome = nome;
        this.telefones = telefones;
    }
}

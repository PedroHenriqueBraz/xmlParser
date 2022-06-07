package com.company;

import com.company.annotations.TagName;

import java.util.List;

@TagName("product")
public class Produto {
    public Integer id;
    public String nome;
    public List<Tag> tags;

    public Produto(Integer id, String nome, List<Tag> tags) {
        this.id = id;
        this.nome = nome;
        this.tags = tags;
    }
}

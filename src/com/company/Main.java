package com.company;

import com.company.parser.XmlParser;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
	// write your code here
        var telefones = new ArrayList<String>();
        telefones.add("11 9012344");
        telefones.add("11 4578996");

        var pessoa = new Pessoa(10, "pedro", telefones);

        var tags = new ArrayList<Tag>();
        tags.add(new Tag("t1"));
        tags.add(new Tag("t2"));
        var prod = new Produto(111, "prod1", tags);

        System.out.println(XmlParser.toXml(prod));
    }
}

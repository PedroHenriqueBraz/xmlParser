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

        System.out.println(XmlParser.toXml(pessoa));
    }
}

package com.example.everis.Hamburguer;

import java.util.ArrayList;
import java.util.List;

public class HamburguerDAO {

    //um método simples para criar os objetos
    public static List<Hamburguer> chamarlanche(){

        List<Hamburguer> hamburguer = new ArrayList<>();

        Hamburguer hamburguer1 = adicionar("X-Salada", "Pão, hambúrguer, queijo, alface, tomate, tomate", 7.00, 0);

        Hamburguer hamburguer2 = adicionar("X-Bacon", "Pão, hambúrguer, queijo, alface, tomate, tomate e bacon", 10.00, 1);

        Hamburguer hamburguer3 = adicionar("X-Tudo", "Pão, 2 hambúrgueres, duas vezes queijo e presunto, alface, tomate e bacon", 13.00, 2);

        hamburguer.add(hamburguer1);
        hamburguer.add(hamburguer2);
        hamburguer.add(hamburguer3);

        return  hamburguer;
    }

    private static Hamburguer adicionar(String nome, String descricao, double preco, int id){
        Hamburguer hamburguer = new Hamburguer();

        hamburguer.nome = nome;
        hamburguer.descricao = descricao;
        hamburguer.preco = preco;
        hamburguer.id = id;

        return hamburguer;
    }
}

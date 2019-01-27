package com.example.everis.Hamburguer;

public class Hamburguer {
    public String nome, descricao;
    public int id;
    public double preco;

    @Override
    public  String toString() {
        return "Nome: " + nome + "\tPreço: " + preco + "\nDescrição: " + descricao;
    }
}

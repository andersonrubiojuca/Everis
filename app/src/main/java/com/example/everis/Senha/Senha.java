package com.example.everis.Senha;

public class Senha {
    private String login, senha;


    public void setLogin(String login) {
        this.login = login;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }

    //uma autenticação simples
    public boolean autenticacao(){
        String[] rLogin = new String[1];
        rLogin[0] = "login";
        String[] rSenha = new String[1];
        rSenha[0] = "senha";

        if(login.equals(rLogin[0]) && senha.equals(rSenha[0])){
            return true;
        } else return false;
    }
}

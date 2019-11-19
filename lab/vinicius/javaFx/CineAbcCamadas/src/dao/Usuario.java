/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author vovostudio
 */
public class Usuario extends Pessoa {

    private String senha;

    public Usuario(String senha, String nome, char sexo, String email, String cpf) {
        super(nome, sexo, email, cpf);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}

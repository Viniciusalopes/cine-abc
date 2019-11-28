/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author vovostudio
 */
public class Sala {

    private int id;
    private String nome;
    private ArrayList<Sessao> sessoes;

    public Sala(int id, String nome, ArrayList<Sessao> sessoes) {
        this.id = id;
        this.nome = nome;
        this.sessoes = sessoes;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Sessao> getSessoes() {
        return sessoes;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author vovostudio
 */
public class Sessao {

    private String periodo;
    private Poltrona[][] poltrona = new Poltrona[10][10];
    private Filme filme = new Filme();

    private int id;

    public int getId() {
        return id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public Poltrona[][] getPoltrona() {
        return poltrona;
    }

    public Filme getFilme() {
        return filme;
    }

}
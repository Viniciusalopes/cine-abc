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

    private int id;
    private String periodo;
    private Poltrona[][] poltronas;
    private Filme filme;

    public Sessao(int id, String periodo, Poltrona[][] poltronas, Filme filme) {
        this.id = id;
        this.periodo = periodo;
        this.poltronas = poltronas;
        this.filme = filme;
    }

    public int getId() {
        return id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public Poltrona[][] getPoltronas() {
        return poltronas;
    }

    public Filme getFilme() {
        return filme;
    }

}

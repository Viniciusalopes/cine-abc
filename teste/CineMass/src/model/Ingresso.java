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
public class Ingresso {

    private int id;
    private int filme_ID;
    private int sessao_ID;
    private int poltrona_ID;
    private boolean meia;
    private double preco;

    public Ingresso(int id, int filme_ID, int sessao_ID, int poltrona_ID, boolean meia, double preco) {
        this.id = id;
        this.filme_ID = filme_ID;
        this.sessao_ID = sessao_ID;
        this.poltrona_ID = poltrona_ID;
        this.meia = meia;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public int getFilme_ID() {
        return filme_ID;
    }

    public int getSessao_ID() {
        return sessao_ID;
    }

    public int getPoltrona_ID() {
        return poltrona_ID;
    }

    public boolean isMeia() {
        return meia;
    }

    public double getPreco() {
        return preco;
    }

}

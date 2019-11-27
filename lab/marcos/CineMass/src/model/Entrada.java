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
public class Entrada {

    private int id;
    private int filme_id;
    private int sala_id;

    private int sessao_id;
    private int poltrona_id;
    private boolean meia;
    private double preco;

    public Entrada(int id, int filme_id, int sala_id, int sessao_id, int poltrona_id, boolean meia, double preco) {
        this.id = id;
        this.filme_id = filme_id;
        this.sala_id = sala_id;
        this.sessao_id = sessao_id;
        this.poltrona_id = poltrona_id;
        this.meia = meia;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public int getFilme_id() {
        return filme_id;
    }

    public int getSala_id() {
        return sala_id;
    }

    public int getSessao_id() {
        return sessao_id;
    }

    public int getPoltrona_id() {
        return poltrona_id;
    }

    public boolean isMeia() {
        return meia;
    }

    public double getPreco() {
        return preco;
    }

}

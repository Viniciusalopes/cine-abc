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
public class Poltrona {

    private int id;
    private char fileira;
    private int numero;
    private int ingresso_ID;

    public Poltrona(int id, char fileira, int numero, int ingresso_ID) {
        this.id = id;
        this.fileira = fileira;
        this.numero = numero;
        this.ingresso_ID = ingresso_ID;

    }

    public int getId() {
        return id;
    }

    public int getIngresso_ID() {
        return ingresso_ID;
    }

    public char getFileira() {
        return fileira;
    }

    public int getNumero() {
        return numero;
    }

}

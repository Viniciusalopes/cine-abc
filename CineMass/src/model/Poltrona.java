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

    public Poltrona(int id, char fileira, int num) {
        this.id = id;
        this.fileira = fileira;
        this.numero = num;

    }

    public int getId() {
        return id;
    }

    public char getFileira() {
        return fileira;
    }

    public int getNumero() {
        return numero;
    }

}

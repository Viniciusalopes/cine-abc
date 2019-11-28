/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vovostudio
 */
public class Cinema {

    private int id;
    private String Nome;
    private ArrayList<Sala> salas;

    public Cinema(int id, String Nome, ArrayList<Sala> salas) {
        this.id = id;
        this.Nome = Nome;
        this.salas = salas;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return Nome;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public void setSalas(ArrayList<Sala> salas) {
        this.salas = salas;
    }

}

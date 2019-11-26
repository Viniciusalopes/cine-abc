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
    private String nome;
    private List<Sala> salas = new ArrayList<Sala>();

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Sala> getSalas() {
        return salas;
    }
}

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
public class Filme {

    // Atributos
    private int id;
    private String titulo;

    // Construtor
    public Filme(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }
    
    // Get
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Filme;
import model.Ingresso;
import model.Poltrona;
import model.Sala;
import model.Sessao;

/**
 *
 * @author vovostudio
 */
public class Dao {

    private ArrayList<Filme> filmes;
    private ArrayList<Sessao> sessoes;
    private ArrayList<Sala> salas;
    private ArrayList<Poltrona> poltronas;
    private ArrayList<Ingresso> ingressos;

    public Dao() {

        filmes = new ArrayList();
        sessoes = new ArrayList();
        salas = new ArrayList();

        this.filmes.add(new Filme(1, "Malévola - Dona do Mal"));
        System.out.println(filmes.get(filmes.size()-1).getTitulo());
        this.filmes.add(new Filme(2, "Os Parças"));
        System.out.println(filmes.get(filmes.size()-1).getTitulo());
        this.filmes.add(new Filme(3, "As Panteras"));
        System.out.println(filmes.get(filmes.size()-1).getTitulo());

        this.sessoes.add(new Sessao(1, "Manhã"));
        this.sessoes.add(new Sessao(2, "Tarde"));
        this.sessoes.add(new Sessao(3, "Noite"));

        this.salas.add(new Sala(1, "A1"));
        this.salas.add(new Sala(2, "B1"));
        this.salas.add(new Sala(3, "C1"));
    }

    public ArrayList<Filme> getFilmes() {

        return filmes;
    }

    public ArrayList<Sessao> getSessao() {

        return sessoes;
    }

}

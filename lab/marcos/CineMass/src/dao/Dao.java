/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Cinema;
import model.Filme;
import model.Entrada;
import model.Poltrona;
import model.Sala;
import model.Sessao;

/**
 *
 * @author vovostudio
 */
public class Dao {

    private ArrayList<Entrada> entradas;
    private int entrada_id = 1;

    public int getEntrada_id() {
        return entrada_id;
    }

    public void incrementaEntrada() {
        this.entrada_id++;
    }

    private ArrayList<Filme> filmes;
    private ArrayList<Sessao> sessoes;
    private ArrayList<Sala> salas;
    private ArrayList<Poltrona> poltronas;

    private int qnt_salas = 3;
    private int qtd_fileiras = 10;
    private int qtd_poltronas = 10;
    private int qtd_salas = 3;
    private int qtd_sessoes_por_sala = 3;

    private Cinema cinema = new Cinema(1, "CINEMass", salas);
    private String[] nomes_salas = {"A1", "B1", "C1"};
    private String[] periodos = {"Manhã", "Tarde", "Noite"};

    public Dao() {

        entradas = new ArrayList<>();

        filmes = new ArrayList();
        this.filmes.add(new Filme(1, "Malévola - Dona do Mal"));
        this.filmes.add(new Filme(2, "Os Parças"));
        this.filmes.add(new Filme(3, "As Panteras"));
        this.filmes.add(new Filme(4, "Malévola - Dona do Mal"));
        this.filmes.add(new Filme(5, "Os Parças"));
        this.filmes.add(new Filme(6, "As Panteras"));
        this.filmes.add(new Filme(7, "Malévola - Dona do Mal"));
        this.filmes.add(new Filme(8, "Os Parças"));
        this.filmes.add(new Filme(9, "As Panteras"));

        poltronas = new ArrayList<>();
        char letra = 'A';
        int id_poltronas = 1;
        for (int i = 0; i < qtd_fileiras; i++) {
            int num = 1;
            for (int j = 0; j < qtd_poltronas; j++) {
                poltronas.add(new Poltrona(id_poltronas++, letra, num));
                num++;
            }
            letra++;
        }

        salas = new ArrayList();
        sessoes = new ArrayList();
        this.sessoes.add(new Sessao(1, "Manhã", poltronas, filmes.get(0)));//1
        this.sessoes.add(new Sessao(2, "Tarde", poltronas, filmes.get(3)));//4
        this.sessoes.add(new Sessao(3, "Noite", poltronas, filmes.get(6)));//7
        this.salas.add(new Sala(1, "A1", sessoes));

        
        sessoes = new ArrayList();
        this.sessoes.add(new Sessao(1, "Manhã", poltronas, filmes.get(1)));//2
        this.sessoes.add(new Sessao(2, "Tarde", poltronas, filmes.get(4)));//5
        this.sessoes.add(new Sessao(3, "Noite", poltronas, filmes.get(7)));//8
        this.salas.add(new Sala(2, "B1", sessoes));

        
        sessoes = new ArrayList();
        this.sessoes.add(new Sessao(1, "Manhã", poltronas, filmes.get(2)));//3
        this.sessoes.add(new Sessao(2, "Tarde", poltronas, filmes.get(5)));//6
        this.sessoes.add(new Sessao(3, "Noite", poltronas, filmes.get(8)));//9
        this.salas.add(new Sala(3, "C1", sessoes));

        cinema.setSalas(salas);

    }

    public Cinema getCinema() {
        return cinema;
    }

    public void incluirEntrada(Entrada entrada) {
        this.entradas.add(entrada);
    }

    public ArrayList<Filme> getFilmes() {

        return filmes;
    }

    public ArrayList<Sessao> getSessao() {

        return sessoes;
    }

    public ArrayList<Sala> getSalas() {

        return salas;
    }

    public ArrayList<Poltrona> getPoltronas() {
        return poltronas;
    }

    public ArrayList<Entrada> getEntradas() {
        return entradas;
    }
}

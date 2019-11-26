/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Cinema;
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
    private int qnt_salas = 3;
    private int qtd_fileiras = 10;
    private int qtd_poltronas = 10;

    private Cinema cinema = new Cinema(1, "CineMass", salas);
    private String[] nomes_salas = {"A1", "B1", "C1"};
    private String[] periodos = {"Manhã", "Tarde", "Noite"};

    public Dao() {

        filmes = new ArrayList();
        sessoes = new ArrayList();
        salas = new ArrayList();
        poltronas = new ArrayList<>();

        this.filmes.add(new Filme(1, "Malévola - Dona do Mal"));
        this.filmes.add(new Filme(2, "Os Parças"));
        this.filmes.add(new Filme(3, "As Panteras"));

        this.sessoes.add(new Sessao(1, "Manhã", poltronas, filmes.get(0)));
        this.sessoes.add(new Sessao(2, "Tarde", poltronas, filmes.get(1)));
        this.sessoes.add(new Sessao(3, "Noite", poltronas, filmes.get(2)));

        this.salas.add(new Sala(1, "A1", sessoes));
        this.salas.add(new Sala(2, "B1", sessoes));
        this.salas.add(new Sala(3, "C1", sessoes));
        int qtd_salas = 3;
        int qtd_sessoes_por_sala = 3;

        char letra = 'A';
        int num = 1;
        for (int i = 0; i < qtd_fileiras; i++) {

            for (int j = 0; j < qtd_poltronas; j++) {
                poltronas.add(new Poltrona(i + 1, letra, num));

                num++;
            }
            letra++;
        }

        sessoes = new ArrayList();
        int cont = 0;
        int per = 0;
        for (int i = 0;
                i < qtd_salas;
                i++) {
            for (int j = 0; j < qtd_sessoes_por_sala; j++) {
                if (per == 3) {
                    per = 0;
                }
                sessoes.add(new Sessao(j + 1, periodos[per], poltronas, filmes.get(per)));
                cont++;
                per++;

            }
            salas.add(new Sala(i, "Sala " + nomes_salas[i], sessoes));
        }

        cinema.setSalas(salas);

    }

    public ArrayList<Filme> getFilmes() {

        return filmes;
    }

    public ArrayList<Sessao> getSessao() {

        return sessoes;
    }

    public ArrayList<Sala> getsala() {

        return salas;
    }

    public ArrayList<Poltrona> getPoltronas() {
        return poltronas;
    }
}

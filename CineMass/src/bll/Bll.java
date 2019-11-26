/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dao.Dao;
import java.util.ArrayList;
import model.Filme;
import model.Poltrona;
import model.Sessao;

/**
 *
 * @author vovostudio
 */
public class Bll {

    private Dao dados;

    public Bll() {
        this.dados = new Dao();
    }

    public Object[] getListaDeFilmes() {
        ArrayList<Integer> ids = new ArrayList();
        ArrayList<String> titulos = new ArrayList();

        for (Filme f : dados.getFilmes()) {
            ids.add(f.getId());
            titulos.add(f.getTitulo());
        }
        return new Object[]{ids, titulos};
    }

    public Object[] getPeriodos() {
        ArrayList<Integer> ids = new ArrayList();
        ArrayList<String> periodos = new ArrayList();

        for (Sessao s : dados.getSessao()) {
            ids.add(s.getId());
            periodos.add(s.getPeriodo());
        }
        return new Object[]{ids, periodos};
    }

    public Object[] getPoltrona() {
        ArrayList<Integer> ids = new ArrayList();
        ArrayList<Character> letras = new ArrayList();
        ArrayList<Integer> numero = new ArrayList();

        for (Poltrona p : dados.getPoltronas()) {
            ids.add(p.getId());
            letras.add(p.getFileira());
            numero.add(p.getNumero());

        }
        return new Object[]{ids, letras, numero};
    }

    public String imprimeTituloFilme(int id) {
        for (Filme f : dados.getFilmes()) {
            if (f.getId() == id) {
                return f.getTitulo();
            }
        }
        return null;
    }
}

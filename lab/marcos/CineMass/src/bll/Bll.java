/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dao.Dao;
import java.util.ArrayList;
import model.Cinema;
import model.Entrada;
import model.Filme;
import model.Poltrona;
import model.Sala;
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

    public void incluirEntrada(Entrada entrada) {
        this.dados.incluirEntrada(entrada);
    }

    public ArrayList<Entrada> getEntradas() {

        return this.dados.getEntradas();
    }

    public ArrayList<Sala> getSalas() {
        return this.dados.getSalas();
    }

    public ArrayList<Filme> getListaDeFilmes() {
        return this.dados.getFilmes();
    }

    public ArrayList<Sessao> getSessoes(int id_sessao) {
        ArrayList<Sessao> sessoes = new ArrayList();
        for (Sala sl : this.dados.getCinema().getSalas()) {
            for (Sessao ss : sl.getSessoes()) {
                sessoes.add(ss);
            }
        }
        return sessoes;
    }

    public String[] getPeriodos() {
        return this.dados.getPeriodos();
    }

    public int getIdPoltrona(int id_filme, int id_sessao, int id_sala, char fileira, int numero) {
        for (Sala sl : dados.getSalas()) {
            if (sl.getId() == id_sala) {
                for (Sessao ss : sl.getSessoes()) {
                    if (ss.getId() == id_sessao && ss.getFilme().getId() == id_filme) {
                        for (Poltrona p : ss.getPoltronas()) {
                            if (p.getFileira() == fileira && p.getNumero() == numero) {
                                return p.getId();
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public boolean poltronaLivre(int id_filme, int id_sessao, int id_sala, int id_poltrona) {
        for (Entrada e : dados.getEntradas()) {
            if (e.getFilme_id() == id_filme
                    && e.getSessao_id() == id_sessao
                    && e.getSala_id() == id_sala
                    && e.getPoltrona_id() == id_poltrona) {
                return false;
            }
        }
        return true;
    }

    public Object[] getPoltrona(Bll bll, int id_filme, int id_sessao) {
        this.dados = bll.dados;
        ArrayList<Integer> ids = new ArrayList();
        char letras[] = getLetras();
        ArrayList<Integer> numeros = new ArrayList();
        ArrayList<Integer> entradasIdPolrona = new ArrayList();
        ArrayList<Integer> entradasIdFilme = new ArrayList();
        ArrayList<Poltrona> ps = new ArrayList();
        Cinema c = dados.getCinema();

        for (Sala sl : c.getSalas()) {
            for (Sessao ss : sl.getSessoes()) {
                if (ss.getId() == id_sessao) {
                    ps = ss.getPoltronas();
                }
            }
        }
        for (Poltrona p : ps) {
            ids.add(p.getId());
            numeros.add(p.getNumero());
        }
        for (Entrada e : dados.getEntradas()) {
            entradasIdPolrona.add(e.getPoltrona_id());
            entradasIdFilme.add(e.getFilme_id());
        }
        return new Object[]{ids, letras, numeros, id_filme};
    }

    public String imprimeTituloFilme(int id_filme) {
        for (Filme f : dados.getFilmes()) {
            if (f.getId() == id_filme) {
                return f.getTitulo();
            }
        }
        return null;
    }

    public String imprimePeriodo(int id_sessao) {

//        for (Sessao ss : dados.ge) {
//            if (ss.getId() == id_sessao) {
//                return ss.getPeriodo();
//
//            }
//
//        }
        return null;
    }

    public boolean imprimeTipoIngresso(int id_entrada) {
        for (Entrada ent : dados.getEntradas()) {
            if (ent.getId() == id_entrada) {
                return ent.isMeia();
            }

        }
        return true;
    }

    public String imprimeFileiraNumero(Bll bll, int id_filme, int id_sessao, int id_poltrona) {
        this.dados = bll.dados;
        String str = "";
        int numero = 0;
        char fileira = '0';
        Cinema c = dados.getCinema();
        for (Sala sl : c.getSalas()) {
            for (Sessao ss : sl.getSessoes()) {
                for (Poltrona polt : ss.getPoltronas()) {
                    if (ss.getId() == id_sessao) {
                        if (polt.getId() == id_poltrona) {
                            fileira = polt.getFileira();
                            numero = polt.getNumero();
                        }
                    }
                }
            }
        }
        str += Character.toString(fileira) + Integer.toString(numero);
        return str;
    }

    public String imprimeNomeSala(int id_sala) {
        int vetorIds[] = new int[3];
        int i = 0;
        for (Sala sl : dados.getSalas()) {
            vetorIds[i] = sl.getId();
            if (vetorIds[i] == id_sala) {

                return sl.getNome();
            }
            i++;
        }
        int teste = 0;
        return null;
    }

    public int getSessaoId(int id_filme) {
//        int id_sessao = 0;
//        for (Sessao s : dados.getSessao()) {
//
//            if (s.getFilme().getId() == id_filme) {
//
//                id_sessao = s.getId();
//                return id_sessao;
//            }
//        }
        return 0;
    }

    public int getSalaId(int id_filme, int id_sessao) {
        for (Sala sl : dados.getSalas()) {
            for (Sessao ss : sl.getSessoes()) {
                if (ss.getId() == id_sessao
                        && ss.getFilme().getId() == id_filme) {
                    return sl.getId();
                }
            }
        }
        return 0;
    }

    public int getEntradaId() {
        return dados.getEntrada_id();
    }

    public char[] getLetras() {
        char letras[] = new char[10];
        char letra = 'A';
        for (int i = 0; i < letras.length; i++) {
            letras[i] = letra;
            letra++;
        }
        return letras;
    }
}

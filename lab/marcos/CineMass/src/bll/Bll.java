/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dao.Dao;
import java.util.ArrayList;
import java.util.List;
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

    public Object[] getListaDeFilmes(int id_sessao) {
        ArrayList<Integer> ids = new ArrayList();
        ArrayList<String> titulos = new ArrayList();

        for (Sessao s : getSessao(id_sessao)) {
            ids.add(s.getFilme().getId());
            titulos.add(s.getFilme().getTitulo());

        }

        return new Object[]{ids, titulos, id_sessao};
    }

    public ArrayList<Sessao> getSessao(int id_sessao) {
        ArrayList<Sala> salas = dados.getSalas();
        ArrayList<Sessao> ss = new ArrayList<>();
        for (int i = 0; i < salas.size(); i++) {
            List<Sessao> sessoes = salas.get(i).getSessoes();
            for (int j = 0; j < sessoes.size(); j++) {
                if (sessoes.get(j).getId() == id_sessao) {
                    ss.add(sessoes.get(j));

                }
            }
        }
        return ss;
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
        return new Object[]{ids, letras, numeros,id_filme};
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
        for (Sessao ss : dados.getSessao()) {
            if (ss.getId() == id_sessao) {
                return ss.getPeriodo();

            }

        }
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
        int id_sessao = 0;
        for (Sessao s : dados.getSessao()) {

            if (s.getFilme().getId() == id_filme) {

                id_sessao = s.getId();
                return id_sessao;
            }
        }
        return 0;
    }

    public int getPoltronaId(char fileira, int numero) {
        for (Poltrona p : dados.getPoltronas()) {
            if (p.getFileira() == fileira) {
                if (p.getNumero() == numero) {
                    return p.getId();
                }
            }
        }

        return 0;
    }

    public int getSalaId(int id_filme, int id_sessao) {
        int[] vetorIds = new int[dados.getFilmes().size()];

        Cinema c = dados.getCinema();
        int i = 0;
        for (Sala sl : c.getSalas()) {
            for (Sessao ss : sl.getSessoes()) {
                if (ss.getFilme().getId() == id_filme) {
                    return sl.getId();
                }
            }

        }

        int teste = 0;

        return 0;
    }

    public int getEntradaId() {

        return dados.getEntrada_id();
    }

    public ArrayList<Integer> getEntradaPoltronId(int id_filme) {
        ArrayList<Integer> ids_poltrona = new ArrayList<>();
        for (Entrada ent : dados.getEntradas()) {
            if (ent.getFilme_id() == id_filme) {
                ids_poltrona.add(ent.getPoltrona_id());

            }

        }
        return ids_poltrona;
    }

    public void incrementaEntrada() {
        dados.incrementaEntrada();

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

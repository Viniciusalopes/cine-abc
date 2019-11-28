/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import bll.Bll;
import java.util.ArrayList;
import model.Entrada;
import model.Filme;

/**
 *
 * @author marcos
 */
public class APP {

    String lblMenuRegistrarVenda;
    String lblMenuRelatorio;
    Bll bll;

    public APP(Bll bll) {
        this.bll = bll;
    }
    String lblMenuReimprimir;

    public void imprime(String texto) {
        System.out.printf(texto);
    }

    public void lblListaFilmes() {

        imprime("\nQual Filme deseja assistir?\n");
        for (Filme f : bll.getListaDeFilmes()) {
            imprime(String.format("\n  %d. %s", f.getId(), f.getTitulo()));
        }
        imprime("\n\n 0. Voltar\n\n> ");
    }

    public String getLblMenuRegistrarVenda() {
        lblMenuRegistrarVenda = "\nMenu Registrar venda de Ingresso\n";

        return lblMenuRegistrarVenda;
    }

    public String getLblMenuRelatorio() {
        System.out.printf(
                "Relatório\n");
        return lblMenuRelatorio;
    }

    public String getLblMenuReimprimir() {
        System.out.printf(
                "Reimprimir Ingresso\n");
        return lblMenuReimprimir;
    }

    public void lblPeriodo() {
        imprime("\nInforme a sessão.\n\n");
        String[] periodos = bll.getPeriodos();
        for (int i = 0; i < periodos.length; i++) {
            imprime(String.format(" %d. %s\n", i + 1, periodos[i]));
        }
        imprime("\n 0. Voltar\n\n> ");

    }

    public void lblEntrada() {
        System.out.printf(
                "\nTipo de Entrada \n\n"
                + " 1. Meia\n"
                + " 2. Inteira \n"
                + "\n"
                + " 0. Voltar\n\n> ");

    }

    public String letraNumero(Entrada entrada) {

        return bll.imprimeFileiraNumero(bll, entrada.getFilme_id(), entrada.getSessao_id(), entrada.getPoltrona_id());
    }

    public void lblSalaPoltronas(int id_filme, int id_sessao, int id_sala) {
        char[] letras = bll.getLetras();
        int id_poltrona;
        boolean livre;

        for (int i = 0; i < 10; i++) {
            imprime(String.format(" %s ", letras[i]));
            for (int j = 0; j < 10; j++) {
                id_poltrona = bll.getIdPoltrona(id_filme, id_sessao, id_sala, letras[i], j + 1);
                livre = bll.poltronaLivre(id_filme, id_sessao, id_sala, id_poltrona);
                if (livre) {
                    imprime(String.format(" %02d ", j + 1));
                } else {
                    imprime(" -- ");
                }
            }
            imprime(String.format("\n"));
        }
    }

    public void canhotoIngresso(Entrada entrada) {
        System.out.printf("\n-------------------------------------\n"
                + "   <<< CINEMass >>>\n"
                + "Sala: . . . . . . %s\n"
                + "Sessão: . . . . . %s\n"
                + "Poltrona: . . . . %s\n"
                + "Filme:. . . . . . %s\n"
                + "Tipo de Ingresso: %s\n"
                + "Preco:. . . . . . R$ %.2f\n"
                + "------------------------------------\n\n",
                bll.imprimeNomeSala(entrada.getSala_id()),
                bll.imprimePeriodo(entrada.getSessao_id()),
                letraNumero(entrada),
                bll.imprimeTituloFilme(entrada.getFilme_id()),
                (bll.imprimeTipoIngresso(entrada.getId())) ? "meia" : "inteiro",
                entrada.getPreco()
        );

    }
}

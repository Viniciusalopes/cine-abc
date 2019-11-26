/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;

/**
 *
 * @author marcos
 */
public class APP {

    static String lblMenuRegistrarVenda;
    static String lblMenuRelatorio;
    static String lblMenuReimprimir;

    public void imprime(String texto) {
        System.out.printf(texto);
    }

    public static void lblListaFilmes(Object[] dados) {
        ArrayList<Integer> ids = (ArrayList<Integer>) dados[0];
        ArrayList<String> titulos = (ArrayList<String>) dados[1];

        System.out.printf("\nQual Filme deseja assistir?\n\n");
        
        for (int i = 0; i < ids.size(); i++) {
            System.out.printf("%d\n", i);
            System.out.printf(" %d.%s\n", ids.get(i), titulos.get(i));
        }
        System.out.println(" 0.Sair\n> ");
    }

    public static String getLblMenuRegistrarVenda() {
        lblMenuRegistrarVenda = "\nMenu Registrar venda de Ingresso\n";

        return lblMenuRegistrarVenda;
    }

    public static String getLblMenuRelatorio() {
        System.out.printf(
                "Relatório\n");
        return lblMenuRelatorio;
    }

    public static String getLblMenuReimprimir() {
        System.out.printf(
                "Reimprimir Ingresso\n");
        return lblMenuReimprimir;
    }

    public static void lblPeriodo(Object[] dados) {
        ArrayList<Integer> ids = (ArrayList<Integer>) dados[0];
        ArrayList<String> titulos = (ArrayList<String>) dados[1];

        System.out.printf("\nInforme a sessão.\n\n");
        for (int i = 0; i < ids.size(); i++) {
            System.out.printf(" %d.%s\n", ids.get(i), titulos.get(i));
        }
        System.out.println(" 0.Voltar\n> ");

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import bll.Bll;
import java.util.ArrayList;
import model.Entrada;
import model.Sessao;

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
    
    public void lblListaFilmes(Object[] dados) {
        ArrayList<Integer> ids = (ArrayList<Integer>) dados[0];
        ArrayList<String> titulos = (ArrayList<String>) dados[1];
        int id_sessao = (int) dados[2];
        
        System.out.printf("\nQual Filme deseja assistir?\n\n");
        for (Sessao ss : bll.getSessao(id_sessao)) {
            if (ss.getId() == id_sessao) {
                
                System.out.printf("%d. %s\n", ss.getFilme().getId(), ss.getFilme().getTitulo());
            }
        }
        System.out.printf("\n");
        
        System.out.printf(
                " 0. Voltar\n\n> ");
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
    
    public void lblPeriodo(Object[] dados) {
        ArrayList<Integer> ids = (ArrayList<Integer>) dados[0];
        ArrayList<String> titulos = (ArrayList<String>) dados[1];
        System.out.printf("\nInforme a sessão.\n\n");
        for (int i = 0; i < 3; i++) {
            System.out.printf(" %d. %s\n", ids.get(i), titulos.get(i));
        }
        System.out.printf("\n 0. Voltar\n\n> ");
        
    }
    
    public void lblEntrada(Object[] dados) {
        System.out.printf(
                "\nTipo de Entrada \n\n"
                + " 1. Meia\n"
                + " 2. Inteira \n"
                + "\n"
                + " 0. Voltar\n\n> ");
        
    }
    
    private boolean estaOcupado(int id_filmeEntrada, int id_filme, int id_poltronaEntrada, int id_poltrona) {
        boolean ret = false;
        
        if (id_filme == id_filmeEntrada) {
            if (id_poltronaEntrada == id_poltrona) {
                ret = true;
            }
        }
        return ret;
    }
    
    public String letraNumero(Entrada entrada) {
        
        return bll.imprimeFileiraNumero(bll, entrada.getFilme_id(), entrada.getSessao_id(), entrada.getPoltrona_id());
    }
    
    public void lblSalaPoltronas(Object[] dados) {
        ArrayList<Integer> ids = (ArrayList<Integer>) dados[0];
        char[] letras = (char[]) dados[1];
        ArrayList<Integer> numeros = (ArrayList<Integer>) dados[2];
        ArrayList<Integer> entradasIdPolrona = (ArrayList<Integer>) dados[3];
        int id_filme = (int) dados[4];
        String pos;
        System.out.printf("\n");
        
        int cont = 0;
        for (int i = 0; i < 10; i++) {
            System.out.printf(" %s ", letras[i]);
            for (int j = 0; j < 10; j++) {
                System.out.printf(" %02d ", numeros.get(j));
            }
            System.out.printf("\n");
            
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

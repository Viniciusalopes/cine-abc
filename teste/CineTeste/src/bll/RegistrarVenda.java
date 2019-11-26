/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import app.APP;
import java.util.Scanner;
import util.ValidaInput;

/**
 *
 * @author marcos
 */
public class RegistrarVenda {

    private Bll bll = new Bll();
    private APP app = new APP();
    
//    Filme filme1 = new Filme(1);
//    Filme filme2 = new Filme(2);
//    Filme filme3 = new Filme(3);

    public int MenuRegistrarVenda() {

        System.out.printf("%s", app.getLblMenuRegistrarVenda());
        int id_filme = LoopFilme();
        int id_Sessao;
        if (id_filme == 0) {
            return 0;
        } else {
            switch (id_filme) {
                case 1:
                    System.out.println(bll.imprimeTituloFilme(id_filme));
                    break;
                default:
                    throw new AssertionError();
            }

            id_Sessao = LoopSessao(id_filme);
            
        }

        return 0;
    }

    public int LoopFilme() {
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        boolean sair = false;
        app.lblListaFilmes(bll.getListaDeFilmes());
        String str = null;
        do {
            str = input.next();

            sair = ValidaInput.int_no_intervalo(str, 0, 3);
            if (sair == false) {
                app.imprime("Opção Inválida!\n");

            } else {
                sair = true;
            }
        } while (!sair);

        opcao = Integer.parseInt(str);
        app.imprime("banana\n");
        return opcao;
    }

    public static int LoopSessao(int id_filme) {
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        boolean sair = false;
        
        String str = null;
        do {
            str = input.next();

            sair = ValidaInput.int_no_intervalo(str, 0, 3);
            if (sair = false) {

                System.out.printf("Opção Inválida!\n");

            } else {
                sair = true;
            }
        } while (!sair);

        opcao = Integer.parseInt(str);
        System.out.printf("mandioca\n");
        return opcao;
    }

    public static int loopSala(int id_filme) {
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        boolean sair = false;
       
        String str = null;
        do {
            str = input.next();

            sair = ValidaInput.int_no_intervalo(str, 0, 3);
            if (sair = false) {

                System.out.printf("Opção Inválida!\n");

            } else {
                sair = true;
            }
        } while (!sair);

        opcao = Integer.parseInt(str);
        System.out.printf("mandioca\n");
        return opcao;
    }
}

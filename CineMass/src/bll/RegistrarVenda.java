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

    public int MenuRegistrarVenda() {

        System.out.printf("%s", app.getLblMenuRegistrarVenda());
        int id_filme;
        int id_Sessao;
        id_filme = LoopFilme();
        int id_poltrona;
        if (id_filme == 0) {
            return 0;
        } else {

            id_Sessao = LoopSessao(id_filme);
            if (id_Sessao == 0) {
                return 0;
            } else {
                id_poltrona = loopSala(id_Sessao);
            }
        }

        return 0;
    }

    public int LoopFilme() {
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        boolean sair = false;
        boolean valida = false;
        app.lblListaFilmes(bll.getListaDeFilmes());
        String str = null;
        int cont = 0;
        do {
            do {
                System.out.printf("%d\n", cont);
                str = input.next();

                if (ValidaInput.int_no_intervalo(str, 0, 3) == false) {
                    System.out.printf("Opção inválida!\n");
                } else {
                    if (Integer.parseInt(str) == 0) {
                        valida = true;
                        cont++;
                        return 0;
                    } else {
                        valida = true;
                        opcao = Integer.parseInt(str);
                        cont++;
                        return opcao;
                    }

                }
            } while (!valida);

            sair = true;
        } while (!sair);

        return opcao;
    }

    public int LoopSessao(int id_filme) {
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        boolean sair = false;
        boolean valida = false;
        app.lblPeriodo(bll.getPeriodos());
        String str = null;
        int cont = 0;
        do {
            do {
                System.out.printf("%d\n", cont);
                str = input.next();

                if (ValidaInput.int_no_intervalo(str, 0, 3) == false) {
                    System.out.printf("Opção inválida!\n");
                } else {
                    if (Integer.parseInt(str) == 0) {
                        valida = true;
                        cont++;
                        return 0;
                    } else {
                        valida = true;
                        opcao = Integer.parseInt(str);
                        cont++;
                        return opcao;
                    }

                }
            } while (!valida);

            sair = true;
        } while (!sair);

        return opcao;
    }

    public int loopSala(int id_filme) {
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        boolean sair = false;
        boolean valida = false;
        app.lblSalaPoltronas(bll.getPoltrona());
        String str = null;
        int cont = 0;
        do {
            do {
                System.out.printf("%d\n", cont);
                str = input.next();

                if (ValidaInput.int_no_intervalo(str, 0, 3) == false) {
                    System.out.printf("Opção inválida!\n");
                } else {
                    if (Integer.parseInt(str) == 0) {
                        valida = true;
                        cont++;
                        return 0;
                    } else {
                        valida = true;
                        opcao = Integer.parseInt(str);
                        cont++;
                        return opcao;
                    }

                }
            } while (!valida);

            sair = true;
        } while (!sair);

        return opcao;
    }
}

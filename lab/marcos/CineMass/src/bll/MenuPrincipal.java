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
public class MenuPrincipal {

    private Bll bll;
    private APP app;

    public void menuPrincipal(Bll bll) {
        this.bll = bll;
        this.app = new APP(bll);
        Scanner input = new Scanner(System.in);
        String opcao;

        do {
            app.imprime("Menu Principal\n"
                    + "\n 1. Registrar venda de Ingresso "
                    + "\n 2. Relatório"
                    + "\n 3. Reimprimir Ingresso\n"
                    + "\n 0. Sair\n\n"
                    + "> ");

            if (!ValidaInput.int_no_intervalo(opcao = input.nextLine(), 0, 3)) {
                app.imprime("\nOpcao Inválida!\n\n");
                opcao = "-1";
            } else {
                switch (Integer.parseInt(opcao)) {
                    case 1:
                        opcao = Integer.toString(
                                new RegistrarVenda().MenuRegistrarVenda(bll, app));
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        break;
                }
            }

        } while (Integer.parseInt(opcao) < 0);
    }
}

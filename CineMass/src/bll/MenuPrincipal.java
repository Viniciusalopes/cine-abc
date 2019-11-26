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

    public void menuPrincipal() {
        bll = new Bll();
        app = new APP();
        Scanner input = new Scanner(System.in);
        String opcao;
        boolean sair;
        do {

            app.imprime("Menu Principal\n"
                    + "\n 1.Registrar venda de Ingresso "
                    + "\n 2.Relatório"
                    + "\n 3.Reimprimir Ingresso\n"
                    + "\n 0.Sair\n"
                    + "> ");
            do {

                sair = ValidaInput.int_no_intervalo(opcao = input.nextLine(), 0, 3);
                if (sair == false) {
                    app.imprime("Opcao Inválida!");

                }
            } while (!sair);

            switch (Integer.parseInt(opcao)) {
                case 0:
                    break;
                case 1:
                    new RegistrarVenda().MenuRegistrarVenda();
                    break;
                case 2:
                    break;
                case 3:

                    break;
                default:

            }

        } while (Integer.parseInt(opcao) != 0);

    }
}

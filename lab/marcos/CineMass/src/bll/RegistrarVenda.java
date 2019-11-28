/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import app.APP;
import java.util.Scanner;
import model.Entrada;
import util.ValidaInput;

/**
 *
 * @author marcos
 */
public class RegistrarVenda {

    private Bll bll;
    private APP app;

    public int MenuRegistrarVenda(Bll bll, APP app) {
        this.bll = bll;
        this.app = app;
        int id_filme = -1;
        int id_sessao = -1;
        int id_sala = -1;
        int id_entrada = -1;
        int id_poltrona = -1;
        int opcao = -1;
        boolean meiaEntrada;
        double preco;
        boolean concluido = false;
        do {

            app.imprime(String.format("%s", app.getLblMenuRegistrarVenda()));

            if (id_filme < 0) {
                id_filme = LoopFilme();
            } else {
                if (id_filme == 0) {
                    return -1;
                } else {
                    if (id_sessao < 0) {
                        id_sessao = LoopSessao();
                        if (id_sessao == 0) {
                            // Volta para a selecao de filme
                            id_filme = id_sessao = -1;
                        } else {
                            // Continua...
                            id_sala = bll.getSalaId(id_filme, id_sessao);
                            if (id_poltrona < 0) {
                                id_poltrona = LoopSala(id_filme, id_sessao, id_sala);

                                if (id_poltrona == 0) {
                                    // Volta para a seleção de sessão
                                    id_sessao = id_poltrona = -1;
                                } else {
                                    // Continua...
                                    if (opcao < 0) {
                                        opcao = LoopEntrada();
                                    }
                                    if (opcao == 0) {
                                        // Volta para a seleção da poltrona
                                        id_poltrona = opcao = -1;
                                    } else {
                                        // Processamento
                                        meiaEntrada = (opcao == 1) ? true : false;
                                        preco = (meiaEntrada) ? 12.5 : 25.0;
                                        // Hadúúúúúúúúúúúúúúúúúúúúken >>>>>>>>>>>>>>>>>>>>>                            
                                        // Inclui a entrada
                                        Entrada entrada = new Entrada(id_entrada, id_filme, id_sala, id_sessao, id_poltrona, meiaEntrada, preco);
                                        this.bll.incluirEntrada(entrada);
                                        concluido = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } while (!concluido);
        return -1;
    }

    public int LoopFilme() {
        Scanner input = new Scanner(System.in);
        String opcao;

        do {
            app.lblListaFilmes();
            if (!ValidaInput.int_no_intervalo(opcao = input.nextLine(), 0, 3)) {
                app.imprime("\nOpcao Inválida!\n\n");
                opcao = "-1";
            } else {
                return Integer.parseInt(opcao);
            }
        } while (Integer.parseInt(opcao) != 0);

        return 0;
    }

    public int LoopSessao() {
        Scanner input = new Scanner(System.in);
        String opcao;

        do {
            app.lblPeriodo();
            if (!ValidaInput.int_no_intervalo(opcao = input.nextLine(), 0, 3)) {
                app.imprime("\nOpcao Inválida!\n\n");
                opcao = "-1";
            } else {
                return Integer.parseInt(opcao);
            }

        } while (Integer.parseInt(opcao) != 0);

        return 0;
    }

    public int LoopSala(int id_filme, int id_sessao, int id_sala) {
        Scanner input = new Scanner(System.in);

        char letras[] = bll.getLetras();
        char opcoes[] = new char[letras.length + 1];
        opcoes[0] = '0';
        for (int i = 0; i < letras.length; i++) {
            opcoes[i + 1] = letras[i];
        }

        String opcao;
        char fileira;
        int numero;
        int id_poltrona;
        boolean valida;

        do {

            do {
                app.imprime("\n");
                app.lblSalaPoltronas(id_filme, id_sessao, id_sala);
                app.imprime("\n Digite a letra da fileira.");
                app.imprime("\n\n 0. Voltar\n\n> ");

                valida = ValidaInput.char_opcao_valida(opcao = input.nextLine(), opcoes, false);

                if (!valida) {
                    app.imprime("\nLetra inválida!\n");
                    app.imprime("Eitalala...  (-.-)\n");
                } else {
                    if (opcao.charAt(0) == '0') {
                        return 0;
                    }
                }
            } while (!valida);

            fileira = opcao.toUpperCase().charAt(0);

            do {
                app.imprime("\nDigite o número da Poltrona > ");
                valida = ValidaInput.int_no_intervalo(opcao = input.nextLine(), 1, 10);
                if (!valida) {
                    app.imprime("\nNúmero inválido!\n");
                    app.imprime("Ai, ai, ai... (0.o)\n");
                }
            } while (!valida);
            numero = Integer.parseInt(opcao);

            id_poltrona = bll.getIdPoltrona(id_filme, id_sessao, id_sala, fileira, numero);

            valida = bll.poltronaLivre(id_filme, id_sessao, id_sala, id_poltrona);

            if (!valida) {
                app.imprime("\n<<<Esta poltrona está ocupada>>> \n");
            }
        } while (!valida);

        return id_poltrona;
    }

    public int LoopEntrada() {
        Scanner input = new Scanner(System.in);
        String opcao;
        boolean valida = false;

        do {
            app.lblEntrada();
            valida = ValidaInput.int_no_intervalo(opcao = input.nextLine(), 0, 2);
            if (!valida) {
                app.imprime("\nOpção inválida!\n\n");
            }
        } while (!valida);

        return Integer.parseInt(opcao);
    }
}

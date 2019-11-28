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
        System.out.printf("%s", app.getLblMenuRegistrarVenda());
        int id_filme;
        int id_sessao = 0;
        int id_sala;
        int id_entrada = bll.getEntradaId();
        int id_poltrona;
        double preco = 12.5;
        boolean tipoEntrada;
        int validaNumeroEntrada;
        id_sessao = LoopSessao();
        
      for(Cinema c : bll.)
            
        }
        if (id_sessao == 0) {
            return 0;
        } else {
            id_filme = LoopFilme(id_sessao);
            if (id_filme == 0) {
                return 0;
            } else {
                switch (id_sessao) {
                    case 1:
                        break;
                    case 2:
                        switch (id_filme) {
                            case 1:
                                id_filme = 4;
                                break;
                            case 2:
                                id_filme = 5;
                                break;
                            case 3:
                                id_filme = 6;
                                break;
                            default:
                                throw new AssertionError();
                        }
                        break;
                    case 3:
                        switch (id_filme) {
                            case 1:
                                id_filme = 7;
                                break;
                            case 2:

                                id_filme = 8;
                                break;
                            case 3:
                                id_filme = 9;
                                break;
                            default:
                                throw new AssertionError();
                        }
                        break;
                    default:
                        throw new AssertionError();
                }
                id_poltrona = loopSala(id_filme, id_sessao);
                if (id_poltrona == 0) {
                    return 0;
                } else {

                    validaNumeroEntrada = loopEntrada();
                    if (validaNumeroEntrada == 0) {
                        return 0;
                    } else if (validaNumeroEntrada == 1) {
                        tipoEntrada = true;

                    } else {
                        tipoEntrada = false;
                        preco = preco * 2;
                    }

                    id_sala = bll.getSalaId(id_filme, id_sessao);

                    Entrada e = new Entrada(id_entrada, id_filme, id_sala, id_sessao, id_poltrona, tipoEntrada, preco);
                    bll.incrementaEntrada();
                    bll.incluirEntrada(e);
                    app.canhotoIngresso(e);
                }
            }
        }

        return 0;
    }

    public int LoopSessao() {
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        boolean sair = false;
        boolean valida = false;
        String str = null;
        int cont = 0;
        do {
            do {
                app.lblPeriodo(bll.getPeriodos());
                str = input.next();
                if (ValidaInput.int_no_intervalo(str, 0, 3) == false) {
                    System.out.print("\nOpção inválida!\n");
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

    public int LoopFilme(int id_sessao) {
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        boolean sair = false;
        boolean valida = false;
        String str = null;
        int cont = 0;
        do {
            do {
                app.lblListaFilmes(bll.getListaDeFilmes(id_sessao));
                str = input.next();

                if (ValidaInput.int_no_intervalo(str, 0, 3) == false) {
                    app.imprime("\nOpção inválida!\n");
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

    public int loopSala(int id_filme, int id_sessao) {
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        boolean sair = false;
        boolean valida;
        char fileira;
        int numero;
        int cont = 0;
        int id_poltrona = 0;
        char cr[] = new char[10];
        String str = null;

        char aux = 'A';
        for (int i = 0; i < 10; i++) {
            cr[i] = aux;
            aux++;
        }

        do {

            valida = false;
            do {
                app.lblSalaPoltronas(bll.getPoltrona( bll,id_filme, id_sessao));
                ValidaInput.char_opcao_valida(str = input.next(), cr, true);
                if (ValidaInput.char_opcao_valida(str, cr, valida) == false) {
                    str = "";
                    app.imprime("\nOpção inválida!\n");
                } else {
                    valida = true;
                }
            } while (!valida);
            valida = false;
            fileira = str.charAt(0);
            fileira = Character.toUpperCase(fileira);
            do {
                System.out.printf("\n");
                app.imprime("Digite o número da Poltrona.\n\n> ");
                input.nextLine();
                str = input.next();
                if (ValidaInput.int_no_intervalo(str, 1, 10) == false) {
                    app.imprime("Opção inválida!\n");
                } else {
                    if (Integer.parseInt(str) == 0) {
                        valida = true;
                        cont++;
                        return 0;
                    } else {
                        opcao = Integer.parseInt(str);
                        cont++;
                        numero = Integer.parseInt(str);
                        id_poltrona = bll.getPoltronaId(fileira, numero);
                        valida = true;
                    }
                }
            } while (!valida);

            if (bll.getEntradaPoltronId(id_filme).isEmpty()) {

                sair = true;
            } else {
                for (int i = 0; i < bll.getEntradaPoltronId(id_filme).size(); i++) {
                    if (id_poltrona == bll.getEntradaPoltronId(id_filme).get(i)) {
                        System.out.printf("%d - ", bll.getEntradaPoltronId(id_filme).get(i));
                        app.imprime("\n<<<Esta poltrona está ocupada>>> \n");
                        sair = false;
                    } else {
                        sair = true;
                    }
                }
            }
        } while (!sair);
        System.out.printf("banana,%b\n", sair);
        return id_poltrona;
    }

    public int loopEntrada() {
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        boolean sair = false;
        boolean valida = false;

        String str = null;
        int cont = 0;
        do {
            do {
                app.lblEntrada(bll.getPeriodos());
                str = input.next();
                if (ValidaInput.int_no_intervalo(str, 0, 2) == false) {
                    app.imprime("\nOpção inválida!\n\n");
                } else {
                    if (Integer.parseInt(str) == 0) {
                        valida = true;
                        cont++;
                        return 0;
                    } else {
                        valida = true;
                        opcao = Integer.parseInt(str);
                        cont++;
                        if (Integer.parseInt(str) == 1) {

                            return 1;
                        } else {
                            return 2;
                        }
                    }
                }
            } while (!valida);

            sair = true;
        } while (!sair);

        return 0;

    }
}

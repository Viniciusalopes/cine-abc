/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import util.ValidaInput;

/**
 *
 * @author marcos
 */
public class Principal {

    public static String filmes[] = {"Malévola: Dona do Mal", "Os Parças", "As Panteras"};
    public static String[] periodos = {"Manhã", "Tarde", "Noite"};
    public static int ingressoIdM = 21;
    public static int ingressoIdT = 21;
    public static int ingressoIdN = 21;

    public static String[][] poltronasM = new String[10][10];
    public static int[][] poltronasMI = new int[10][10];
    public static String[][] poltronasT = new String[10][10];
    public static int[][] poltronasTI = new int[10][10];
    public static String[][] poltronasN = new String[10][10];
    public static int[][] poltronasNI = new int[10][10];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        poltronasMI = preencheLugar(20, poltronasMI);
        poltronasTI = preencheLugar(20, poltronasTI);
        poltronasNI = preencheLugar(20, poltronasNI);
        cargaInicial(0, poltronasMI, poltronasM);
        cargaInicial(1, poltronasTI, poltronasT);
        cargaInicial(2, poltronasNI, poltronasN);
        boolean sair = false;
        boolean valida;
        String opcao = null;
        do {
            do {
                lblMenu();
                valida = util.ValidaInput.int_no_intervalo(opcao = input.nextLine(), 0, 4);
                if (valida == false) {
                    System.err.printf("\nOpção Inválida\n\n");
                }
            } while (!valida);
            switch (Integer.parseInt(opcao)) {
                case 0:
                    sair = true;
                    break;
                case 1:
                    registrarVenda();
                    break;
                case 2:
                    MenuReimprimirIngresso();
                    break;
                case 3:
                    menuRelatorio();
                    break;
                case 4:
                    visualizarPoltronas();
                    break;
                default:
                    throw new AssertionError();
            }
        } while (!sair);

    }

    public static void menuRelatorio() {
        Scanner input = new Scanner(System.in);
        boolean valida = false;
        double valorTotal = 0;
        do {

            System.out.printf("CINEMass: Relatório\n");

            System.out.printf("\nGráfico - CINEMass\n");
            System.out.printf("\nPorcentagem de ingressos vendidos por sessão");
            grafico(quantidadePorSessao(poltronasMI), filmes[0], quantidadePorSessao(poltronasTI), filmes[1], quantidadePorSessao(poltronasNI), filmes[2]);
            valorTotal = valorTotalMeia(poltronasMI, poltronasM) + valorTotalMeia(poltronasTI, poltronasT) + valorTotalMeia(poltronasNI, poltronasN);
            valorTotal += valorTotalInteira(poltronasMI, poltronasM) + valorTotalInteira(poltronasTI, poltronasT) + valorTotalInteira(poltronasNI, poltronasN);
            System.out.printf("\nQuantidade de ingressos vendidos por Sessão:\n\n");
            System.out.printf("%s : %s: . .%d\n", periodos[0], filmes[0], quantidadePorSessao(poltronasMI));
            System.out.printf("%s : %s: . . . . . . . .%d\n", periodos[1], filmes[1], quantidadePorSessao(poltronasTI));
            System.out.printf("%s : %s: . . . . . . .%d\n", periodos[2], filmes[2], quantidadePorSessao(poltronasNI));

            System.out.printf("\nQuantidade de ingressos que são entrada inteira,vendidos por sessão:\n\n");
            System.out.printf("%s : %s: . .%d\n", periodos[0], filmes[0], quantidadeInteiraPorSessao(poltronasMI, poltronasM));
            System.out.printf("%s : %s: . . . . . . . .%d\n", periodos[1], filmes[1], quantidadeInteiraPorSessao(poltronasTI, poltronasT));
            System.out.printf("%s : %s: . . . . . . .%d\n", periodos[2], filmes[2], quantidadeInteiraPorSessao(poltronasNI, poltronasN));
            System.out.printf("\nValor Total de ingressos que são entrada inteira,vendidos por sessão:\n\n");
            System.out.printf("%s : %s: . .R$ %.2f\n", periodos[0], filmes[0], valorTotalInteira(poltronasMI, poltronasM));
            System.out.printf("%s : %s: . . . . . . . .R$ %.2f\n", periodos[1], filmes[1], valorTotalInteira(poltronasTI, poltronasT));
            System.out.printf("%s : %s: . . . . . . .R$ %.2f\n", periodos[2], filmes[2], valorTotalInteira(poltronasNI, poltronasN));
            System.out.printf("\n%s: . . . . . . . . . . . . . .R$ %.2f\n", "Total", valorTotalInteira(poltronasMI, poltronasM) + valorTotalInteira(poltronasTI, poltronasT) + valorTotalInteira(poltronasNI, poltronasN));
            System.out.printf("\nQuantidade de ingressos que são meia entrada, vendidos por sessão:\n\n");
            System.out.printf("%s : %s: . .%d\n", periodos[0], filmes[0], quantidadeMeiaPorSessao(poltronasMI, poltronasM));
            System.out.printf("%s : %s: . . . . . . . .%d\n", periodos[1], filmes[1], quantidadeMeiaPorSessao(poltronasTI, poltronasT));
            System.out.printf("%s : %s: . . . . . . .%d\n", periodos[2], filmes[2], quantidadeMeiaPorSessao(poltronasNI, poltronasN));
            System.out.printf("\nValor Total de ingressos que são meia entrada,vendidos por sessão:\n\n");
            System.out.printf("%s : %s: . .R$ %.2f\n", periodos[0], filmes[0], valorTotalMeia(poltronasMI, poltronasM));
            System.out.printf("%s : %s: . . . . . . . .R$ %.2f\n", periodos[1], filmes[1], valorTotalMeia(poltronasTI, poltronasT));
            System.out.printf("%s : %s: . . . . . . .R$ %.2f\n", periodos[2], filmes[2], valorTotalMeia(poltronasNI, poltronasN));
            System.out.printf("\n%s: . . . . . . . . . . . . . .R$ %.2f\n", "Total", valorTotalMeia(poltronasMI, poltronasM) + valorTotalMeia(poltronasTI, poltronasT) + valorTotalMeia(poltronasNI, poltronasN));
            System.out.printf("\n%s: . . . . . . . . . . .R$ %.2f\n", "Total Geral", valorTotal);

            System.out.printf("\n0. voltar\n\n> ");

            String Str;
            valida = ValidaInput.int_valido(Str = input.nextLine());
            if (Integer.parseInt(Str) != 0) {
                valida = false;
            }
        } while (!valida);

    }

    public static int visualizarPoltronas() {
        Scanner input = new Scanner(System.in);
        char letra = 'A';
        char letras[] = new char[10];
        int poltronas[][] = new int[10][10];
        boolean valida = false;
        String str;
        String sessaoNomeFilme = null;
        int id_filme;
        for (int i = 0; i < 10; i++) {
            letras[i] = letra;
            letra++;
        }
        do {
            lblVisualizarPoltronas();

            do {
                valida = ValidaInput.int_no_intervalo(str = input.nextLine(), 0, 3);
            } while (!valida);
            id_filme = Integer.parseInt(str);
            switch (id_filme) {
                case 0:
                    System.out.printf("\n");
                    return 0;

                case 1:
                    poltronas = poltronasMI;
                    sessaoNomeFilme = periodos[0] + " - " + filmes[0];
                    break;
                case 2:
                    poltronas = poltronasTI;
                    sessaoNomeFilme = periodos[1] + " - " + filmes[1];
                    break;
                case 3:
                    poltronas = poltronasNI;
                    sessaoNomeFilme = periodos[2] + " - " + filmes[2];
                    break;
                default:
                    throw new AssertionError();
            }

            int cont = 1;
            System.out.printf("\n");
            System.out.printf("CINEMass\n\n%s\n", sessaoNomeFilme);
            System.out.printf("\n");
            for (int i = 0; i < 10; i++) {
                System.out.printf(" %s ", letras[i]);
                for (int j = 0; j < 10; j++) {
                    if (poltronas[i][j] == 1) {
                        System.out.printf(" --- ");
                    } else {
                        System.out.printf(" %03d ", cont);
                    }

                    cont++;
                }
                System.out.printf("\n");
            }
            System.out.printf("\n");
        } while (id_filme != 0);
        return 0;
    }

    public static void lblVisualizarPoltronas() {
        System.out.printf("\nCINEMass: Visualizar Poltronas\n\n");
        System.out.printf(" Qual filme?\n\n");
        for (int i = 0; i < filmes.length; i++) {
            if (i == 0) {
                System.out.printf(" %d. %s - %s " + "\n", i + 1, filmes[i], periodos[i]);
            } else if (i == 1) {
                System.out.printf(" %d. %s . . . . . . - %s " + "\n", i + 1, filmes[i], periodos[i]);
            } else if (i == 2) {
                System.out.printf(" %d. %s . . . . . - %s " + "\n", i + 1, filmes[i], periodos[i]);
            }
        }

        System.out.printf("\n 0. sair\n\n"
                + "> "
        );
    }

    public static int quantidadePorSessao(int[][] poltronas) {
        int cont = 0;
        for (int i = 0; i < poltronas.length; i++) {
            for (int j = 0; j < poltronas.length; j++) {
                if (poltronas[i][j] == 1) {
                    cont++;
                }
            }
        }
        return cont;
    }

    public static int quantidadeMeiaPorSessao(int[][] poltronas, String[][] ingressos) {
        int cont = 0;
        for (int i = 0; i < poltronas.length; i++) {
            for (int j = 0; j < poltronas.length; j++) {
                if (poltronas[i][j] == 1) {
                    if (getValorDouble(ingressos[i][j]) == 12.5) {
                        cont++;
                    }
                }
            }
        }
        return cont;
    }

    public static int quantidadeInteiraPorSessao(int[][] poltronas, String[][] ingressos) {
        int cont = 0;
        for (int i = 0; i < poltronas.length; i++) {
            for (int j = 0; j < poltronas.length; j++) {
                if (poltronas[i][j] == 1) {
                    if (getValorDouble(ingressos[i][j]) == 25) {
                        cont++;
                    }
                }
            }
        }
        return cont;
    }

    public static double valorTotalMeia(int[][] poltronas, String[][] ingressos) {
        int cont = 0;
        double valor = 0;
        for (int i = 0; i < poltronas.length; i++) {
            for (int j = 0; j < poltronas.length; j++) {
                if (poltronas[i][j] == 1) {
                    if (getValorDouble(ingressos[i][j]) == 12.5) {
                        valor += getValorDouble(ingressos[i][j]);
                    }
                }
            }
        }
        return valor;
    }

    public static double valorTotalInteira(int[][] poltronas, String[][] ingressos) {
        int cont = 0;
        double valor = 0;
        for (int i = 0; i < poltronas.length; i++) {
            for (int j = 0; j < poltronas.length; j++) {
                if (poltronas[i][j] == 1) {
                    if (getValorDouble(ingressos[i][j]) == 25) {
                        valor += getValorDouble(ingressos[i][j]);
                    }
                }
            }
        }
        return valor;
    }

    public static int MenuTodosIngressos() {
        Scanner input = new Scanner(System.in);
        boolean valida = false;
        String str;
        lblReimprimiringresso();
        do {
            valida = ValidaInput.int_no_intervalo(str = input.nextLine(), 0, 3);
        } while (!valida);

        switch (Integer.parseInt(str)) {
            case 0:
                return 0;

            case 1:
                imprimirTodosIngressos(poltronasMI, poltronasM);
                break;
            case 2:
                imprimirTodosIngressos(poltronasTI, poltronasT);
                break;
            case 3:
                imprimirTodosIngressos(poltronasNI, poltronasN);

                break;
            default:
                throw new AssertionError();
        }
        return 0;
    }

    public static int MenuReimprimirIngresso() {
        Scanner input = new Scanner(System.in);
        String str;
        boolean valida = false;
        do {

            lblMenuReimprimir();
            do {
                valida = ValidaInput.int_no_intervalo(str = input.nextLine(), 0, 2);
                if (valida == false) {
                    System.err.printf("Opção inválida!!\n");
                    lblMenuReimprimir();

                }
            } while (!valida);
            switch (Integer.parseInt(str)) {
                case 0:
                    break;
                case 1:
                    MenuTodosIngressos();
                    break;
                case 2:
                    ImprimirIngressoEspecifico();
                    break;
                default:
                    throw new AssertionError();
            }
        } while (Integer.parseInt(str) != 0);
        return 0;
    }

    public static void imprimirTodosIngressos(int[][] poltronas, String[][] poltronaS) {
        ArrayList<String> ingressos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (poltronas[i][j] == 1) {
                    System.out.printf("%s\n\n", poltronaS[i][j]);
                }
            }
        }

    }

    public static int ImprimirIngressoEspecifico() {
        Scanner input = new Scanner(System.in);
        String str;
        boolean valida = false;
        String[][] matrizAux = new String[10][10];
        int[] opcoes = {0, 1, 2, 3};
        do {

            lblReimprimiringresso();
            valida = ValidaInput.int_opcao_valida(str = input.nextLine(), opcoes);
            if (valida == false) {

                System.err.printf("Opção inválida\n");
            } else {
                if (Integer.parseInt(str) == 0) {
                    return 0;
                }
            }
        } while (!valida);
        int id_filme = Integer.parseInt(str);
        valida = false;
        do {
            System.out.printf("Qual o nome do cliente?\n\n> ");
            valida = ValidaInput.string_valida(str = input.nextLine(), 2, 100);
            if (valida == false) {

                System.err.printf("Opção inválida\n");
            }
        } while (!valida);
        String nome = str;
        switch (id_filme) {
            case 1:
                matrizAux = poltronasM;
                break;
            case 2:
                matrizAux = poltronasT;
                break;
            case 3:
                matrizAux = poltronasN;
                break;
            default:
                throw new AssertionError();
        }
        ArrayList<String> nomes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {
                if (matrizAux[i][j].contains(nome)) {

                    nomes.add(matrizAux[i][j]);

                }
            }

        }
        if (nomes.size() == 0) {
            System.err.printf("\nIngresso não encontrado!\n");
        } else {
            for (int j = 0; j < nomes.size(); j++) {
                imprimeLinhas(nomes.get(j));
            }
        }
        return 0;
    }

    public static int registrarVenda() {

        int id_poltrona;
        int tipoDoIngresso;
        int id_filme;
        String nome;
        int[] ingresso = new int[3];
        do {

            nome = loopNome();
            if (nome == null) {
                return 0;
            } else {
                do {
                    id_filme = LoopFilme();
                    if (id_filme == 0) {

                        return 0;
                    } else {
                        ingresso[0] = id_filme;
                        do {
                            id_poltrona = loopSala(id_filme);

                            if (id_poltrona != 0) {
                                ingresso[1] = id_poltrona;
                                do {
                                    tipoDoIngresso = loopIngresso();
                                    if (tipoDoIngresso != 0) {
                                        ingresso[2] = tipoDoIngresso;
                                        salvarBilhete(nome, ingresso);

                                        imprimirIngresso(id_filme, id_poltrona);
                                        return 0;
                                    }

                                } while (tipoDoIngresso != 0);
                            }

                        } while (id_poltrona != 0);
                    }
                } while (id_filme != 0);
            }
        } while (Integer.parseInt(nome) != 0);

        return 0;
    }

    public static void salvarBilhete(String nome, int[] ingresso) {
        char letra = 'A';
        char letras[] = new char[10];
        for (int i = 0; i < 10; i++) {
            letras[i] = letra;
            letra++;
        }
        boolean meia = true;
        if (ingresso[2] == 2) {
            meia = false;
        }
        int cont;
        switch (ingresso[0]) {
            case 1:
                cont = 1;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (ingresso[1] == cont) {
                            poltronasMI[i][j] = 1;
                            poltronasM[i][j]
                                    = "Ingresso: " + ingressoIdM
                                    + "\nNome do cliente: " + nome
                                    + "\nSessão: " + periodos[ingresso[0] - 1]
                                    + "\nFilme: " + filmes[ingresso[0] - 1]
                                    + "\nPoltrona: " + letras[i] + cont
                                    + "\nTipo de Ingresso: " + ((meia) ? "Meia\nPreço: R$ 12,50" : "Inteira\nPreço: R$ 25,00");
                        }
                        cont++;
                    }

                }
                ingressoIdM++;

                break;
            case 2:
                cont = 1;

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (ingresso[1] == cont) {
                            poltronasTI[i][j] = 1;
                            poltronasT[i][j]
                                    = "Ingresso: " + ingressoIdM
                                    + "\nNome do cliente: " + nome
                                    + "\nSessão: " + periodos[ingresso[0] - 1]
                                    + "\nFilme: " + filmes[ingresso[0] - 1]
                                    + "\nPoltrona: " + letras[i] + cont
                                    + "\nTipo de Ingresso: " + ((meia) ? "Meia\nPreço: R$ 12,50" : "Inteira\nPreço: R$ 25,00");
                        }
                        cont++;
                    }

                }
                ingressoIdT++;

                break;

            case 3:
                cont = 1;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (ingresso[1] == cont) {
                            poltronasNI[i][j] = 1;
                            poltronasN[i][j]
                                    = "Ingresso: " + ingressoIdN
                                    + "\nNome do cliente: " + nome
                                    + "\nSessão: " + periodos[ingresso[0] - 1]
                                    + "\nFilme: " + filmes[ingresso[0] - 1]
                                    + "\nPoltrona: " + letras[i] + cont
                                    + "\nTipo de Ingresso: " + ((meia) ? "Meia\nPreço: R$ 12,50" : "Inteira\nPreço: R$ 25,00");
                        }
                        cont++;
                    }

                }
                ingressoIdN++;
                break;
            default:
                throw new AssertionError();
        }

    }

    public static void imprimirIngresso(int id_filme, int id_poltrona) {
        int cont = 1;
        String poltronas[][] = new String[10][10];
        switch (id_filme) {
            case 1:
                poltronas = poltronasM;
                break;
            case 2:
                poltronas = poltronasT;
                break;
            case 3:
                poltronas = poltronasN;
                break;
            default:
                break;

        }

        boolean continua = true;
        for (int i = 0; i < 10; i++) {
            if (continua) {
                for (int j = 0; j < 10; j++) {
                    if (cont == id_poltrona) {
                        String str = poltronas[i][j];
                        System.out.printf("\n");
                        imprimeLinhas(str);
                        System.out.printf("\n");
                        continua = false;
                        break;
                    }
                    cont++;
                }
            }
        }
    }

    private static void imprimeLinhas(String str) {

        String[] linhas = str.split("\n");
        String str1 = "";
        System.out.printf("-----------------------------\n");
        for (int i = 0; i < linhas.length; i++) {
            System.out.printf("%s\n", linhas[i]);
        }

        System.out.printf("-----------------------------\n");
    }

    public static double getValorDouble(String ingresso) {
        return Double.parseDouble(String.format("%s\n", ingresso.split("\n")[6].replace("Preço: R$ ", "").replace(",", ".")));
    }

    public static String loopNome() {
        Scanner input = new Scanner(System.in);
        String str;
        boolean valida = false;
        do {
            lblLoopNome();
            valida = ValidaInput.string_valida(str = input.nextLine(), 1, 100);
            if (valida == false) {
                System.err.printf("\nNome inválido!!\n\n\n");
            } else {
            }
        } while (!valida);
        try {
            Integer.parseInt(str);
            if (Integer.parseInt(str) == 0) {
                return null;
            }
        } catch (Exception e) {
        }
        return str;

    }

    public static void lblLoopNome() {
        System.out.printf(
                "\nCINEMass: Registrar venda de ingresso:\n\n"
                + " Digite o nome do cliente:\n\n 0. sair\n\n"
                + "> ");

    }

    public static int LoopFilme() {

        Scanner input = new Scanner(System.in);
        int opcoes[] = {0, 1, 2, 3};
        String str;
        boolean valida = false;
        do {
            lblLoopFIlmePeriodo(filmes, periodos);

            valida = util.ValidaInput.int_opcao_valida(str = input.nextLine(), opcoes);
            if (valida == false) {
                System.err.printf("\nopcão inválida!!\n");

            }

        } while (!valida);

        return Integer.parseInt(str);
    }

    public static int loopSala(int id_filme) {
        Scanner input = new Scanner(System.in);
        int opcoes[] = {0, 2, 3, 4};
        String str;
        boolean valida = false;
        boolean sair = false;
        char letra = 'A';
        char letras[] = new char[11];
        int id_poltrona = 0;
        for (int i = 0; i < 10; i++) {
            letras[i] = letra;
            letra++;
        }
        letras[10] = '0';
        int poltronas[][] = new int[10][10];
        switch (id_filme) {
            case 1:
                poltronas = poltronasMI;
                break;
            case 2:
                poltronas = poltronasTI;
                break;
            case 3:
                poltronas = poltronasNI;
                break;
            default:
                throw new AssertionError();
        }
        do {

            do {
                lblLoopSala(id_filme);
                valida = ValidaInput.char_opcao_valida(str = input.next(), letras, false);
                if (valida == false) {
                    System.err.printf("\nopcão inválida!!\n\n");

                }

            } while (!valida);
            String fileira = str.toUpperCase();
            valida = false;
            input.nextLine();
            do {
                System.out.printf("\nDigite o número da poltrona:\n\n 0. voltar\n\n> ");
                switch (fileira) {
                    case "A":
                        valida = ValidaInput.int_no_intervalo(str = input.nextLine(), 0, 10);
                        break;
                    case "B":
                        valida = ValidaInput.int_no_intervalo(str = input.nextLine(), 11, 20);
                        break;
                    case "C":
                        valida = ValidaInput.int_no_intervalo(str = input.nextLine(), 21, 30);
                        break;
                    case "D":
                        valida = ValidaInput.int_no_intervalo(str = input.nextLine(), 31, 40);
                        break;
                    case "E":
                        valida = ValidaInput.int_no_intervalo(str = input.nextLine(), 41, 50);
                        break;
                    case "F":
                        valida = ValidaInput.int_no_intervalo(str = input.nextLine(), 51, 60);
                        break;
                    case "G":
                        valida = ValidaInput.int_no_intervalo(str = input.nextLine(), 61, 70);
                        break;
                    case "H":
                        valida = ValidaInput.int_no_intervalo(str = input.nextLine(), 71, 80);
                        break;
                    case "I":
                        valida = ValidaInput.int_no_intervalo(str = input.nextLine(), 81, 90);
                        break;
                    case "J":
                        valida = ValidaInput.int_no_intervalo(str = input.nextLine(), 91, 100);
                        break;
                    case "0":
                        return 0;

                    default:
                        throw new AssertionError();
                }

                if (valida == false) {
                    System.err.printf("\nopcão inválida!!\n");
                } else {
                    id_poltrona = Integer.parseInt(str);
                    int aux = 1;
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            if (aux == id_poltrona) {
                                if (poltronas[i][j] == 1) {
                                    System.err.printf("\nEsta poltrona está ocupada!!\n");
                                } else {

                                    sair = true;
                                }
                            }
                            aux++;

                        }

                    }

                }
            } while (!valida);

        } while (!sair);

        return id_poltrona = Integer.parseInt(str);

    }

    public static int loopIngresso() {
        Scanner input = new Scanner(System.in);
        int opcoes[] = {0, 1, 2};
        String str;
        boolean opcao = false;
        do {
            lblLoopIngresso();
            opcao = util.ValidaInput.int_opcao_valida(str = input.nextLine(), opcoes);
        } while (!opcao);
        switch (Integer.parseInt(str)) {
            case 0:
                return 0;
            case 1:
                break;
            case 2:
                break;

            default:
                throw new AssertionError();
        }

        return Integer.parseInt(str);
    }

    public static void lblMenu() {
        System.out.printf(
                "CINEMass\n\n"
                + " 1. Registrar venda de ingresso\n"
                + " 2. Reimprimir ingresso\n"
                + " 3. Relatório\n"
                + " 4. Visualizar poltronas\n"
                + "\n"
                + " 0. sair\n\n"
                + "> "
        );
    }

    public static void lblReimprimiringresso() {
        System.out.printf(
                "\nCINEMass: Reimprimir Ingresso:\n\n"
                + "Qual filme:\n\n");

        for (int i = 0; i < filmes.length; i++) {
            System.out.printf(
                    " %d. %s"
                    + "        \n", i + 1, filmes[i]);
        }

        System.out.printf("\n0.voltar\n\n"
                + "> "
        );

    }

    public static void lblLoopSala(int id_filme) {
        char letra = 'A';
        char letras[] = new char[10];
        int poltronas[][] = new int[10][10];
        switch (id_filme) {
            case 1:
                poltronas = poltronasMI;
                break;
            case 2:
                poltronas = poltronasTI;
                break;
            case 3:
                poltronas = poltronasNI;
                break;
            default:
                throw new AssertionError();
        }
        for (int i = 0; i < 10; i++) {
            letras[i] = letra;
            letra++;
        }
        System.out.printf("\nCINEMass: Registrar venda de ingresso:\n\nDigite uma letra para escolher uma poltrona:\n\n");
        int cont = 1;
        for (int i = 0; i < 10; i++) {
            System.out.printf(" %s ", letras[i]);
            for (int j = 0; j < 10; j++) {
                if (poltronas[i][j] == 1) {
                    System.out.printf(" --- ");
                } else {
                    System.out.printf(" %03d ", cont);
                }

                cont++;
            }
            System.out.printf("\n");
        }
        System.out.printf("\n 0. voltar\n\n>");

    }

    public static void lblLoopIngresso() {
        System.out.printf("\n\nCINEMass: Registrar venda de ingresso:\n\nTipo de Ingresso\n\n");
        System.out.printf(""
                + " 1. Meia\n"
                + " 2. Inteira\n\n"
                + " 0. voltar\n\n>");

    }

    public static void lblLoopFIlmePeriodo(String[] filmes, String[] Periodos) {
        System.out.printf(
                "\nCINEMass: Registrar venda de ingresso:\n\nQual Filme?\n\n");

        for (int i = 0; i < filmes.length; i++) {
            if (i == 0) {
                System.out.printf(" %d. %s - %s " + "\n", i + 1, filmes[i], Periodos[i]);
            } else if (i == 1) {
                System.out.printf(" %d. %s . . . . . . - %s " + "\n", i + 1, filmes[i], Periodos[i]);
            } else if (i == 2) {
                System.out.printf(" %d. %s . . . . . - %s " + "\n", i + 1, filmes[i], Periodos[i]);
            }
        }

        System.out.printf("\n 0. sair\n\n"
                + "> "
        );

    }

    public static void lblMenuReimprimir() {
        System.out.printf("\nCINEMass: Reimprimir Ingresso:\n\n");
        System.out.printf(" 1.Imprimir todos os ingressos\n");
        System.out.printf(" 2.Imprimir ingresso por nome\n");
        System.out.printf("\n");
        System.out.printf(" 0. sair\n\n> ");
    }

    public static void cargaInicial(int id_filme, int[][] poltronas, String[][] poltronaS) {
        int[] posicoes = vetorPosicoes();
        int ingressoId = 1;
        char letra = 'A';
        char letras[] = new char[10];
        for (int i = 0; i < letras.length; i++) {
            letras[i] = letra;
            letra++;
        }
        int id_poltrona = 0;
        int cont = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                boolean meia = true;
                int tipo = sorteia(1, 2);
                if (tipo == 2) {
                    meia = false;
                }
                if (poltronas[i][j] == 1) {
                    poltronaS[i][j]
                            = "Ingresso: " + ingressoId
                            + "\nNome do cliente: " + getNomeQualquer(id_filme)
                            + "\nSessão: " + periodos[id_filme]
                            + "\nFilme: " + filmes[id_filme]
                            + "\nPoltrona: " + letras[i] + cont
                            + "\nTipo de Ingresso: " + ((meia) ? "Meia\nPreço: R$ 12,50" : "Inteira\nPreço: R$ 25,00");
                    ingressoId++;
                } else {
                    poltronaS[i][j] = "";

                }
                cont++;
            }

        }

    }

    public static String getNomeQualquer(int id_filme) {
        String nomes1[] = {"Abílio Bahia",
            "Alberta Caldeira",
            "Alceste Modesto",
            "Angélica Caminha",
            "Capitolina Alcántara",
            "Casimiro Soares",
            "Conceição Queiroga",
            "Dália Dutra",
            "Fábio Cabrera",
            "Isabel Valério",
            "Jordão Gomes",
            "Lúcia Braga",
            "'Minervina Bragança",
            "Potira Ramallo",
            "Querubim Quintal",
            "Sérgio Castanheira",
            "Taíssa Caminha",
            "Teodorico Parahyba",
            "Timóteo Paiacã",
            "Uriel Velásquez",};
        String nomes2[] = {"Amadeu Carvalho",
            "Amílcar Jaguaribe",
            "Apuã Cairu",
            "Araribóia Varejão",
            "Cleiton Viégas",
            "Diógenes Batista",
            "Faustino Ávila",
            "Ferdinando Marins",
            "Firmina Travassos",
            "Gláuber Quirino",
            "Helena Cavadas",
            "Lina Salgueiro",
            "Luciano Serralheiro",
            "Marina Aires",
            "Matilde Camello",
            "Quirino Gomes",
            "Romão Furquim",
            "Sidónio Vilas-Boas",
            "Viviana Belchiorinho",
            "Álvaro Leça",};
        String[] nomes3 = {"Celina Curado",
            "Dinis Montenegro",
            "Dino Silvestre",
            "Elisa Vásquez",
            "Enia Gama",
            "Frederica Tavares",
            "Gerson Abelho",
            "Hélder Alencar",
            "Jacinto Salguero",
            "Lorena Barrocas",
            "Luciano Collaço",
            "Marcela Assunção",
            "Marta Candeias",
            "Querubina Louzada",
            "Santiago Rabello",
            "Teodora Jaguariúna",
            "Vanda Fuentes",
            "Vanessa Villela",
            "Vânia Noite",
            "Xavier Magallanes",};
        int pos = sorteia(0, 19);
        switch (id_filme) {
            case 0:
                return nomes1[pos];

            case 1:
                return nomes2[pos];

            case 2:
                break;
            default:
                throw new AssertionError();
        }
        return nomes3[pos];
    }

    public static void carga(int[][] poltronas) {
        int[] vetor = vetorPosicoes();
        int[] vetor2 = vetorPosicoes();
        int cont = 1;
        int k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                poltronas[i][j] = 0;
            }
            cont++;

        }
        for (int i = 0, j = 9; i < vetor.length && j >= 0; i++, j--) {
            poltronas[vetor[i]][vetor[j]] = 1;

        }

    }

    public static int[] vetorPosicoes() {

        int[] nums = new int[20];
        int numero;
        for (int i = 0; i < nums.length; i++) {
            numero = sorteia(0, 9);
            if (i == 0) {
                nums[i] = numero;
            } else {
                for (int j = 0; j < i; j++) {
                    do {
                        numero = sorteia(0, 9);
                        if (nums[j] != numero) {
                            nums[i] = numero;
                        }
                    } while (nums[j] == numero);
                }

            }

        }

        return nums;
    }

    public static int[][] preencheLugar(int quantidade, int[][] matriz) {
        int vetor[] = new int[quantidade];
        boolean jaExisteNoVetor;
        int[][] ret = new int[matriz.length][matriz[0].length];

        int lin, col;
        for (int i = 0; i < quantidade; i++) {
            do {
                jaExisteNoVetor = false;
                vetor[i] = sorteia(0, 99);
                for (int j = 0; j < i; j++) {
                    if (vetor[j] == vetor[i]) {
                        jaExisteNoVetor = true;
                    }
                }
            } while (jaExisteNoVetor);

            lin = vetor[i] / 10;
            col = vetor[i] % 10;
            ret[lin][col] = 1;
        }

        return ret;
    }

    public static void mensagemDestacada(String mensagem) {
        //       borda_dupla = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] borda_dupla = {"╔", "╗", "╚", "╝", "╠", "╣", "╬", "╦", "╩", "═", "║"};

        // Retira os espaços no início e no fim da mensagem
        String texto = mensagem.trim();
        while (texto.contains("  ")) {
            texto = texto.replace("  ", " ");
        }

        // Obtém o tamanho do texto
        int tamanho_do_texto = texto.length();

        System.out.println();

        // Borda Superior
        System.out.print(borda_dupla[0]);
        for (int i = 0; i < tamanho_do_texto + 2; i++) {
            System.out.print(borda_dupla[9]);
        }
        System.out.print(borda_dupla[1]);
        System.out.println();

        // Linha do texto
        System.out.print(borda_dupla[10]);
        System.out.print(" " + texto + " ");
        System.out.print(borda_dupla[10]);
        System.out.println();

        // Borda Inferior
        System.out.print(borda_dupla[2]);
        for (int i = 0; i < tamanho_do_texto + 2; i++) {
            System.out.print(borda_dupla[9]);
        }
        System.out.print(borda_dupla[3]);
        System.out.println();
    }

    public static void grafico(int v3, String label3, int v2, String label2, int v1, String label1) {

        int aux;

        String[] vetor = organizador(v3, label3, v2, label2, v1, label1);
        int vl3 = Integer.parseInt(vetor[0]);
        int vl2 = Integer.parseInt(vetor[2]);
        int vl1 = Integer.parseInt(vetor[4]);

        double l3 = vl3;
        double l2 = vl2;
        double l1 = vl1;
        l3 = l3 - (l3 * 0.90);
        l2 = l2 - (l2 * 0.90);
        l1 = l1 - (l1 * 0.90);
        int ref = 20;
        System.out.printf("\n");
        System.out.printf("╔");
        for (int i = 0; i < ref; i++) {

            System.out.printf("═");
        }
        System.out.printf("╗\n");

        System.out.printf("║");
        for (int i = 0; i < ref; i++) {

            System.out.printf(" ");
        }
        System.out.printf("║\n");

        System.out.printf("║");
        int idc3 = 3;
        int idc2 = 3;
        int idc1 = 3;
        if (vl3 == 100) {
            idc3 = 4;
        };
        if (vl2 == 100) {
            idc2 = 4;
        };
        if (vl1 == 100) {
            idc1 = 4;
        }
        for (int i = 0; i < (int) (vl3 / 10); i++) {
            System.out.printf("▓");
        }
        System.out.printf("%d%%", vl3);

        for (int j = 0; j < ref - (int) (vl3 / 10) - idc3; j++) {
            System.out.printf("-");

        }
        if (vl3 < 10) {
            System.out.printf(" ");
        }
        System.out.printf("║ - %s\n", vetor[1]);
        System.out.printf("║");
        for (int i = 0; i < ref; i++) {

            System.out.printf(" ");
        }
        System.out.printf("║\n");

        System.out.printf("║");
        for (int i = 0; i < vl2 / 10; i++) {
            System.out.printf("▒");
        }
        System.out.printf("%d%%", vl2);

        for (int j = 0; j < ref - (int) (vl2 / 10) - idc2; j++) {
            System.out.printf("-");

        }
        if (vl2 < 10) {
            System.out.printf(" ");
        }

        System.out.printf("║ - %s\n", vetor[3]);
        System.out.printf("║");
        for (int i = 0; i < ref; i++) {

            System.out.printf(" ");
        }
        System.out.printf("║\n");

        System.out.printf("║");
        for (int i = 0; i < vl1 / 10; i++) {
            System.out.printf("░");
        }
        System.out.printf("%d%%", vl1);

        for (int j = 0; j < ref - (int) (vl1 / 10) - idc1; j++) {
            System.out.printf("-");

        }
        if (vl1 < 10) {
            System.out.printf("-");
        }

        System.out.printf("║ - %s\n", vetor[5]);
        System.out.printf("║");
        for (int i = 0; i < ref; i++) {

            System.out.printf(" ");
        }
        System.out.printf("║\n");

        System.out.printf("╚");
        for (int i = 0; i < ref; i++) {
            if (i == 13) {
                System.out.printf("╩");

            } else {

                System.out.printf("═");
            }
        }
        System.out.printf("╝\n");

        System.out.printf(" \n");
    }

    public static String[] organizador(int vl3, String label3, int vl2, String label2, int vl1, String label1) {
        int aux;
        String auxS;
        if (vl1 > vl2 && vl2 >= vl3) {
            auxS = label1;
            label1 = label3;
            label3 = auxS;
            aux = vl1;
            vl1 = vl3;
            vl3 = aux;
        }
        if (vl2 > vl3 && vl3 >= vl1) {
            auxS = label2;
            label2 = label3;
            label3 = auxS;
            aux = vl2;
            vl2 = vl3;
            vl3 = aux;
        }
        if (vl2 >= vl1 && vl1 > vl3) {
            auxS = label1;
            label1 = label3;
            label3 = label2;
            label2 = auxS;
            aux = vl1;
            vl1 = vl3;
            vl3 = vl2;
            vl2 = aux;
        }
        if (vl1 >= vl3 && vl3 > vl2) {
            auxS = label2;
            label2 = label3;
            label3 = label1;
            label1 = auxS;
            aux = vl2;
            vl2 = vl3;
            vl3 = vl1;
            vl1 = aux;

        }
        if (vl3 > vl1 && vl1 > vl2) {
            auxS = label2;
            label2 = label1;
            label1 = auxS;
            aux = vl2;
            vl2 = vl1;
            vl1 = aux;
        }
        String[] vetor = new String[6];
        vetor[0] = Integer.toString(vl3);
        vetor[1] = label3;
        vetor[2] = Integer.toString(vl2);
        vetor[3] = label2;
        vetor[4] = Integer.toString(vl1);
        vetor[5] = label1;

        return vetor;
    }

    public static int sorteia(int limiteInferior, int limiteSuperior) {
        Random rd = new Random();
        return rd.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
    }
}

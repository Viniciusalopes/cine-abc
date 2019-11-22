/*
 * A licença MIT
 *
 * Copyright 2019 Viniciusalopes Tecnologia <suporte@viniciusalopes.com.br>.
 *
 * É concedida permissão, gratuitamente, a qualquer pessoa que obtenha uma cópia
 * deste software e dos arquivos de documentação associados (o "Software"), para
 * negociar o Software sem restrições, incluindo, sem limitação, os direitos de uso,
 * cópia, modificação e fusão, publicar, distribuir, sublicenciar e/ou vender cópias
 * do Software, e permitir que as pessoas a quem o Software é fornecido o façam,
 * sujeitas às seguintes condições:
 *
 * O aviso de copyright acima e este aviso de permissão devem ser incluídos em
 * todas as cópias ou partes substanciais do Software.
 *
 * O SOFTWARE É FORNECIDO "NO ESTADO EM QUE SE ENCONTRA", SEM NENHUM TIPO DE GARANTIA,
 * EXPRESSA OU IMPLÍCITA, INCLUINDO, MAS NÃO SE LIMITANDO ÀS GARANTIAS DE COMERCIALIZAÇÃO,
 * ADEQUAÇÃO A UM FIM ESPECÍFICO E NÃO VIOLAÇÃO. EM NENHUMA CIRCUNSTÂNCIA, OS AUTORES
 * OU PROPRIETÁRIOS DE DIREITOS DE AUTOR PODERÃO SER RESPONSABILIZADOS POR QUAISQUER
 * REIVINDICAÇÕES, DANOS OU OUTRAS RESPONSABILIDADES, QUER EM AÇÃO DE CONTRATO,
 * DELITO OU DE OUTRA FORMA, DECORRENTES DE, OU EM CONEXÃO COM O SOFTWARE OU O USO
 * OU OUTRAS NEGOCIAÇÕES NO PROGRAMAS.
 * ------------------------------------------------------------------------------------------
 * Projeto   : TelaConsole
 * Criado em : 01/11/2019
 * Autor     : Viniciusalopes (Vovolinux) <suporte@viniciusalopes.com.br>
 * Finalidade: Fornecer caracteres de borda para impressão de telas no console.
 * ------------------------------------------------------------------------------------------
 * TABELA ASCII COMPLETA: https://www.ricardoarrigoni.com/tabela-ascii-completa/
 */
package app;

public class Bordas {

    private static String[] borda_dupla = {"╔", "╗", "╚", "╝", "╠", "╣", "╬", "╦", "╩", "═", "║"};
    private static String[] borda_simples = {"┌", "┐", "└", "┘", "├", "┤", "┼", "┬", "┴", "─", "│"};
    private static String[] borda_tracejada = {"+", "+", "+", "+", "+", "+", "+", "+", "+", "-", "|"};
    private static String[] borda_pontilhada = {".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ":"};

    /**
     * Caracteres para desenho de bordas na tela.
     *
     * @param tipo Tipo da borda: 'd'= dupla; 's'= simples; 't'= tracejada; 'p'=
     * pontilhada;
     * @param posicao Posição do caractere de borda no vetor do seu tipo.
     * @return Caractere de borda.
     */
    private static String get_borda(char tipo, int posicao) {
        switch (tipo) {
            case 'd':
                return borda_dupla[posicao];
            case 'p':
                return borda_pontilhada[posicao];
            case 't':
                return borda_tracejada[posicao];
            case 's':
                return borda_simples[posicao];
            default:
                return " ";
        }
    }

    /**
     * Obtém o tipo de borda utilizada atualmente pela outra camada.
     *
     * @param tipo Tipo da borda: 'd'= dupla; 's'= simples; 't'= tracejada; 'p'=
     * pontilhada;
     * @return String com o tipo de borda utilizada atualmente pela outra camada.
     */
    public static String get_borda_atual(char tipo) {
        switch (tipo) {
            case 'd':
                return "Borda atual: DUPLA";
            case 'p':
                return "Borda atual: PONTILHADA";
            case 't':
                return "Borda atual: TRACEJADA";
            case 's':
                return "Borda atual: SIMPLES";
            default:
                return "Borda atual: NENHUMA";
        }
    }

    /**
     * cse = Canto Superior Esquerdo.
     *
     * @param tipo Tipo da borda: 'd'= dupla; 's'= simples; 't'= tracejada; 'p'=
     * pontilhada;
     * @return Caractere de borda para o lado superior esquerdo.
     */
    public static String cse(char tipo) {
        return get_borda(tipo, 0); // XD qual tipo mesmo?!
    }

    /**
     * csd = Canto Superior Direito.
     *
     * @param tipo Tipo da borda: 'd'= dupla; 's'= simples; 't'= tracejada; 'p'=
     * pontilhada;
     * @return Caractere de borda para o lado superior direito.
     */
    public static String csd(char tipo) {
        return get_borda(tipo, 1);
    }

    /**
     * cie = Canto Inferior Esquerdo.
     *
     * @param tipo Tipo da borda: 'd'= dupla; 's'= simples; 't'= tracejada; 'p'=
     * pontilhada;
     * @return Caractere de borda para o lado inferior esquerdo.
     */
    public static String cie(char tipo) {
        return get_borda(tipo, 2);
    }

    /**
     * cid = Canto Inferior Direito.
     *
     * @param tipo Tipo da borda: 'd'= dupla; 's'= simples; 't'= tracejada; 'p'=
     * pontilhada;
     * @return Caractere de borda para o lado inferior direito.
     */
    public static String cid(char tipo) {
        return get_borda(tipo, 3);
    }

    /**
     * de = Divisor Esquerdo.
     *
     * @param tipo Tipo da borda: 'd'= dupla; 's'= simples; 't'= tracejada; 'p'=
     * pontilhada;
     * @return Caractere de borda para o lado esquerdo de uma linha divisória.
     */
    public static String de(char tipo) {
        return get_borda(tipo, 4);
    }

    /**
     * dd = Divisor Direito.
     *
     * @param tipo Tipo da borda: 'd'= dupla; 's'= simples; 't'= tracejada; 'p'=
     * pontilhada;
     * @return Caractere de borda para o lado direito de uma linha divisória.
     */
    public static String dd(char tipo) {
        return get_borda(tipo, 5);
    }

    /**
     * dc = Divisor Centro.
     *
     * @param tipo Tipo da borda: 'd'= dupla; 's'= simples; 't'= tracejada; 'p'=
     * pontilhada;
     * @return Caractere de borda para o cruzamento de duas linhas divisórias.
     */
    public static String dc(char tipo) {
        return get_borda(tipo, 6);
    }

    /**
     * dac = Divisor ACima.
     *
     * @param tipo Tipo da borda: 'd'= dupla; 's'= simples; 't'= tracejada; 'p'=
     * pontilhada;
     * @return Caractere de borda para o lado superior de uma linha divisória.
     */
    public static String dac(char tipo) {
        return get_borda(tipo, 7);
    }

    /**
     * dab = Divisor ABaixo.
     *
     * @param tipo Tipo da borda: 'd'= dupla; 's'= simples; 't'= tracejada; 'p'=
     * pontilhada;
     * @return Caractere de borda para o lado inferior de uma linha divisória.
     */
    public static String dab(char tipo) {
        return get_borda(tipo, 8);
    }

    /**
     * lh = Linha Horizontal
     *
     * @param tipo Tipo da borda: 'd'= dupla; 's'= simples; 't'= tracejada; 'p'=
     * pontilhada;
     * @return Caractere de borda para linha horizontal.
     */
    public static String lh(char tipo) {
        return get_borda(tipo, 9);
    }

    /**
     * lv = Linha Vertical
     *
     * @param tipo Tipo da borda: 'd'= dupla; 's'= simples; 't'= tracejada; 'p'=
     * pontilhada;
     * @return Caractere de borda para linha vertical.
     */
    public static String lv(char tipo) {
        return get_borda(tipo, 10);
    }
}

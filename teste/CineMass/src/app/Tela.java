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
 * sujeitas às seguint20es condições:
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
 * Finalidade: Impressão de telas no console, com título, subtítulo e bordas.
 * ------------------------------------------------------------------------------------------
 */
package app;

// Classe com utilitários de manipulação de strings
import java.util.Scanner;
import static util.StringUtils.*;

// Classe com os caracteres para desenho de margens e bordas
import static app.Bordas.*;

public class Tela {

    // Declaração de variáveis
    protected static String[] str_linhas;           // Vetor de linhas de uma string
    protected static String[] palavras;             // Vetor de palavras de uma string
    protected static int tamanho_da_linha = 76;     // Tamanho da linha a ser impressa
    protected static int linhas_impressas = 0;      // Quantidade de linhas impressas
    protected static int qtd_colunas = 90;          // Quantidade de colunas da tela
    protected static int min_colunas = 20;          // Quantidade mínima de colunas da tela
    protected static int max_colunas = 300;         // Quantidade máxima de colunas da tela
    protected static int qtd_linhas = 15;           // Quantidade de linhas da tela'
    protected static int min_linhas = 2;            // Quantidade mínima de linhas da tela
    protected static int max_linhas = 30;           // Quantidade máxima de linhas da tela
    protected static boolean trunca_linhas = false; // true: Trunca o texto para a qtd_linhas
    protected static char tb = 'd';                 // Tipo da borda

    // Get
    public static int getQtd_colunas() {
        return qtd_colunas;
    }

    public static int getQtd_linhas() {
        return qtd_linhas;
    }

    public static int getMin_colunas() {
        return min_colunas;
    }

    public static int getMax_colunas() {
        return max_colunas;
    }

    public static int getLinhas_impressas() {
        return linhas_impressas;
    }

    public static int getMin_linhas() {
        return min_linhas;
    }

    public static int getMax_linhas() {
        return max_linhas;
    }

    public static boolean isTrunca_linhas() {
        return trunca_linhas;
    }

    // Set
    public static void setTrunca_linhas(boolean trunca_linhas) {
        Tela.trunca_linhas = trunca_linhas;
    }

    /*
     * Limpa a tela no console (Linux, Windows e Mac)
     */
    public static void limpa_tela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            linhas_impressas = 0;
        }
    }

    /**
     * Exibe mensagem e aguarda o [ENTER] do usuário.
     */
    public static void enter_para_(String texto) {
        imprime("> Pressione [ENTER] para " + texto + "...");
        new Scanner(System.in).nextLine();  // Aguarda o [ENTER]
    }

    /**
     * Desenha uma mensagem na tela com o texto e bordas.
     *
     * @param texto Texto a ser impresso na tela.
     * @param colunas Quantidade de colunas da tela.
     * @param linhas Quantidade de linhas da tela.
     * @param tipo Tipo de borda da tela.
     * @param upperCase true: imprime em MAIÚSCULAS; false: imprime como vier no
     * parâmetro.
     */
    public static void desenha_mensagem(String texto, int colunas, int linhas, char tipo, boolean upperCase) {
        // Seta o tipo da borda
        tb = tipo;

        // Seta dimensões da tela
        set_dimensoes(texto, "", "", colunas, linhas);

        // Imprime borda superior
        borda_superior();
        if (upperCase) {
            // Imprime Titulo1
            titulo1(texto);
        } else {
            // Imprime Titulo2
            titulo2(texto);
        }

        // Imprime borda inferior
        borda_inferior();
    }

    /**
     * Imprime uma mensagem na tela.
     *
     * @param texto Texto a ser impresso na tela.
     */
    public static void imprime(String texto) {
        System.out.print(texto);
    }

    /**
     * Desenha uma tela com título, subtítulo, texto, rodapé e com bordas, com as linhas
     * padrão da classe Tela
     *
     * @param titulo Texto do título principal (Impresso em MAIÚSCULAS).
     * @param subtitulo Texto do titulo secundário.
     * @param texto Texto a ser impresso.
     * @param rodape Texto do rodapé.
     */
    public static void desenha_tela(String titulo, String subtitulo, String texto, String rodape) {
        desenha_tela(titulo, subtitulo, texto, rodape, qtd_colunas, qtd_linhas, tb);
    }

    /**
     * Desenha uma tela com título, subtítulo e texto de corpo e com bordas.
     *
     * @param titulo Texto do título principal (Impresso em MAIÚSCULAS).
     * @param subtitulo Texto do titulo secundário.
     * @param texto Texto a ser impresso.
     * @param colunas Quantidade de colunas da tela.
     * @param linhas Quantidade de linhas da tela.
     * @param tipo Tipo da borda: 'd'= dupla; 's'= simples; 't'= tracejada; 'p'=
     * pontilhada;
     */
    public static void desenha_tela(String titulo, String subtitulo, String texto, String rodape,
            int colunas, int linhas, char tipo) {

        // Seta o tipo da borda
        tb = tipo;

        // Seta dimensões da tela
        set_dimensoes(titulo, subtitulo, texto, colunas, linhas);

        // Imprime borda superior
        borda_superior();

        // Imprime Titulo1
        titulo1(titulo);

        // Imprime Divisão
        divisao();

        if (subtitulo.length() > 0) {
            // Imprime Titulo2
            titulo2(subtitulo);

            // Imprime Divisão
            divisao();
        }

        // Imprime Linhas
        for (String str_linha : str_linhas) {   // Para cada linha do vetor
            //str_linha = str_linha.trim();

            if (str_linha.length() <= tamanho_da_linha) {
                // A linha do vetor é menor ou igual ao tamanho_da_linha
                imprime_linha(str_linha);
            } else {
                // A linha do vetor é maior que o tamanho_da_linha
                // Quebra as linhas em partes do tamanho_da_linha ou menor
                quebra_linha(str_linha);
                imprime_linha(" ");
            }
        }

        //Completa tela com linhas em branco para a quantidade de linhas
        while (linhas_impressas <= qtd_linhas) {
            imprime_linha("");
        }

        // Imprime mensagem no rodapé
        if (!rodape.equals("")) {
            imprime_linha(rodape);
        }

        // Imprime borda inferior
        borda_inferior();

        if ((linhas_impressas > qtd_linhas + 1) && trunca_linhas) {// Última linha e trunca_linhas = true
            imprime("*** ALERTA: Existem " + (linhas_impressas - 1 - qtd_linhas) + " linhas do texto que estão ocultas! ***\n");
        }
    }

    /**
     * Define as dimensões da tela, corrigindo valores 0 (zero) para linhas e para
     * colunas.
     *
     * @param titulo Texto do título principal (Impresso em MAIÚSCULAS).
     * @param subtitulo Texto do titulo secundário.
     * @param texto Texto a ser impresso.
     * @param colunas Quantidade de colunas da tela.
     * @param linhas Quantidade de linhas da tela.
     */
    private static void set_dimensoes(String titulo, String subtitulo, String texto, int colunas, int linhas) {
        // Separa as linhas em um vetor
        str_linhas = texto.split("\n");

        // Se linhas == 0, dimendiona para a quantidade de linhas do texto
        qtd_linhas = (linhas <= 0) ? str_linhas.length : linhas;

        tamanho_da_linha = colunas - 4; // 4 = tamanho das margens esquerda e direita + 1 espaço de cada lado

        if (tamanho_da_linha <= 0) {    // colunas é 0 ou <4
            for (String str_linha : str_linhas) {   // para cada linha do texto

                // retira espaços do início e do fim da linha
                str_linha = str_linha.trim();

                if (str_linha.length() < tamanho_da_linha
                        || tamanho_da_linha <= 0) {
                    // dimensiona o tamanho da menor linha
                    tamanho_da_linha = str_linha.length();
                }
            }
            // dimensiona a quantidade de colunas pelo tamanho da menor linha // Separa as palavras do texto em um vetor
            qtd_colunas = tamanho_da_linha + 4;

        } else {    // tamaho da linha é > 0
            // Separa as palavras do texto em um vetor
            palavras = texto.split(" ");

            // Dimensiona a linha para o tamanho da maior palavra, caso 'colunas' < menor_palavra
            largura_minima(titulo, subtitulo, colunas);

            // Dimensiona a quantidade de colunas pela largura_mínima ou pela quantidade de colunas
            qtd_colunas = tamanho_da_linha + 4;
        }
    }

    /**
     * Dimensiona o tamanho_da_linha para tamanho de um dos títulos ou para o tamanho da
     * maior palavra do texto, caso o parâmetro 'colunas' seja menor que um deles.
     *
     * As quebras de linhas são feitas somente nos espaços em branco, então, o tamanho
     * mínimo da linha não pode ser menor que a maior palavra do texto ou do título.
     *
     * @param titulo Texto do titulo principal.
     * @param subtitulo Texto do titulo secundário.
     * @param colunas Quantidade de colunas definidas na chamada do método.
     */
    private static void largura_minima(String titulo, String subtitulo, int colunas) {

        tamanho_da_linha = colunas - 4;  // 4 = tamanho das margens esquerda e direita + 1 espaço de cada lado

        if (titulo.length() > tamanho_da_linha) {
            // Dimensiona para o tamanho do Titulo1
            tamanho_da_linha = titulo.trim().length();
        }
        if (subtitulo.length() > tamanho_da_linha) {
            // Dimensiona para o tamanho do Titulo2
            tamanho_da_linha = subtitulo.trim().length();
        }

        for (String palavra : palavras) {   // para todas as palavras
            if (palavra.trim().length() > tamanho_da_linha) {
                // Dimensiona para o tamanho da maior palavra 
                tamanho_da_linha = palavra.trim().length();
            }
        }
    }

    /**
     * Quebra uma linha de texto em várias linhas, dimensionadas para a quantidade de
     * colunas da tela.
     *
     * @param texto Texto a ser impresso na tela.
     */
    private static void quebra_linha(String texto) {
        texto = texto.trim();   // Retira espaços do início e do final do texto

        while (texto.length() > 0) {    // enquanto não imprimir todo o texto
            if (texto.length() > tamanho_da_linha) {   // A linha do vetor é maior ou igual ao tamanho_da_linha

                // pos: é a posição do texto onde será 'quebrada' a string 
                int pos = (texto.length() >= tamanho_da_linha) ? tamanho_da_linha : texto.length() - 1;

                while (texto.charAt(pos) != ' ') {  // enquanto o caracter texto[pos] não for um espaço
                    pos--;  // recua a posição para encontrar o primeiro espaço anterior
                }

                // 'recorta' a string do início do texto até 'pos'
                String tmp_str = texto.substring(0, pos);

                // exclui o texto recortado do texto
                texto = new String(texto.replace(tmp_str, "").trim());

                // Imprime o texto recortado
                imprime_linha(tmp_str);

            } else {
                // O que sobrou da linha do vetor é menor ou igual ao tamanho_da_linha
                imprime_linha(texto);

                // Esvazia a linha, já que seu tamanho é menor ou igual ao tamanho da linhas
                texto = "";
            }
        }
    }

    /**
     * Imprime o texto do título centralizado na tela e com as margens.
     *
     * @param titulo Texto do título a ser impresso.
     * @param toUpper true: imprime em MAIÚSCULAS; false: imprime como vier o parâmetro.
     */
    private static void imprime_titulo(String titulo, boolean toUpper) {
        // Tamanho do texto do título a ser impresso
        int tamanho = titulo.trim().length();

        int espacos = qtd_colunas - titulo.length() - 2;
        int ee, ed; // ee: espaços esquerda; ed: espaços direita
        ee = espacos / 2;
        ed = espacos - ee;

        if (titulo.length() > tamanho_da_linha) {
            // Trunca o título e acrescenta reticencias
            titulo = titulo.replace("\n", " ").substring(0, tamanho_da_linha - 1) + "...";
        }
        // Imprime: borda + ee + titulo + ed + borda
        System.out.println(lv(tb) + repete(" ", ee) + ((toUpper) ? titulo.toUpperCase() : titulo) + repete(" ", ed) + lv(tb));
    }

    /**
     * Imprime na tela o texto do titulo em MAIÚSCULAS, centralizado e com as margens.
     *
     * @param titulo Texto do título.
     */
    private static void titulo1(String titulo) {
        imprime_titulo(titulo, true);
    }

    /**
     * Imprime na tela o texto do titulo centralizado e com as margens.
     *
     * @param titulo Texto do título.
     */
    private static void titulo2(String titulo) {
        imprime_titulo(titulo, false);
    }

    /**
     * Imprime na tela a borda superior.
     */
    private static void borda_superior() {
        // Borda superior
        System.out.print(cse(tb));
        for (int i = 0; i < qtd_colunas - 2; i++) { // 2 = tamanho dos cantos
            System.out.print(lh(tb));
        }
        System.out.print(csd(tb) + "\n");
    }

    /**
     * Imprime na tela uma linha divisória.
     */
    private static void divisao() {
        System.out.print(de(tb));
        for (int i = 0; i < qtd_colunas - 2; i++) { // 2 = tamanho dos cantos
            System.out.print(lh(tb));
        }
        System.out.print(dd(tb) + "\n");
    }

    /**
     * Imprime na tela a borda inferior.
     */
    private static void borda_inferior() {
        System.out.print(cie(tb));
        for (int i = 0; i < qtd_colunas - 2; i++) { // 2 = tamanho dos cantos
            System.out.print(lh(tb));
        }
        System.out.print(cid(tb) + "\n");
    }

    /**
     * Imprime na tela a magem esquerda.
     */
    private static void borda_esquerda() {
        // Borda esquerda
        System.out.print(lv(tb) + " ");
    }

    /**
     * Imprime na tela a magem direita.
     */
    private static void borda_direita() {
        // Borda direita
        System.out.print(" " + lv(tb) + "\n");
    }

    /**
     * Imprime na tela uma linha com o texto e as margens equerda e direita.
     *
     * @param texto Linha de texto a ser impressa na tela.
     */
    private static void imprime_linha(String texto) {
        if (trunca_linhas) {
            if (linhas_impressas >= qtd_linhas) {
                linhas_impressas++;
                // Se a quantidade de linhas do texto for >= qtd_linhas retorna sem imprimir
                return;
            }
        }

        // Imprime a borda esquerda
        borda_esquerda();

        // Imprime o texto da linha
        System.out.print(texto);

        // Completa com espaços até a borda direita
        System.out.print(repete(" ", (tamanho_da_linha - texto.length())));

        // Imprime a borda direita
        borda_direita();

        // Incrementa a quantidade de linhas impressas na tela
        linhas_impressas++;

    }
}

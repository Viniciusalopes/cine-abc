package bll;

import java.util.HashMap;
import java.util.Scanner;

public class Validacao {

    public static String validaChave(HashMap<String, String[]> hashMapAux, String edicao) {
        Scanner input = new Scanner(System.in);
        System.out.printf("user_id:\n> ");
        String str;
        boolean sair = false;
        int opcao = 0;
        int indice = 0;
        if ("add".equals(edicao)) {
            indice = hashMapAux.size();

        } else if ("remove".equals(edicao)) {
            indice = hashMapAux.size() - 1;
        }
        do {
            do {

                try {
                    opcao = Integer.parseInt(input.nextLine());
                    sair = true;
                } catch (NumberFormatException e) {
                    System.out.printf("invalid usuer_id!\n");
                }
            } while (!sair);
            sair = false;

            if (opcao > indice || opcao < 0) {
                if (edicao.equals("add")) {

                    System.out.printf("invalid user, enter \"usuer_id\" you want to edit or %d for a new \"usuer_id\".\n", indice);
                } else {

                    System.out.printf("invalid user, enter the \"usuer_id\" you want to remove.\n");
                }
                System.out.println(hashMapAux.keySet());
            } else {
                sair = true;
            }
        } while (!sair);
        str = Integer.toString(opcao);
        return str;
    }

    public static int validaInt(String str) {
        int opcao = 0;
        try {
            opcao = Integer.parseInt(str);
            return opcao;
        } catch (NumberFormatException e) {
        }

        return opcao;
    }
}

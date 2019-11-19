package bll;

import app.App;
import dao.Banco;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    public static void menubanco() {
        Scanner input = new Scanner(System.in);
        boolean sair = false;
        int opcao1;
        do {
            App.Menu();
            int opcao = Validacao.validaInt(input.nextLine());
            switch (opcao) {
                case 0:
                    sair = true;
                    break;
                case 1:
                    do {
                        App.MenuEditar();
                        opcao1 = Validacao.validaInt(input.nextLine());
                        MenuEditar(opcao1);
                    } while (opcao1 != 0);
                    break;
                case 2:
                    App.imprimirValueBanco(Banco.getBanco());
                    break;
                default:
                    System.out.printf("Invalid option\n");
                    throw new AssertionError();
            }
        } while (!sair);
    }

    public static String[] MenuDados() {
        Scanner input = new Scanner(System.in);
        String usr[] = new String[2];
        for (int i = 0; i < usr.length; i++) {
            switch (i) {
                case 0:
                    System.out.printf("usuer_name\n> ");
                    usr[i] = input.nextLine();
                    break;
                case 1:
                    System.out.printf("usuer_email\n> ");
                    usr[i] = input.nextLine();
                    break;
                default:
                    break;
            }
        }
        return (usr);
    }

    public static HashMap<String, String[]> MenuEditar(int opcao) {
        if (opcao == 1) {
            for (int i = 0; i < Banco.getBanco().size() + 1; i++) {
                if (i == Banco.getBanco().size()) {
                    Banco.getBanco().put("id" + Validacao.validaChave(Banco.getBanco(), "add"), MenuDados());
                    return Banco.getBanco();
                }
            }
        } else if (opcao == 2) {
            String opcao2 = Validacao.validaChave(Banco.getBanco(), "remove");
            if (Validacao.validaInt(opcao2) < Banco.getBanco().size() || Validacao.validaInt(opcao2) > 0) {
                int x = Validacao.validaInt(opcao2);
                Banco.getBanco().remove("id" + opcao2);
                return Banco.getBanco();
            } else {
                System.out.printf("Nonexistent id!!!\n");
            }
        }
        return Banco.getBanco();
    }
}

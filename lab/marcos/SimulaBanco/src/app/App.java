package app;

import java.util.Arrays;
import java.util.HashMap;

public class App {

    public static void MenuEditar() {
        System.out.printf(""
                + "Edit Bank\n"
                + " 1. Add\n"
                + " 2. To remove\n"
                + " \n"
                + " 0. Exit Edition\n"
                + "> ");
    }

    public static void Menu() {
        System.out.printf(""
                + "Information Bank\n"
                + " 1. Edit Bank\n"
                + " 2. View bank data\n"
                + " \n"
                + " 0. Exit Bank\n"
                + "> "
        );
    }

    public static void imprimirValueBanco(HashMap<String, String[]> Banco) {
        System.out.printf("\n");
        int l = 0;
        Banco.keySet().forEach((i) -> {
            System.out.println(i + "=" + Arrays.toString(Banco.get(i)));
        });
        System.out.printf("\n");
    }
}

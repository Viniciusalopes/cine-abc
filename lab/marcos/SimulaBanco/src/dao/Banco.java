package dao;

import java.util.HashMap;

public class Banco {

    static HashMap<String, String[]> Banco = new HashMap<String, String[]>();

    public Banco() {
        String[] M0 = {"Marcos Paulo00", "00", "marcos00@marcospaulo.com"};
        String[] M1 = {"Marcos Paulo01", "01", "marcos01@marcospaulo.com"};
        String[] M2 = {"Marcos Paulo02", "02", "marcos02@marcospaulo.com"};
        Banco.put("n0", M0);
        Banco.put("n1", M1);
        Banco.put("n2", M2);
    }

    public static HashMap<String, String[]> getBanco() {
        return Banco;
    }
}

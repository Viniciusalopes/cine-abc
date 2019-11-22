package projetointegrador;

import java.util.ArrayList;
import java.util.Scanner;

public class ProjetoIntegrador {

    public static void main(String[] args) {
        Lugar anisberto = new Lugar();
        ArrayList<String> agenda = new ArrayList();
        anisberto.setBilhete(2018);
        anisberto.setLugar(agenda);

        agenda.add("Numero do Bilhete: " + anisberto.getBilhete());
        agenda.add("Cliente: Anisberto");
        agenda.add("POltrona: A5");
        agenda.add("Tipo: Meia");

        anisberto.estado();
    }
}

package dao;

import java.util.ArrayList;

public class Lugar {

    private ArrayList<String> lugar;
    private int bilhete;

    public void estado() {
        System.out.println("Numero do bilhete: " + this.getBilhete());
        System.out.println("Estado: " + this.getLugar());
    }

    // Get e Sete
    public ArrayList<String> getLugar() {
        return lugar;
    }

    public void setLugar(ArrayList<String> lugar) {
        this.lugar = lugar;
    }

    public int getBilhete() {
        return bilhete;
    }

    public void setBilhete(int bilhete) {
        this.bilhete = bilhete;
    }
}

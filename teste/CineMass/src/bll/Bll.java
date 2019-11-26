/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dao.Dao;
import java.util.ArrayList;
import model.Filme;

/**
 *
 * @author vovostudio
 */
public class Bll {

    private Dao dados;

    public Bll() {
        this.dados = new Dao();
    }

    public Object[] getListaDeFilmes() {
        ArrayList<Integer> ids = new ArrayList();
        ArrayList<String> titulos = new ArrayList();
        
        for(Filme f : dados.getFilmes()){
            ids.add(f.getId());
            titulos.add(f.getTitulo());
        }
        
//        Object[] retorno = new Object[2];
//        retorno[0] = ids;
//        retorno[1] = titulos;
//        return retorno;
//        
//      Object[] retorno = {ids, titulos};
//      return retorno;
        
        return new Object[]{ids, titulos};
    }
    
    public String imprimeTituloFilme(int id){
        for(Filme f : dados.getFilmes()){
            if(f.getId() == id){
                return f.getTitulo();
            }
        }
        return null;
    }
}
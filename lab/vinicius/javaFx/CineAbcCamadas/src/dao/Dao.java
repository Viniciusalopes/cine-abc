/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vovostudio
 */
public class Dao {

    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public Dao() {
        setUsuarios();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Inicia a coleção de usuários
     */
    private void setUsuarios() {
        usuarios.add(new Usuario("A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3",
                "Vinicius Araujo Lopes", 'm', "suporte@viniciusalopes.com.br", "11111111111"));

        usuarios.add(new Usuario("A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3",
                "Vovolinux", 'm', "suporte@vovolinux.com.br", "22222222222"));

    }
}

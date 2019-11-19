/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dao.Usuario;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 *
 * @author vovostudio
 */
public class Usuarios {

    /**
     * Verifica se o usuário existe e se a senha confere com o cadastro
     *
     * @param login Endereço de e-mail ou número de CPF
     * @param senha Texto comum da senha
     * @return true: Usuário válido; false: Usuário não existe ou a senha não confere.
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public boolean usuario_valido(String login, String senha) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {

        List<Usuario> usuarios = Principal.dao.getUsuarios();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCpf().equals(login)
                    || usuarios.get(i).getEmail().equals(login)) {
                if (usuarios.get(i).getSenha().equals(util.Senha.getSenhaSha256Hex(senha))) {
                    return true;
                }
            }
        }
        return false;
    }
}

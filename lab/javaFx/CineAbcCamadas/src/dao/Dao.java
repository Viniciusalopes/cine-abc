/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        Usuario u = new Usuario();

        u.setUsuario_id(1);
        u.setUsuario_nome("Vinicius");
        u.setUsuario_email("suporte@viniciusalopes.com.br");
        u.setUsuario_senha("A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3");
        usuarios.add(u);

        u = new Usuario();
        u.setUsuario_id(1);
        u.setUsuario_nome("Daniel");
        u.setUsuario_email("suporte@viniciusalopes.com.br");
        u.setUsuario_senha("A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3");
        usuarios.add(u);

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario us = new Usuario();
            us = usuarios.get(i);

            System.out.println(us.getUsuario_nome() + " - " + us.getUsuario_email());
        }
    }

    /**
     * Criptografa senha usando Hash.
     *
     * //System.out.printf("Senha SHA-256: %s", getSenhaSha256Hex("senha"));
     *
     * @param senha Texto da senha
     * @return Hexadecimal da senha criptografada
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     * @see https://www.devmedia.com.br/como-funciona-a-criptografia-hash-em-java/31139
     */
    public String getSenhaSha256Hex(String senha) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {

        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        return hexString.toString();
    }

}

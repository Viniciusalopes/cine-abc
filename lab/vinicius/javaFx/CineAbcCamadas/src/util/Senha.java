/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author vovostudio
 */
public class Senha {

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
    public static String getSenhaSha256Hex(String senha) throws NoSuchAlgorithmException,
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

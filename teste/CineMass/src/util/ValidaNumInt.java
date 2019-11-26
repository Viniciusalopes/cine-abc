/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;

/**
 *
 * @author marcos
 */
public class ValidaNumInt {

    public static int validaNumInt(String str, int lim) {
        Scanner input = new Scanner(System.in);

        try {
            Integer.parseInt(str);
            return Integer.parseInt(str);

        } catch (Exception e) {

        }

        return lim;
    }
}

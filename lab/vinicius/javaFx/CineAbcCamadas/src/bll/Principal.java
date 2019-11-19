/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import app.frmLogin;
import dao.Dao;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author vovostudio
 */
public class Principal extends Application {

    // Instância de dados do sistema
    public static Dao dao = new Dao();
    
    @Override
    public void start(Stage primaryStage) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        new app.frmLogin().setVisible(true);
    }

    

    
}

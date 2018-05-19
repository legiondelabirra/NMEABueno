/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Listener;
import utils.WindowManager;

/**
 *
 * @author Pau Castelló
 */
public class NMEA extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        File selectedFile = WindowManager.createFileChooser();
        if(selectedFile != null){
            InicioController i = WindowManager.createInicioWindow();
            i.init(selectedFile);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

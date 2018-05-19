/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import view.InicioController;
import view.direccionController;
import view.generalController;
import view.graficosController;
import view.vientoController;

/**
 *
 * @author Pau Castelló
 */
public class WindowManager {
    private static Stage mainStage;
    
    
    public static File createFileChooser(){
        FileChooser ficheroChooser = new FileChooser();
        ficheroChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("ficheros NMEA", "*.NMEA"));
        ficheroChooser.setTitle("fichero datos NMEA");
        
        Stage stage = new Stage();
        File ficheroNMEA = ficheroChooser.showOpenDialog(stage);
        return ficheroNMEA;
    }
    
    public static InicioController createInicioWindow() {
        InicioController con = null;
        try {
            FXMLLoader myLoader = new FXMLLoader(Object.class.getResource("/view/1inicio.fxml"));
            Parent root = (Parent) myLoader.load();
            con = myLoader.<InicioController>getController();
            mainStage = new Stage();
            Scene scene = new Scene(root);            
            mainStage.setScene(scene);
            mainStage.setResizable(false); 
            mainStage.setWidth(800);
            mainStage.setHeight(480);
            mainStage.setOnCloseRequest((event) -> {
                System.exit(1);
            });
            mainStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public static InicioController moveToInicioWindow() {
        InicioController con = null;
        try {
            FXMLLoader myLoader = new FXMLLoader(Object.class.getResource("/view/1inicio.fxml"));
            Parent root = (Parent) myLoader.load();
            con = myLoader.<InicioController>getController();           
            Scene scene = new Scene(root);            
            mainStage.setScene(scene);              
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    public static generalController moveToGeneralWindow() {
        generalController con = null;
        try {
            FXMLLoader myLoader = new FXMLLoader(Object.class.getResource("/view/2general.fxml"));
            Parent root = (Parent) myLoader.load();
            con = myLoader.<generalController>getController();           
            Scene scene = new Scene(root);            
            mainStage.setScene(scene);                        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    public static vientoController moveToVientoWindow() {
        vientoController con = null;
        try {
            FXMLLoader myLoader = new FXMLLoader(Object.class.getResource("/view/3viento.fxml"));
            Parent root = (Parent) myLoader.load();
            con = myLoader.<vientoController>getController();           
            Scene scene = new Scene(root);            
            mainStage.setScene(scene);                        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    public static direccionController moveToDireccionWindow() {
         direccionController con = null;
        try {
            FXMLLoader myLoader = new FXMLLoader(Object.class.getResource("/view/4direccion.fxml"));
            Parent root = (Parent) myLoader.load();
            con = myLoader.<direccionController>getController();           
            Scene scene = new Scene(root);            
            mainStage.setScene(scene);                        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
     public static graficosController moveToGraficosWindow() {
         graficosController con = null;
        try {
            FXMLLoader myLoader = new FXMLLoader(Object.class.getResource("/view/5graficos.fxml"));
            Parent root = (Parent) myLoader.load();
            con = myLoader.<graficosController>getController();           
            Scene scene = new Scene(root);            
            mainStage.setScene(scene);                        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
}

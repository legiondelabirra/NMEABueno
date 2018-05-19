/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import utils.Listener;
import utils.WindowManager;

/**
 * FXML Controller class
 *
 * @author Pau Castelló
 */
public class generalController implements Initializable {

    @FXML
    private Button botonGeneral;
    @FXML
    private Button botonViento;
    @FXML
    private Button botonDireccion;
    @FXML
    private Button botonGraficos;
    @FXML
    private Button botonModo;
    @FXML
    private Label longitudLabel;
    @FXML
    private Label temperaturaLabel;
    @FXML
    private Label latitudLabel;
    @FXML
    private Label sogLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Listener.getInstance().SOGProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> {
                sogLabel.setText(newValue.toString() + " KM/H");
            });
        });
        Listener.getInstance().TEMPProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> {
                temperaturaLabel.setText(String.format("%.2f ºC", newValue.doubleValue()));
            });
        });
        Listener.getInstance().LONProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> {
                longitudLabel.setText(String.format("%.2f º", newValue.doubleValue()));
            });
        });
        Listener.getInstance().LATProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> {
               latitudLabel.setText(String.format("%.2f ºC", newValue.doubleValue()));
            });
        });
        
    }    

         @FXML
    private void general(ActionEvent event) {
        WindowManager.moveToGeneralWindow();
    }

    @FXML
    private void viento(ActionEvent event) {
        WindowManager.moveToVientoWindow();
    }

    @FXML
    private void direccion(ActionEvent event) {
        WindowManager.moveToDireccionWindow();
    }

    @FXML
    private void graficos(ActionEvent event) {
        WindowManager.moveToGraficosWindow();
    }

    @FXML
    private void modo(ActionEvent event) {
    }
}

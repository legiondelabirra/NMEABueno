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
public class direccionController implements Initializable {

    @FXML
    private Button botonGeneral1;
    @FXML
    private Button botonViento1;
    @FXML
    private Button botonDireccion1;
    @FXML
    private Button botonGraficos1;
    @FXML
    private Button botonModo1;
    @FXML
    private Button botonCargar1;
    @FXML
    private Label pitchLabel;
    @FXML
    private Label hdgLabel;
    @FXML
    private Label cogLabel;
    @FXML
    private Label rollLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Listener.getInstance().HDGProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> {
                hdgLabel.setText(String.format("%.2f º", newValue.doubleValue()));
            });
        });
        Listener.getInstance().COGProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> {
                cogLabel.setText(String.format("%.2f º", newValue.doubleValue()));
            });
        });
        Listener.getInstance().PITCHProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> {
                pitchLabel.setText(String.format("%.2f º", newValue.doubleValue()));
            });
        });
        Listener.getInstance().ROLLProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> {
                rollLabel.setText(String.format("%.2f º", newValue.doubleValue()));
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

    @FXML
    private void cargar(ActionEvent event) {
    }

   
    
}

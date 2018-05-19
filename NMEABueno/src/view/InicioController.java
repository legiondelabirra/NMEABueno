/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Pau Castelló
 */
public class InicioController implements Initializable {

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
    private Button botonCargar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void general(ActionEvent event) {
    }

    @FXML
    private void viento(ActionEvent event) {
    }

    @FXML
    private void direccion(ActionEvent event) {
    }

    @FXML
    private void graficos(ActionEvent event) {
    }

    @FXML
    private void modo(ActionEvent event) {
    }

    @FXML
    private void cargar(ActionEvent event) {
    }
    
}

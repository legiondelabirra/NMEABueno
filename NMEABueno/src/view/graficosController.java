/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import utils.Listener;
import utils.WindowManager;

/**
 * FXML Controller class
 *
 * @author Pau Castelló
 */
public class graficosController implements Initializable {

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
    private LineChart<String, Number> direccion;
    @FXML
    private LineChart<String, Number> intensidad;

    private XYChart.Series<String, Number> directionSeries;
    
    private XYChart.Series<String, Number> intensidadSeries;
    
    private int seriesCapacity = 120;
    @FXML
    private Slider minutesSlider;
    @FXML
    private Label minutesLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {//graficas no van y si hay que poner mas ficheros 
        // TODO
        direccion.animatedProperty().set(false);
        direccion.setTitle("Dirección");
        intensidad.animatedProperty().set(false);
        intensidad.setTitle("Intensidad");
        directionSeries = new XYChart.Series<>();
        Listener.getInstance().TWDProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> {
                if(directionSeries.getData().size() >= seriesCapacity)
                    directionSeries.getData().clear();
                directionSeries.getData().add(new XYChart.Data<>(Integer.toString(directionSeries.getData().size()), newValue.doubleValue()));
            });
        });
        
        
        direccion.getData().add(directionSeries);
        intensidadSeries = new XYChart.Series<>();
        Listener.getInstance().TWSProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> {
                if(intensidadSeries.getData().size() >= seriesCapacity)
                    intensidadSeries.getData().clear();
                intensidadSeries.getData().add(new XYChart.Data<>(Integer.toString(intensidadSeries.getData().size()), newValue.doubleValue()));
            });
        });
        
        intensidad.getData().add(intensidadSeries);
        
        minutesSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            minutesLabel.setText(String.format("%2d min", newValue.intValue()));
            setMaximumMinutes(newValue.intValue());
        });
        minutesLabel.setText("2 min");
        
    }
    
    private void setMaximumMinutes(int minutes){
        seriesCapacity = minutes * 60;
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

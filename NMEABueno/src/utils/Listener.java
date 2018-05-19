package utils;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import net.sf.marineapi.nmea.event.AbstractSentenceListener;
import net.sf.marineapi.nmea.io.SentenceReader;
import net.sf.marineapi.nmea.sentence.*;
import net.sf.marineapi.nmea.util.Measurement;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class Listener {

    private static Listener instance = new Listener();

    private SentenceReader reader;

    private Listener(){

    }

    public static Listener getInstance() {
        return instance;
    }

    public void readFile(File file){
        try {
            InputStream stream = new FileInputStream(file);
            reader = new SentenceReader(stream);
            HDGSentenceListener hdg = new HDGSentenceListener();
            reader.addSentenceListener(hdg);
            MDASentenceListener mda = new MDASentenceListener();
            reader.addSentenceListener(mda);
            MWVSentenceListener mwv = new MWVSentenceListener();
            reader.addSentenceListener(mwv);
            XDRSentenceListener xdr = new XDRSentenceListener();
            reader.addSentenceListener(xdr);
            RMCSentenceListener rmc = new RMCSentenceListener();
            reader.addSentenceListener(rmc);
            reader.start();
        }catch (Exception e){}

    }

    public void stopListening(){
        if(reader == null)
            return;
        reader.stop();
    }

    private final DoubleProperty HEADING = new SimpleDoubleProperty();

    public DoubleProperty HDGProperty(){
        return HEADING;
    }

    class HDGSentenceListener extends AbstractSentenceListener<HDGSentence> {
        @Override
        public void sentenceRead(HDGSentence hdgSentence) {
            HEADING.set(hdgSentence.getHeading());
        }
    }

    private final DoubleProperty TWD = new SimpleDoubleProperty();

    public DoubleProperty TWDProperty(){
        return TWD;
    }

    private final DoubleProperty TWS = new SimpleDoubleProperty();

    public DoubleProperty TWSProperty(){
        return TWS;
    }

    private final DoubleProperty TEMP = new SimpleDoubleProperty();

    public DoubleProperty TEMPProperty(){
        return TEMP;
    }

    private final ObservableList<Double> windSpeedObsList =
            FXCollections.observableList(new ArrayList<>());

    public XYChart.Series<Number, Number> getWindSpeedData(){
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        int i = 0;
        for(Double d : windSpeedObsList){
            series.getData().add(new XYChart.Data<>(i, d));
            i++;
        }

        return series;
    }

    private final ObservableList<Double> windDirectionObsList =
            FXCollections.observableList(new ArrayList<>());

    public XYChart.Series<Number, Number> getWindDirectionData(){
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        int i = 0;
        for(Double d : windDirectionObsList){
            series.getData().add(new XYChart.Data<>(i, d));
            i++;
        }

        return series;
    }

    private int maximumData = 120;

    public void setGraphsInterval(int minutes){
        maximumData = minutes * 60;
    }

    class MDASentenceListener extends AbstractSentenceListener<MDASentence> {
        @Override
        public void sentenceRead(MDASentence mdaSentence) {
            if(windSpeedObsList.size() >= maximumData){
                windSpeedObsList.clear();
            }
            if(windDirectionObsList.size() >= maximumData){
                windDirectionObsList.clear();
            }

            windSpeedObsList.add(mdaSentence.getWindSpeed());
            windDirectionObsList.add(mdaSentence.getTrueWindDirection());

            TWD.set(mdaSentence.getTrueWindDirection());
            TWS.set(mdaSentence.getWindSpeed());
            TEMP.set(mdaSentence.getAirTemperature());
        }
    }

    private final DoubleProperty AWA = new SimpleDoubleProperty();

    public DoubleProperty AWAProperty(){
        return AWA;
    }

    private final DoubleProperty AWS = new SimpleDoubleProperty();

    public DoubleProperty AWSProperty(){
        return AWS;
    }

    class MWVSentenceListener extends AbstractSentenceListener<MWVSentence> {
        @Override
        public void sentenceRead(MWVSentence mwvSentence) {
            AWA.set(mwvSentence.getAngle());
            AWS.set(mwvSentence.getSpeed());
        }
    }

    private final DoubleProperty PITCH = new SimpleDoubleProperty();

    public DoubleProperty PITCHProperty(){
        return PITCH;
    }

    private final DoubleProperty ROLL = new SimpleDoubleProperty();

    public DoubleProperty ROLLProperty(){
        return ROLL;
    }

    class XDRSentenceListener extends AbstractSentenceListener<XDRSentence> {
        @Override
        public void sentenceRead(XDRSentence xdrSentence) {
            for(Measurement m : xdrSentence.getMeasurements()){
                if(m.getName().equals("PTCH")){  ///no se si va una I
                    PITCH.set(m.getValue());
                }
                if(m.getName().equals("ROLL")){
                    ROLL.set(m.getValue());
                }
            }
        }
    }

    private final DoubleProperty LAT = new SimpleDoubleProperty();

    public DoubleProperty LATProperty(){
        return LAT;
    }

    private final DoubleProperty LON = new SimpleDoubleProperty();

    public DoubleProperty LONProperty(){
        return LON;
    }

    private final DoubleProperty COG = new SimpleDoubleProperty();

    public DoubleProperty COGProperty(){
        return COG;
    }

    private final DoubleProperty SOG = new SimpleDoubleProperty();

    public DoubleProperty SOGProperty(){
        return SOG;
    }

    class RMCSentenceListener extends AbstractSentenceListener<RMCSentence> {
        @Override
        public void sentenceRead(RMCSentence rmcSentence) {
            SOG.set(rmcSentence.getSpeed());
            COG.set(rmcSentence.getCourse());
            LAT.set(rmcSentence.getPosition().getLatitude());
            LON.set(rmcSentence.getPosition().getLongitude());
        }
    }
}

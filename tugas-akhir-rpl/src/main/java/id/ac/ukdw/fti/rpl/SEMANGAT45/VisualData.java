package id.ac.ukdw.fti.rpl.SEMANGAT45;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import id.ac.ukdw.fti.rpl.SEMANGAT45.database.Database;
import id.ac.ukdw.fti.rpl.SEMANGAT45.modal.Event;
import id.ac.ukdw.fti.rpl.SEMANGAT45.modal.Places;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class VisualData implements Initializable {

    Database db = new Database();

    @FXML
    private AnchorPane background;

    @FXML
    private Accordion VisDat;

    @FXML
    private TitledPane VisDatPlaces;

    @FXML
    private AreaChart<NumberAxis, CategoryAxis> BentukVisDatPlaces;

    @FXML
    private CategoryAxis PlacesAxis;

    @FXML
    private NumberAxis TotalPlacesAxis;

    @FXML
    private TitledPane VisDatEvent;

    @FXML
    private AreaChart<NumberAxis, CategoryAxis> BentukVisDatEvent;

    @FXML
    private CategoryAxis EventAxis;

    @FXML
    private NumberAxis TotalEventAxis;

    @FXML
    private Text JudulVisDat;

    private ObservableList<Places> places = FXCollections.observableArrayList();
    private ObservableList<Event> events = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resourceBundle){
        try {
            places = Database.instance.visPlaces();
            XYChart.Series dataresult = new XYChart.Series();
            dataresult.setName("Places");
            BentukVisDatPlaces.setLegendVisible(false);
            for(int i = places.size()-1; i>-0; i--){
                System.out.println(places.get(i).getDisplayTitle());
                System.out.println(places.get(i).getEventsHere().split(",").length);                
                dataresult.getData().add(new BarChart.Data(places.get(i).getDisplayTitle(),places.get(i).getEventsHere().split(",").length));
            }
            BentukVisDatPlaces.getData().add(dataresult);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        
    /*try {
            events = Database.instance.visEvent();
            XYChart.Series dataresult = new XYChart.Series();
            dataresult.setName("Event");
            BentukVisDatEvent.setLegendVisible(false);
            for(int i = places.size()-1; i>-0; i--){
                System.out.println(events.get(i).getPlaces());
                System.out.println(events.get(i).getPlaces().split(",").length);                
                dataresult.getData().add(new BarChart.Data(events.get(i).getTitle(),events.get(i).getPlaces().split(",").length));
            }
            BentukVisDatEvent.getData().add(dataresult);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }*/
        
    }

}


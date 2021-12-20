package id.ac.ukdw.fti.rpl.SEMANGAT45;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import id.ac.ukdw.fti.rpl.SEMANGAT45.database.Database;
import id.ac.ukdw.fti.rpl.SEMANGAT45.modal.Event;
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

public class VisualData2 implements Initializable {

    Database db = new Database();

    @FXML
    private AnchorPane background_1;

    @FXML
    private Accordion VisDatEvent;

    @FXML
    private TitledPane JudulVisdat;

    @FXML
    private AreaChart<NumberAxis, CategoryAxis> BentukVisdatEvents;

    @FXML
    private CategoryAxis EventAxis;

    @FXML
    private NumberAxis TotalAxis;

    @FXML
    private Text JudulUtama;

    //private ObservableList<Places> places = FXCollections.observableArrayList();
    private ObservableList<Event> events = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resourceBundle){
        try {
            events = Database.instance.visEvent();
            //ArrayList<String> listPlace = new ArrayList<String>();
            XYChart.Series dataresult = new XYChart.Series();
            dataresult.setName("Event");
            BentukVisdatEvents.setLegendVisible(false);
            for(int i = events.size()-1; i>-0; i--){
                System.out.println(events.get(i).getPlaces());
                System.out.println(events.get(i).getPlaces().split(",").length);                
                dataresult.getData().add(new BarChart.Data(events.get(i).getTitle(),events.get(i).getPlaces().split(",").length));
            }
            BentukVisdatEvents.getData().add(dataresult);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        
    }

}

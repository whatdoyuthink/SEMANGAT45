package id.ac.ukdw.fti.rpl.SEMANGAT45;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import id.ac.ukdw.fti.rpl.SEMANGAT45.database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class VisualData implements Initializable {

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

    public void initialize(URL location, ResourceBundle resources){
        
    }

}


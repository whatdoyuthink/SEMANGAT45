package id.ac.ukdw.fti.rpl.SEMANGAT45;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import javafx.scene.Scene;
import java.util.ResourceBundle;
import id.ac.ukdw.fti.rpl.SEMANGAT45.database.Database;
import id.ac.ukdw.fti.rpl.SEMANGAT45.modal.Verse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class FXMLController implements Initializable {

    /**
     *
     */
    private ObservableList<Verse> verses = FXCollections.observableArrayList();

    @FXML
    private Text title;

    @FXML
    private TableView <Verse> tableView;

    @FXML
    private TextField searchField;

    @FXML
    private TableColumn<Verse, String> ayat;

    @FXML
    private TableColumn<Verse, String> events;

    @FXML
    private TableColumn<Verse, String> startdate;

    @FXML
    private TableColumn<Verse, String> duration;

    @FXML
    private Text pencarian;

    @FXML
    private Button btnVisDat;


    @FXML
    void display(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("VisualisasiData.fxml"));
        
        Stage stage = new Stage(StageStyle.DECORATED);
        Scene scene = new Scene(root2);

        scene.setRoot(root2);
        stage.setTitle("Visualisasi Data Places");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void display1(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("VisualisasiData2.fxml"));
        
        Stage stage = new Stage(StageStyle.DECORATED);
        Scene scene = new Scene(root2);

        scene.setRoot(root2);
        stage.setTitle("Visualisasi Data Event");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        verses = Database.instance.getAllverse();
        ayat.setCellValueFactory(new PropertyValueFactory<Verse, String>("Kitab"));
        events.setCellValueFactory(new PropertyValueFactory<Verse, String>("Pasal"));
        startdate.setCellValueFactory(new PropertyValueFactory<Verse,String>("Ayat"));
        duration.setCellValueFactory(new PropertyValueFactory<Verse,String>("Timeline"));
        tableView.setItems(verses);

    FilteredList<Verse> filteredData= new FilteredList<>(verses,searching->true);

        searchField.textProperty().addListener((Observable, oldValue, newValue) -> {
            filteredData.setPredicate(verse -> {
                if (newValue==null || newValue.isEmpty()) {
                    return true;            
                }
                String lowerCase=newValue.toLowerCase();
                if(verse.getKitab().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }              
                if(verse.getPasal().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }   
                if(verse.getAyat().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }                
                if(verse.getTimeline().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }
                else{
                    return false;
                }
            });
        });  

        SortedList<Verse> sortingData = new SortedList<>(filteredData);
        sortingData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortingData);
    }
}

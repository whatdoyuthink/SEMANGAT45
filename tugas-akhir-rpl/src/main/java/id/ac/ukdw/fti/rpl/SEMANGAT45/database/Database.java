package id.ac.ukdw.fti.rpl.SEMANGAT45.database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import id.ac.ukdw.fti.rpl.SEMANGAT45.modal.Verse;

import id.ac.ukdw.fti.rpl.SEMANGAT45.modal.Event;
import id.ac.ukdw.fti.rpl.SEMANGAT45.modal.Places;
import id.ac.ukdw.fti.rpl.SEMANGAT45.modal.Verse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {
    final private String url = "jdbc:sqlite:vizbible.sqlite";
    final String queryselect = "SELECT book, chapter, richText, eventsDescribed FROM verses";
    ObservableList<Verse> verses = FXCollections.observableArrayList();
    private Connection connection = null;
    public static Database instance = new Database();

    public Database(){
        try {
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ObservableList<Verse> getAllverse(){
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queryselect);
            while (result.next()){
            Verse verse = new Verse();
            verse.setKitab(result.getString("book"));
            verse.setPasal(result.getString("chapter"));
            verse.setAyat(result.getString("richText"));
            verse.setTimeline(result.getString("eventsDescribed"));

            verses.add(verse);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return verses;

    }
        
        ObservableList<Event>events = FXCollections.observableArrayList();
        public ObservableList<Event> visEvent(){
            String query = "SELECT verses, title, locations FROM events";
            try {
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                while (result.next()){
                    Event event = new Event();
                    event.setVerses(result.getString("verses"));
                    event.setTitle(result.getString("title"));
                    event.setPlaces(result.getString("locations"));
                    events.add(event);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return events;
            
        }
        ObservableList<Places>places = FXCollections.observableArrayList();
        public ObservableList<Places> visPlaces() {
            String query = "SELECT verses, displayTitle, eventsHere FROM places";
            try {
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                while(result.next()){
                    Places place = new Places();
                    place.setVerses(result.getString("verses"));
                    place.setdisplayTitle(result.getString("displayTitle"));
                    place.setEventsHere(result.getString("eventsHere"));
                    places.add(place);
                } 
            } catch (Exception e) {
                //TODO: handle exception
            }
            return places; 
    }
    public Connection opeConnection(Database database){
        return database.connection;
        
    }
   
}

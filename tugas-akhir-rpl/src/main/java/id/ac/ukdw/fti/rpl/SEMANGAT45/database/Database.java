package id.ac.ukdw.fti.rpl.SEMANGAT45.database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

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
    public Connection opeConnection(Database database){
        return database.connection;
    }
   
}

module SEMANGAT45 {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    requires sqlite.jdbc;

    opens id.ac.ukdw.fti.rpl.SEMANGAT45 to javafx.fxml;
    exports id.ac.ukdw.fti.rpl.SEMANGAT45;
    exports id.ac.ukdw.fti.rpl.SEMANGAT45.database;
    exports id.ac.ukdw.fti.rpl.SEMANGAT45.modal;
}

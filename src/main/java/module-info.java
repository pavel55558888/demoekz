module com.example.demoekz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.demoekz to javafx.fxml;
    exports com.example.demoekz;
    exports com.example.demoekz.controllers;
    opens com.example.demoekz.controllers to javafx.fxml;
    exports com.example.demoekz.database;
    opens com.example.demoekz.database to javafx.fxml;
}
module com.example.demoekz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.demoekz to javafx.fxml;
    opens com.example.demoekz.pojo to javafx.fxml;
    exports com.example.demoekz.pojo;
    exports com.example.demoekz;
    exports com.example.demoekz.hellocontroller;
    opens com.example.demoekz.hellocontroller to javafx.fxml;
    exports com.example.demoekz.database;
    opens com.example.demoekz.database to javafx.fxml;
    exports com.example.demoekz.shopercontroller;
    opens com.example.demoekz.shopercontroller to javafx.fxml;
    exports com.example.demoekz.oldercontroller;
    opens com.example.demoekz.oldercontroller to javafx.fxml;
    exports com.example.demoekz.admincontroller;
    opens com.example.demoekz.admincontroller to javafx.fxml;
}
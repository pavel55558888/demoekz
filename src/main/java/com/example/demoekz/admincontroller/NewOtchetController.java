package com.example.demoekz.admincontroller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demoekz.HelloApplication;
import com.example.demoekz.database.DataBase;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewOtchetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button but;

    @FXML
    private TextField date;

    @FXML
    private TextField name;

    @FXML
    private TextField quantity;

    private DataBase db = new DataBase();

    @FXML
    void initialize() {

        but.setOnAction(actionEvent -> {
            try {
                db.addOtchet(date.getText(),name.getText(),quantity.getText());
                HelloApplication.setScenAdmin(actionEvent);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        back.setOnAction(actionEvent -> {
            try {
                HelloApplication.setScenAdmin(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


    }

}

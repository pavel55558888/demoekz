package com.example.demoekz.oldercontroller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demoekz.HelloApplication;
import com.example.demoekz.database.DataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ServicesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button but;

    @FXML
    private TextField date_order;

    @FXML
    private TextField kod_services;

    @FXML
    private TextField kod_user;

    @FXML
    private Button add_user;

    private DataBase db = new DataBase();

    @FXML
    void initialize() {
        back.setOnAction(actionEvent -> {
            try {
                HelloApplication.setScenOld(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        but.setOnAction(actionEvent -> {
            String kodUser = kod_user.getText();
            String date = date_order.getText();
            String kodServices = kod_services.getText();

            try {
                db.setServices(kodUser,date,kodServices);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

    }

}

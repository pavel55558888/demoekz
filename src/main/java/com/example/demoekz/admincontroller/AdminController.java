package com.example.demoekz.admincontroller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demoekz.HelloApplication;
import com.example.demoekz.database.DataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button hystori;

    @FXML
    private ImageView img;

    @FXML
    private Button order;

    @FXML
    private Button otchet;

    @FXML
    private Button rashod;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        back.setOnAction(actionEvent -> {
            try {
                HelloApplication.setScenStart(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        order.setOnAction(actionEvent -> {
            try {
                HelloApplication.setScenGetOrder(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        hystori.setOnAction(actionEvent -> {
            try {
                HelloApplication.setScenHystori(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        otchet.setOnAction(actionEvent -> {
            try {
                HelloApplication.setScenNewOtchet(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        rashod.setOnAction(actionEvent -> {
            try {
                HelloApplication.setScenConsumables(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


    }

}

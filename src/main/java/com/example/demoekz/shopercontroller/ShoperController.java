package com.example.demoekz.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demoekz.HelloApplication;
import com.example.demoekz.database.DataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class ShoperController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button but;

    @FXML
    private Button add_user;

    @FXML
    private TextField date;

    @FXML
    private TextField date_close;

    @FXML
    private ImageView img;

    @FXML
    private TextField kod;

    @FXML
    private TextField kod_user;

    @FXML
    private TextField services;

    @FXML
    private TextField time;

    @FXML
    private TextField time_close;

    private DataBase db = new DataBase();

    @FXML
    void initialize() {

        back.setOnAction(actionEvent -> {
            try {
                HelloApplication.setScenStart(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        but.setOnAction(actionEvent -> {
            try {
                goOrder();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        add_user.setOnAction(actionEvent -> {
            try {
                HelloApplication.setScenAddUser(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }


    private void goOrder() throws SQLException, ClassNotFoundException {
        String kod = this.kod.getText();
        String date = this.date.getText();
        String time = this.time.getText();
        String kod_user = this.kod_user.getText();
        String services = this.services.getText();
        String date_close = this.date_close.getText();
        String time_close = this.time_close.getText();

        db.setOrder(kod,date,time,kod_user,services,date_close,time_close);
    }

}

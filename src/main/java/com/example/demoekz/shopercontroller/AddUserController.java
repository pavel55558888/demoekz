package com.example.demoekz.shopercontroller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demoekz.HelloApplication;
import com.example.demoekz.database.DataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField adress;

    @FXML
    private Button back;

    @FXML
    private Button but;

    @FXML
    private TextField date_start;

    @FXML
    private TextField email;

    @FXML
    private TextField kod_user;

    @FXML
    private TextField lastname;

    @FXML
    private TextField name;

    @FXML
    private TextField number;

    @FXML
    private TextField pass;

    @FXML
    private TextField series;

    @FXML
    private TextField surname;

    private DataBase db = new DataBase();

    @FXML
    void initialize() {
        back.setOnAction(actionEvent -> {
            try {
                HelloApplication.setScenMenuShoper(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        but.setOnAction(actionEvent -> {
            try {
                db.addUser(surname.getText(),name.getText(),lastname.getText(),kod_user.getText(),series.getText(),number.getText(),date_start.getText(),adress.getText(),email.getText(),pass.getText());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

    }

}

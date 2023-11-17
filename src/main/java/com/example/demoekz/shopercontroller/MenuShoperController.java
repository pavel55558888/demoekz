package com.example.demoekz.shopercontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.demoekz.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuShoperController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button new_user;

    @FXML
    private Button new_zakaz;

    @FXML
    void initialize() {
        new_zakaz.setOnAction(actionEvent -> {
            try {
                HelloApplication.setScenShoper(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        back.setOnAction(actionEvent -> {
            try {
                HelloApplication.setScenStart(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        new_user.setOnAction(actionEvent -> {
            try {
                HelloApplication.setScenAddUser(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

}

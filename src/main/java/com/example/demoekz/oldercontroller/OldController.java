package com.example.demoekz.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.demoekz.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class OldController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button but1;

    @FXML
    private Button but2;

    @FXML
    private Button back;

    @FXML
    private ImageView img;

    @FXML
    void initialize() {
        but1.setOnAction(actionEvent -> {
            try {
                HelloApplication.setScenShoper(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        but2.setOnAction(actionEvent -> {
            try {
                HelloApplication.setScenServices(actionEvent);
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

    }

}

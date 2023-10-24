package com.example.demoekz.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demoekz.HelloApplication;
import com.example.demoekz.database.DataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button but;

    @FXML
    private Label capcha_lbl;

    @FXML
    private TextField capcha_txt;

    @FXML
    private TextField login;

    @FXML
    private PasswordField pass;

    @FXML
    private Label lbl_popitok;

    private int popitok = 0;

    private int popitki = 5;

    DataBase db = new DataBase();


    @FXML
    void initialize() {
        int number = (int) ((Math.random() * ((1111 + 9999) + 1)) + 1111);
        String str = String.valueOf(number);
        capcha_lbl.setText(String.valueOf(number));
        but.setOnAction(actionEvent -> {
            try {
                if (popitok >= 4) {
                    Thread.sleep(3000);
                    popitok = 0;
                    popitki = 5;
                }
                else{
                    if (db.auth(login.getText(), pass.getText())) {

                        if (str.equals(capcha_txt.getText())) {

                            db.setHistory(login.getText());

                            try {

                                if (db.role(login.getText(), pass.getText()).equals("Продавец")) {
                                    HelloApplication.setScenShoper(actionEvent);
                                } else if (db.role(login.getText(), pass.getText()).equals("Старший смены")) {
                                    HelloApplication.setScenOld(actionEvent);
                                } else if (db.role(login.getText(), pass.getText()).equals("Администратор")) {
                                    HelloApplication.setScenAdmin(actionEvent);
                                }

                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        } else {
                            capcha_txt.setText("неверная капча");
                        }

                    } else {
                        login.setText("неверные данные");
                        popitok++;
                        popitki--;
                        lbl_popitok.setText("Осталось попыток: " + popitki);
                    }
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });


    }




}

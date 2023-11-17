package com.example.demoekz.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demoekz.HelloApplication;
import com.example.demoekz.database.DataBase;
import com.example.demoekz.pojo.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GetOrderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_back;

    private ObservableList<Order> usersData = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Order, String> date;

    @FXML
    private TableColumn<Order, String> date_close;

    @FXML
    private TableColumn<Order, Integer> id;

    @FXML
    private TableColumn<Order, String> kod;

    @FXML
    private TableColumn<Order, String> kod_user;

    @FXML
    private TableColumn<Order, String> services;

    @FXML
    private TableColumn<Order, String> status;

    @FXML
    private TableView<Order> tableview;

    @FXML
    private TableColumn<Order, String> time;

    @FXML
    private TableColumn<Order, String> time_drive;

    private DataBase db = new DataBase();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        ResultSet order = db.getOrder();
        while (order.next()){
            usersData.add(new Order(order.getInt(1),order.getString(2),order.getString(3),order.getString(4),order.getString(5),
                       order.getString(6),order.getString(7),order.getString(8),order.getString(9)));
           }

        id.setCellValueFactory(new PropertyValueFactory<Order, Integer>("id"));
        kod.setCellValueFactory(new PropertyValueFactory<Order, String>("kod"));
        date.setCellValueFactory(new PropertyValueFactory<Order, String>("date"));
        time.setCellValueFactory(new PropertyValueFactory<Order, String>("time"));
        kod_user.setCellValueFactory(new PropertyValueFactory<Order, String>("kod_user"));
        services.setCellValueFactory(new PropertyValueFactory<Order, String>("services"));
        status.setCellValueFactory(new PropertyValueFactory<Order, String>("status"));
        date_close.setCellValueFactory(new PropertyValueFactory<Order, String>("date_close"));
        time_drive.setCellValueFactory(new PropertyValueFactory<Order, String>("time_drive"));

        tableview.setItems(usersData);

        btn_back.setOnAction(actionEvent -> {
            try {
                HelloApplication.setScenAdmin(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}

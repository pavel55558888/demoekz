package com.example.demoekz.admincontroller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demoekz.HelloApplication;
import com.example.demoekz.database.DataBase;
import com.example.demoekz.pojo.Consumables;
import com.example.demoekz.pojo.Hystori_;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ConsumablesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private TableColumn<Consumables,String> date;

    @FXML
    private TableColumn<Consumables,String> name;

    @FXML
    private TableColumn<Consumables,String> quantity;

    @FXML
    private TableView<Consumables> tableview;

    private ObservableList<Consumables> usersData = FXCollections.observableArrayList();

    private DataBase db = new DataBase();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        ResultSet res = db.getConsumables();
        while (res.next()){
            usersData.add(new Consumables(res.getString(1),res.getString(2),res.getString(3)));
        }

        name.setCellValueFactory(new PropertyValueFactory<Consumables, String>("name"));
        date.setCellValueFactory(new PropertyValueFactory<Consumables, String>("date"));
        quantity.setCellValueFactory(new PropertyValueFactory<Consumables, String>("quantity"));


        tableview.setItems(usersData);

        back.setOnAction(actionEvent -> {
            try {
                HelloApplication.setScenAdmin(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


    }

}

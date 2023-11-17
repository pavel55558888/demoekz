package com.example.demoekz.admincontroller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demoekz.HelloApplication;
import com.example.demoekz.database.DataBase;
import com.example.demoekz.pojo.Hystori_;
import com.example.demoekz.pojo.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HystoriController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private TableColumn<Hystori_, String> last_output;

    @FXML
    private TableColumn<Hystori_, String> lastname;

    @FXML
    private TableColumn<Hystori_, String> name;

    @FXML
    private TableColumn<Hystori_, String> surname;

    @FXML
    private TableView<Hystori_> tableview;


    private ObservableList<Hystori_> usersData = FXCollections.observableArrayList();

    private DataBase db = new DataBase();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        ResultSet res = db.getHystori();
        while (res.next()){
            usersData.add(new Hystori_(res.getString(1),res.getString(2),res.getString(3),res.getString(4)));
        }

        surname.setCellValueFactory(new PropertyValueFactory<Hystori_, String>("surname"));
        name.setCellValueFactory(new PropertyValueFactory<Hystori_, String>("name"));
        lastname.setCellValueFactory(new PropertyValueFactory<Hystori_, String>("lastname"));
        last_output.setCellValueFactory(new PropertyValueFactory<Hystori_, String>("last_output"));


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

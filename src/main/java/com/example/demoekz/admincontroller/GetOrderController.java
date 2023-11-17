package com.example.demoekz.admincontroller;

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
import javafx.scene.control.TextField;
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

    @FXML
    private Button but_code;

    @FXML
    private Button but_code_user;

    @FXML
    private Button but_date;

    @FXML
    private Button but_id;

    @FXML
    private Button cancellation;

    @FXML
    private TextField search_code;

    @FXML
    private TextField search_date;

    @FXML
    private TextField search_id;

    @FXML
    private TextField serach_code_user;

    private DataBase db = new DataBase();

    public GetOrderController() {
    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        search_date.setText(db.getCacheDate());

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

        but_id.setOnAction(actionEvent -> {
            try {
                setOrderId();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        but_date.setOnAction(actionEvent -> {
            try {
                setOrderDate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        but_code.setOnAction(actionEvent -> {
            try {
                setOrderCode();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        but_code_user.setOnAction(actionEvent -> {
            try {
                setOrderCodeUser();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        cancellation.setOnAction(actionEvent -> {
            try {
                setOrderCancellation();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });



    }

    private void setOrderCancellation() throws SQLException, ClassNotFoundException {
        for ( int i = 0; i<tableview.getItems().size(); i++) {
            tableview.getItems().clear();
        }
        ResultSet res = db.getOrder();
        while (res.next()){
            usersData.add(new Order(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),
                    res.getString(6),res.getString(7),res.getString(8),res.getString(9)));
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

    }

    public void setOrderId() throws SQLException, ClassNotFoundException {
        for ( int i = 0; i<tableview.getItems().size(); i++) {
            tableview.getItems().clear();
        }
        ResultSet res = db.getOrderId(search_id.getText());
        while (res.next()){
            usersData.add(new Order(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),
                    res.getString(6),res.getString(7),res.getString(8),res.getString(9)));
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

    }

    public void setOrderDate() throws SQLException, ClassNotFoundException {
        for ( int i = 0; i<tableview.getItems().size(); i++) {
            tableview.getItems().clear();
        }
        ResultSet res = db.getOrderDate(search_date.getText());
        while (res.next()){
            usersData.add(new Order(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),
                    res.getString(6),res.getString(7),res.getString(8),res.getString(9)));
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

        db.setCacheDate(search_date.getText());
    }

    public void setOrderCode() throws SQLException, ClassNotFoundException {
        for ( int i = 0; i<tableview.getItems().size(); i++) {
            tableview.getItems().clear();
        }
        ResultSet res = db.getOrderCode(search_code.getText());
        while (res.next()){
            usersData.add(new Order(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),
                    res.getString(6),res.getString(7),res.getString(8),res.getString(9)));
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

    }

    public void setOrderCodeUser() throws SQLException, ClassNotFoundException {
        for ( int i = 0; i<tableview.getItems().size(); i++) {
            tableview.getItems().clear();
        }
        ResultSet res = db.getOrderCodeUser(serach_code_user.getText());
        while (res.next()){
            usersData.add(new Order(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),
                    res.getString(6),res.getString(7),res.getString(8),res.getString(9)));
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

    }


}

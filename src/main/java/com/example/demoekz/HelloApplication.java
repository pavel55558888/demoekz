package com.example.demoekz;

import com.example.demoekz.database.DataBase;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.EventObject;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.getIcons().add(new Image("C:\\Users\\p-vik\\IdeaProjects\\demoekz\\src\\main\\resources\\com\\example\\demoekz\\img\\logo.png"));
        stage.setTitle("Авторизация");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void stop() throws SQLException, ClassNotFoundException {
        try {
            DataBase db = new DataBase();
            db.deleteTable();
        }catch (Exception ex){
            System.out.println("Таблица не найдена #catch");
        }

    }

    public static void scen(Stage stage,String fxml,int size1,int size2,String name) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), size1, size2);
        stage.setTitle(name);
        stage.setScene(scene);
        stage.show();
    }

    public static void setScenStart(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelloApplication.scen(stage,"hello-view.fxml",600,400,"Авторизация");

    }
    public static void setScenShoper(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelloApplication.scen(stage,"shoper.fxml",700,355,"Формирование заказа");
    }
    public static void setScenServices(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelloApplication.scen(stage,"services.fxml",320,330,"Принять товар");
    }
    public static void setScenOld(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelloApplication.scen(stage,"old.fxml",600,230,"Старшый смены");
    }

    public static void setScenGetOrder(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelloApplication.scen(stage,"get-order.fxml",877,623,"Просмотр заказов");
    }
    public static void setScenAdmin(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelloApplication.scen(stage,"admin.fxml",505,240,"Администратор");
    }

    public static void setScenHystori(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelloApplication.scen(stage,"hystori.fxml",480,400,"История входа");
    }

    public static void setScenAddUser(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelloApplication.scen(stage,"add-user.fxml",440,330,"Добавление нового пользователя");
    }
    public static void setScenNewOtchet(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelloApplication.scen(stage,"newotchet.fxml",235,280,"Добавление нового отчета");
    }

    public static void setScenConsumables(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelloApplication.scen(stage,"consumables.fxml",365,230,"Отчет");
    }
    public static void setScenMenuShoper(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelloApplication.scen(stage,"menu-shopper.fxml",440,220,"Продавец");
    }

}
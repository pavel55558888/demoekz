package com.example.demoekz.database;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Stack;


public class DataBase {
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DBNAME = "pavel";
    private final String LOGIN = "root";
    private final String PASS = "root";
    private Connection dbconn = null;

    //Подключение БД
    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String constr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbconn = DriverManager.getConnection(constr, LOGIN, PASS);
        return dbconn;
    }


        public boolean auth (String login, String pass) throws SQLException, ClassNotFoundException {
            String sql = "SELECT `id` FROM `personal` WHERE `login` = ? and `pass` = ?";

            PreparedStatement PS = getDbConnection().prepareStatement(sql);
            PS.setString(1, login);
            PS.setString(2, pass);

            ResultSet res = PS.executeQuery();
            return res.next();
        }

        public String role (String login, String pass) throws SQLException, ClassNotFoundException {
            String sql = "SELECT `role` FROM `personal` WHERE `login` = ? and `pass` = ?";

            PreparedStatement PS = getDbConnection().prepareStatement(sql);
            PS.setString(1, login);
            PS.setString(2, pass);

            ResultSet res = PS.executeQuery();

            String str = "";
            while (res.next()) {
                str = res.getString("role");
            }
            return str;
        }

        public void setServices (String kod_user, String date, String kod_services) throws
        SQLException, ClassNotFoundException {
            String sql = "UPDATE `order` SET `status` = ? WHERE `kod_user` = ? AND `date` = ? AND `services` = ? ";

            PreparedStatement PS = getDbConnection().prepareStatement(sql);
            PS.setString(1, "Закрыта");
            PS.setString(2, kod_user);
            PS.setString(3, date);
            PS.setString(4, kod_services);

            PS.executeUpdate();
        }

        public void setOrder (String kod, String date, String time, String kod_user, String services, String
        date_close, String time_drive) throws SQLException, ClassNotFoundException {
            String sql = "INSERT INTO `order` (`kod`, `date`, `time`, `kod_user`,`services`, `status`, `date_close`, `time_drive`) VALUE (?,?,?,?,?,?,?,?)";

            PreparedStatement PS = getDbConnection().prepareStatement(sql);
            PS.setString(1, kod);
            PS.setString(2, date);
            PS.setString(3, time);
            PS.setString(4, kod_user);
            PS.setString(5, services);
            PS.setString(6, "В прокате");
            PS.setString(7, date_close);
            PS.setString(8, time_drive);

            PS.executeUpdate();
        }


        public void setHistory (String login) throws SQLException, ClassNotFoundException {
            String sql = "UPDATE `personal` SET `last_output` = ? WHERE `login` = ?";

            SimpleDateFormat formatter= new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());

            PreparedStatement PS = getDbConnection().prepareStatement(sql);
            PS.setString(1, formatter.format(date));
            PS.setString(2, login);

            PS.executeUpdate();
        }

        public ResultSet getOrder() throws SQLException, ClassNotFoundException {
            String sql = "SELECT * FROM `order`";

            PreparedStatement PS = getDbConnection().prepareStatement(sql);

            ResultSet res = PS.executeQuery();

            return res;
        }

        public ResultSet getHystori() throws SQLException, ClassNotFoundException {
            String sql = "SELECT `surname`,`name`,`lastname`,`last_output` FROM `personal`";

            PreparedStatement PS = getDbConnection().prepareStatement(sql);

            ResultSet res = PS.executeQuery();

            return res;
        }


    public void addUser(String surname, String name, String lastname, String kod_user, String series, String number, String date_start, String adress, String email, String pass) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `user` (`surname`, `name`, `lastname`, `kod_user`,`series`, `number`, `date_start`, `adress`,`e-mail`,`pass`) VALUE (?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement PS = getDbConnection().prepareStatement(sql);
        PS.setString(1, surname);
        PS.setString(2, name);
        PS.setString(3, lastname);
        PS.setString(4, kod_user);
        PS.setString(5, series);
        PS.setString(6, number);
        PS.setString(7, date_start);
        PS.setString(8, adress);
        PS.setString(9, email);
        PS.setString(10, pass);

        PS.executeUpdate();
    }

    public void addOtchet(String name, String date, String quantity) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `consumables` (`name`, `date`, `quantity`) VALUE (?,?,?)";

        PreparedStatement PS = getDbConnection().prepareStatement(sql);
        PS.setString(1, name);
        PS.setString(2, date);
        PS.setString(3, quantity);

        PS.executeUpdate();
    }

    public ResultSet getConsumables() throws SQLException, ClassNotFoundException {
        String sql = "SELECT `name`,`date`,`quantity` FROM `consumables`";

        PreparedStatement PS = getDbConnection().prepareStatement(sql);

        ResultSet res = PS.executeQuery();

        return res;
    }

    public ResultSet getOrderId(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM `order` WHERE `id` = ?";

        PreparedStatement PS = getDbConnection().prepareStatement(sql);
        PS.setString(1, id);

        ResultSet res = PS.executeQuery();

        return res;
    }

    public ResultSet getOrderCode(String kod) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM `order` WHERE `kod` = ?";

        PreparedStatement PS = getDbConnection().prepareStatement(sql);
        PS.setString(1, kod);

        ResultSet res = PS.executeQuery();

        return res;
    }

    public ResultSet getOrderCodeUser(String kod_user) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM `order` WHERE `kod_user` = ?";

        PreparedStatement PS = getDbConnection().prepareStatement(sql);
        PS.setString(1, kod_user);

        ResultSet res = PS.executeQuery();

        return res;
    }

    public ResultSet getOrderDate(String date) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM `order` WHERE `date` = ?";

        PreparedStatement PS = getDbConnection().prepareStatement(sql);
        PS.setString(1, date);

        ResultSet res = PS.executeQuery();

        return res;
    }

    public void getServerInfo(){
        InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);

        } catch (UnknownHostException e) {

            e.printStackTrace();
        }
    }

    public void createTable() throws SQLException, ClassNotFoundException {
        try {
            String sql2 = "CREATE TABLE `#cache`(id INT PRIMARY KEY AUTO_INCREMENT, date VARCHAR(255));";
            Statement statement = dbconn.createStatement();
            statement.executeUpdate(sql2);

            setCacheDate("");
        }catch (Exception ex){
            System.out.println("Данная таблица уже есть #catch");
        }

    }


    public void deleteTable() throws SQLException, ClassNotFoundException {
        String sql1 = "DROP TABLE `#cache`";
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(sql1);
    }

    public void setCacheDate(String date) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `#cache` (`date`) VALUE (?)";
        PreparedStatement PS = getDbConnection().prepareStatement(sql);
        PS.setString(1, date);
        PS.executeUpdate();
    }

    public String getCacheDate() throws SQLException, ClassNotFoundException {
        String str = "";
        String sql = "SELECT * FROM `#cache`";
        PreparedStatement PS = getDbConnection().prepareStatement(sql);
        ResultSet res = PS.executeQuery();
        while(res.next()){
            str = res.getString(2);
        }

        return str;
    }

}

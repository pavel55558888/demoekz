package com.example.demoekz.database;

import java.sql.*;


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

            java.time.LocalDateTime date_time = java.time.LocalDateTime.now();

            PreparedStatement PS = getDbConnection().prepareStatement(sql);
            PS.setString(1, String.valueOf(date_time));
            PS.setString(2, login);

            PS.executeUpdate();
        }

        public ResultSet getOrder () throws SQLException, ClassNotFoundException {
            String sql = "SELECT * FROM `order`";

            PreparedStatement PS = getDbConnection().prepareStatement(sql);

            ResultSet res = PS.executeQuery();

            return res;
        }

}

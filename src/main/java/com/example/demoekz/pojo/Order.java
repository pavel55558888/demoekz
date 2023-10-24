package com.example.demoekz.pojo;

public class Order {
    private int id;
    private String kod,date,time,kod_user,services,status,date_close,time_drive;

    public Order(int id, String kod, String date, String time, String kod_user, String services, String status, String date_close, String time_drive) {
        this.id = id;
        this.kod = kod;
        this.date = date;
        this.time = time;
        this.kod_user = kod_user;
        this.services = services;
        this.status = status;
        this.date_close = date_close;
        this.time_drive = time_drive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getKod_user() {
        return kod_user;
    }

    public void setKod_user(String kod_user) {
        this.kod_user = kod_user;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate_close() {
        return date_close;
    }

    public void setDate_close(String date_close) {
        this.date_close = date_close;
    }

    public String getTime_drive() {
        return time_drive;
    }

    public void setTime_drive(String time_drive) {
        this.time_drive = time_drive;
    }
}

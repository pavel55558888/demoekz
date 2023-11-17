package com.example.demoekz.pojo;

public class Consumables {
    private String name,date,quantity;

    public Consumables(String name, String date, String quantity) {
        this.name = name;
        this.date = date;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}

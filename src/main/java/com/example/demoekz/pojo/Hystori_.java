package com.example.demoekz.pojo;

public class Hystori_ {
    private String surname,name,lastname,last_output;

    public Hystori_(String surname, String name, String lastname, String last_output) {
        this.surname = surname;
        this.name = name;
        this.lastname = lastname;
        this.last_output = last_output;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLast_output() {
        return last_output;
    }

    public void setLast_output(String last_output) {
        this.last_output = last_output;
    }
}

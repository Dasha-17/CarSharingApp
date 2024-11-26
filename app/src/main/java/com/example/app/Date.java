package com.example.app;

public class Date {
    private String date_rent;
    private int idcar;
    private int idusers;

    public Date(String date_rent, int idcar, int idusers) {

        this.date_rent = date_rent;
        this.idcar = idcar;
        this.idusers = idusers;
    }
    public Date() {}


    public String getDate_rent() {
        return date_rent;
    }

    public int getIdcar() {
        return idcar;
    }

    public int getIdusers() {
        return idusers;
    }


    public void setDate_rent(String date_rent) {
        this.date_rent = date_rent;
    }

    public void setIdcar(int idcar) {
        this.idcar = idcar;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }
}

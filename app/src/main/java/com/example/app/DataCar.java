package com.example.app;

public class DataCar {

    private String a1;
    private int a2;
    private int a4;


    @Override
    public String toString() {
        return a1;
    }

    public DataCar(String a1, int a2, int a4) {
        this.a1 = a1;
        this.a2 = a2;
        this.a4 = a4;

    }
    public DataCar()
    {}


    public String getA1() {
        return a1;
    }

    public int getA2() {
        return a2;
    }

    public void setA4(int a4) {
        this.a4 = a4;
    }

    public int getA4() {
        return a4;

    }
}

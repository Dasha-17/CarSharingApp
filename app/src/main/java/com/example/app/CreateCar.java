package com.example.app;

public class CreateCar {
    private  int Id_test;
    private String Name_test;
    private String amount_of_questions;

    private String price;
   // private String connection;

    @Override
    public String toString() {
        return Name_test;
    }

    public CreateCar(String name_test, String amount_of_questions, String price) {
        this.Name_test = name_test;
        this.amount_of_questions = amount_of_questions;
        this.price = price;
    }

    public CreateCar()
    {}

    //public String getConnection() {
     //   return connection;
   // }

   // public void setConnection(String connection) {
    //    this.connection = connection;
    //}

    public int getId_test() {
        return Id_test;
    }

    public void setId_test(int id_test) {
        Id_test = id_test;
    }
    public String getName_test() {
        return Name_test;
    }

    public void setName_test(String name_test) {
        Name_test = name_test;
    }

    public String getAmount_of_questions() {
        return amount_of_questions;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setAmount_of_questions(String Amount_of_questions) {
        amount_of_questions = Amount_of_questions;
    }

}

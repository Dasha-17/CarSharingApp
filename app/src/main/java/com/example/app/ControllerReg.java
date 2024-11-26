package com.example.app;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class ControllerReg {

    @FXML
    private TextField LastNameText;

    @FXML
    private TextField LogText;

    @FXML
    private TextField NameText;

    @FXML
    private TextField PassText;

    @FXML
    private RadioButton Prvs;

    @FXML
    private Button RegButton;

    @FXML
    private RadioButton Stvs;

    @FXML
    void initialize()
    {

        RegButton.setOnAction(actionEvent -> {
            signUpUser();
                });
        Prvs.setOnAction(actionEvent1 -> Stvs.setSelected(false));
        Stvs.setOnAction(actionEvent1 -> Prvs.setSelected(false));
    }


    private void signUpUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();



        String firstName = NameText.getText();
        String lastName = LastNameText.getText();
        String login = LogText.getText();
        String password = PassText.getText();
        String job = "";

        if(Prvs.isSelected())
            job = "admin";
        else
            job = "client";

        User user = new User(firstName, lastName, login, password, job);
        try {
            dbHandler.signUpUser(user);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        ResultSet result = dbHandler.getUser(user);

        int a = 0;

        while (true)
        {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            a++;
        }
        if(a >= 1)
        {
            RegButton.getScene().getWindow().hide();
            //отображаем нужное окно
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("hello-view.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root)); //указываем необходимое окно, которое нужно загрузить
            stage.show(); //показать и подождать
        }

    }


}


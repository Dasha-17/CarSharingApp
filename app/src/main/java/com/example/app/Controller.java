package com.example.app;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton Pr;

    @FXML
    private ImageView carrr;

    @FXML
    private Button RegButton1;

    @FXML
    private RadioButton St;

    @FXML
    private Button inputButton;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passField;

    @FXML
    void initialize() {

        RegButton1.setOnAction(actionEvent -> {

                RegButton1.getScene().getWindow().hide();
                //отображаем нужное окно
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("registrac.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root)); //указываем необходимое окно, которое нужно загрузить
                stage.showAndWait(); //показать и подождать


        });

        Pr.setOnAction(actionEvent1 -> St.setSelected(false));
        St.setOnAction(actionEvent1 -> Pr.setSelected(false));
        inputButton.setOnAction(actionEvent -> {
            String loginText = loginField.getText().trim(); //трим удаляет ненужные пробелы в строке (если пользователь ввел только пробелы)
            String loginPassword = passField.getText().trim();
            String job = "";
            if(Pr.isSelected()) {
                job = "teacher";
                //St.setSelected(false);
            }
            if(St.isSelected()) {
                job = "student";
                //Pr.setSelected(false);
            }
            //Pr.setOnAction(actionEvent1 -> St.setSelected(false));

            if(!loginText.equals("") && !loginPassword.equals(""))
            {
                loginUser(loginText, loginPassword, job);

            }
            else
                System.out.println("Login and password is empty");



        });
    }
    private void loginUser(String loginText, String loginPassword, String Job)
    {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(loginPassword);
        user.setJob(Job);

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
        if (a >= 1)
        {
            System.out.println("!");
            if (Pr.isSelected()) {
            inputButton.getScene().getWindow().hide();
            //отображаем нужное окно
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("app2.fxml"));

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
            if (St.isSelected()) {
                //Добавить логин в новую базу данных
                //Score score = new Score()
                DatabaseHandler handler = new DatabaseHandler();
                Score score = new Score(loginText);

                try {
                    handler.setScoreNameSt(score);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                //score.setScore();

                inputButton.getScene().getWindow().hide();
                //отображаем нужное окно
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("appStudeent.fxml"));

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
        else {
            Shake logAnim = new Shake(loginField);
            Shake passAnim = new Shake(passField);
            logAnim.playA();
            passAnim.playA();
        }

    }


}

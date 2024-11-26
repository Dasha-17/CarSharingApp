package com.example.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("appClient.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        //stage.setTitle("Hello!r566666");
        stage.setScene(scene);
        stage.show();
        System.out.println("java version: " + System.getProperty("java.version"));
        System.out.println("javafx.version: " + System.getProperty("javafx.version"));


    }

    public static void main(String[] args) {
        launch();
    }
}
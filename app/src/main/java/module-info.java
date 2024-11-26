module com.example.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    //requires mysql.connector.java;


    opens com.example.app to javafx.fxml;
    exports com.example.app;
}
package com.example.app;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerAdmin {

    @FXML
    private Button NewTest;

    @FXML
    private Button Tests;

    @FXML
    private Button Students;

    @FXML
    private Button Esc;

    @FXML
    private Label LableNewTest;

    @FXML
    private Label LableName;

    @FXML
    private TextField TextName;

    @FXML
    private TextField TextNumber;

    @FXML
    private Button Ok;

    @FXML
    private RadioButton vs1;

    @FXML
    private RadioButton vs2;

    @FXML
    private RadioButton vs3;

    @FXML
    private RadioButton vs4;

    @FXML
    private RadioButton vs5;

    @FXML
    private Button Ok2;

    @FXML
    private TextField TextQ;

    @FXML
    private Label LableAnswers;

    @FXML
    private Label LableAnswers1;

    @FXML
    private Label LableNumber;

    @FXML
    private Button Ok3;

    @FXML
    private Button ButtonTest1;

    @FXML
    private Button ButtonTest2;

    @FXML
    private Button ButtonTest3;

    @FXML
    private Button ButtonTest4;

    @FXML
    private Button ButtonTest5;

    @FXML
    private Button ButtonTest6;

    @FXML
    private Button ButtonTest7;

    @FXML
    private Button ButtonTest8;

    @FXML
    private Label LableStudent;

    @FXML
    private Label LableStudent1;

    @FXML
    private Label LableStudent2;

    @FXML
    private Label LableStudent3;

    @FXML
    private Label LableStudent4;

    @FXML
    private Label LableStudent5;

    @FXML
    private Label LableStudent6;

    @FXML
    private Label LableStudent7;

    @FXML
    private Button Esc2;

    int c = 0;

    @FXML
    void initialize() {

        LableNewTest.setVisible(false);
        LableName.setVisible(false);
        LableNumber.setVisible(false);
        TextName.setVisible(false);
        TextNumber.setVisible(false);
        Ok.setVisible(false);

        vs1.setVisible(false);
        vs2.setVisible(false);
        vs3.setVisible(false);
        vs4.setVisible(false);
        vs5.setVisible(false);
        Ok2.setVisible(false);
        LableAnswers.setVisible(false);

        TextQ.setVisible(false);
        Ok3.setVisible(false);

        ButtonTest1.setVisible(false);
        ButtonTest2.setVisible(false);
        ButtonTest3.setVisible(false);
        ButtonTest4.setVisible(false);
        ButtonTest5.setVisible(false);
        ButtonTest6.setVisible(false);
        ButtonTest7.setVisible(false);
        ButtonTest8.setVisible(false);

        LableStudent.setVisible(false);
        LableStudent1.setVisible(false);
        LableStudent2.setVisible(false);
        LableStudent3.setVisible(false);
        LableStudent4.setVisible(false);
        LableStudent5.setVisible(false);
        LableStudent6.setVisible(false);
        LableStudent7.setVisible(false);

        Esc2.setVisible(false);

        Tests.setOnAction(actionEvent -> {
            LableNewTest.setVisible(false);
            LableName.setVisible(false);
            LableNumber.setVisible(false);
            TextName.setVisible(false);
            TextNumber.setVisible(false);
            Ok.setVisible(false);
            vs1.setVisible(false);
            vs2.setVisible(false);
            vs3.setVisible(false);
            vs4.setVisible(false);
            vs5.setVisible(false);
            Ok2.setVisible(false);
            LableAnswers.setVisible(false);
            TextQ.setVisible(false);
           // LableA.setVisible(false);
            Ok3.setVisible(false);
            Esc2.setVisible(false);
            LableStudent.setVisible(false);
            LableStudent1.setVisible(false);
            LableStudent2.setVisible(false);
            LableStudent3.setVisible(false);
            LableStudent4.setVisible(false);
            LableStudent5.setVisible(false);
            LableStudent6.setVisible(false);
            LableStudent7.setVisible(false);

            ButtonTest1.setVisible(true);
            ButtonTest2.setVisible(true);
            ButtonTest3.setVisible(true);
            ButtonTest4.setVisible(true);
            ButtonTest5.setVisible(true);
            ButtonTest6.setVisible(true);
            ButtonTest7.setVisible(true);
            ButtonTest8.setVisible(true);
        });

        SetTextButton(ButtonTest1, ButtonTest2, ButtonTest3, ButtonTest4, ButtonTest5, ButtonTest6, ButtonTest7, ButtonTest8);

        Students.setOnAction(actionEvent -> {
            LableNewTest.setVisible(false);
            LableName.setVisible(false);
            LableNumber.setVisible(false);
            TextName.setVisible(false);
            TextNumber.setVisible(false);
            Ok.setVisible(false);

            vs1.setVisible(false);
            vs2.setVisible(false);
            vs3.setVisible(false);
            vs4.setVisible(false);
            vs5.setVisible(false);
            Ok2.setVisible(false);
            LableAnswers.setVisible(false);

            TextQ.setVisible(false);
            Ok3.setVisible(false);

            ButtonTest1.setVisible(false);
            ButtonTest2.setVisible(false);
            ButtonTest3.setVisible(false);
            ButtonTest4.setVisible(false);
            ButtonTest5.setVisible(false);
            ButtonTest6.setVisible(false);
            ButtonTest7.setVisible(false);
            ButtonTest8.setVisible(false);

            LableStudent.setVisible(true);
            LableStudent1.setVisible(true);
            LableStudent2.setVisible(true);
            LableStudent3.setVisible(true);
            LableStudent4.setVisible(true);
            LableStudent5.setVisible(true);
            LableStudent6.setVisible(true);
            LableStudent7.setVisible(true);
        });

        SetStudents(LableStudent, LableStudent1, LableStudent2, LableStudent3, LableStudent4, LableStudent5, LableStudent6, LableStudent7);

        Esc.setOnAction(actionEvent -> {
                    Esc.getScene().getWindow().hide();
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
                });

        NewTest.setOnAction(actionEvent -> {
            vs1.setVisible(false);
            vs2.setVisible(false);
            vs3.setVisible(false);
            vs4.setVisible(false);
            vs5.setVisible(false);
            Ok2.setVisible(false);
            LableAnswers.setVisible(false);
            TextQ.setVisible(false);
            //LableA.setVisible(false);
            Ok3.setVisible(false);
            ButtonTest1.setVisible(false);
            ButtonTest2.setVisible(false);
            ButtonTest3.setVisible(false);
            ButtonTest4.setVisible(false);
            ButtonTest5.setVisible(false);
            ButtonTest6.setVisible(false);
            ButtonTest7.setVisible(false);
            ButtonTest8.setVisible(false);
            LableStudent.setVisible(false);
            LableStudent1.setVisible(false);
            LableStudent2.setVisible(false);
            LableStudent3.setVisible(false);
            LableStudent4.setVisible(false);
            LableStudent5.setVisible(false);
            LableStudent6.setVisible(false);
            LableStudent7.setVisible(false);

            LableNewTest.setVisible(true);
            LableName.setVisible(true);
            LableNumber.setVisible(true);
            TextName.setVisible(true);
            TextNumber.setVisible(true);
            Ok.setVisible(true);
        });

        Ok.setOnAction(actionEvent -> {


            LableNewTest.setVisible(true);
            LableName.setVisible(true);
            LableNumber.setVisible(true);
            TextName.setVisible(true);
            TextNumber.setVisible(true);
            Ok.setVisible(true);

            vs1.setVisible(true);
            vs2.setVisible(true);
            vs3.setVisible(true);
            vs4.setVisible(true);
            vs5.setVisible(true);
            Ok2.setVisible(true);
            LableAnswers.setVisible(true);

            TextQ.setVisible(false);
            Ok3.setVisible(false);

            Esc2.setVisible(false);
            //String amountQ= TextNumber.getText();
            //System.out.println(amountQ);
        });

        Ok2.setOnAction(actionEvent -> {
            setTest();
            //setQuestions();
            LableAnswers.setVisible(false);
            LableNewTest.setVisible(false);
            LableName.setVisible(false);
            LableNumber.setVisible(false);
            TextName.setVisible(false);
            TextNumber.setVisible(false);
            Ok.setVisible(false);
            LableName.setVisible(false);
            LableNumber.setVisible(false);
            TextName.setVisible(false);
            TextNumber.setVisible(false);
            Ok.setVisible(false);
            vs1.setVisible(false);
            vs2.setVisible(false);
            vs3.setVisible(false);
            vs4.setVisible(false);
            vs5.setVisible(false);
            Ok2.setVisible(false);
            TextQ.setVisible(false);
           // LableA.setVisible(true);
            Ok3.setVisible(false);

            Esc2.setVisible(false);
        });

        Ok3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String  amountQ1= TextNumber.getText();
                String a = amountQ1;
                int b = Integer.parseInt(a);
                c++;
                System.out.println(c);
                if(c >= b){
                    Ok3.setVisible(false);
                    TextQ.setVisible(false);
                  //  LableA.setVisible(false);
                    LableAnswers.setVisible(false);
                }
            }
        });


        Esc2.setOnAction(actionEvent -> {
            LableNewTest.setVisible(false);
            LableName.setVisible(false);
            LableNumber.setVisible(false);
            TextName.setVisible(false);
            TextNumber.setVisible(false);
            Ok.setVisible(false);

            vs1.setVisible(false);
            vs2.setVisible(false);
            vs3.setVisible(false);
            vs4.setVisible(false);
            vs5.setVisible(false);
            Ok2.setVisible(false);
            LableAnswers.setVisible(false);

            TextQ.setVisible(false);
            Ok3.setVisible(false);

            Esc2.setVisible(false);
        });

    }
    private void setTest() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String nameTest = TextName.getText();
        String amountQ = TextNumber.getText();
        String price = "";
        if(vs1.isSelected())
        {
           price = vs1.getText();
        }
        if(vs2.isSelected())
        {
            price = vs2.getText();
        }
        if(vs3.isSelected())
        {
            price = vs3.getText();
        }
        if(vs4.isSelected())
        {
            price = vs4.getText();
        }
        if(vs4.isSelected())
        {
            price = vs5.getText();
        }
        CreateCar tests = new CreateCar(nameTest, amountQ, price);
        try {
            dbHandler.setTests(tests);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
   /* private void setQuestions() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String nameQuestion = TextQ.getText();
        String a1 = TextA1.getText();
        String a2 = TextA2.getText();
        String a3 = TextA3.getText();
        String a4 = TextA4.getText();
        String a5 = TextA5.getText();
        String a6 = TextA6.getText();


        Answers answers = new Answers(nameQuestion, a1, a2, a3, a4, a5, a6);
        //for (int i = 0; i < 2; i++) {
            try {
                dbHandler.setQuestion(answers);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            TextQ.clear();
            TextA1.clear();
            TextA2.clear();
            TextA3.clear();
            TextA4.clear();
            TextA5.clear();
            TextA6.clear();

    }*/

    private void SetTextButton(Button btn1, Button btn2, Button btn3, Button btn4, Button btn5, Button btn6, Button btn7, Button btn8)
    {
        DatabaseHandler handler = new DatabaseHandler();
        String query = "select * from cars";

        try {
            Statement statement = handler.getDbConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT);
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.last();
            CreateCar tests = new CreateCar();
            tests.setName_test(resultSet.getString(2));
            //System.out.println(tests);
            String str = String.valueOf(tests);
            btn1.setText(str);
            resultSet.previous();
            tests.setName_test(resultSet.getString(2));
            str = String.valueOf(tests);
            btn2.setText(str);
            resultSet.previous();
            tests.setName_test(resultSet.getString(2));
            str = String.valueOf(tests);
            btn3.setText(str);
            resultSet.previous();
            tests.setName_test(resultSet.getString(2));
            str = String.valueOf(tests);
            btn4.setText(str);
            resultSet.previous();
            tests.setName_test(resultSet.getString(2));
            str = String.valueOf(tests);
            btn5.setText(str);
            resultSet.previous();
            tests.setName_test(resultSet.getString(2));
            str = String.valueOf(tests);
            btn6.setText(str);
            resultSet.previous();
            tests.setName_test(resultSet.getString(2));
            str = String.valueOf(tests);
            btn7.setText(str);
            resultSet.previous();
            tests.setName_test(resultSet.getString(2));
            str = String.valueOf(tests);
            btn8.setText(str);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void SetStudents(Label label1, Label label2, Label label3, Label label4, Label label5, Label label6, Label label7, Label label8)
    {
        DatabaseHandler handler = new DatabaseHandler();
        String query = "select * from users";

        try {
            Statement statement = handler.getDbConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT);
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.last();
            //Tests tests = new Tests();
            User user = new User();
            user.setLastName(resultSet.getString(3));
            //System.out.println(tests);
            String str = String.valueOf(user);
            label1.setText(str);
            resultSet.previous();
            user.setLastName(resultSet.getString(3));
            str = String.valueOf(user);
            label2.setText(str);
            resultSet.previous();
            user.setLastName(resultSet.getString(3));
            str = String.valueOf(user);
            label3.setText(str);
            resultSet.previous();
            user.setLastName(resultSet.getString(3));
            str = String.valueOf(user);
            label4.setText(str);
            resultSet.previous();
            user.setLastName(resultSet.getString(3));
            str = String.valueOf(user);
            label5.setText(str);
            resultSet.previous();
            user.setLastName(resultSet.getString(3));
            str = String.valueOf(user);
            label6.setText(str);
            resultSet.previous();
            user.setLastName(resultSet.getString(3));
            str = String.valueOf(user);
            label7.setText(str);
            resultSet.previous();
            user.setLastName(resultSet.getString(3));
            str = String.valueOf(user);
            label8.setText(str);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
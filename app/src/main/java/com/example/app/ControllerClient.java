package com.example.app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerClient {

    @FXML
    private Button NewTest;

    @FXML
    private Button Esc;

    @FXML
    private Label LableChooseTest;

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
    private Label LableQuestion;

    @FXML
    private RadioButton vsAn1;

    @FXML
    private RadioButton vsAn2;

    @FXML
    private RadioButton vsAn3;

    @FXML
    private RadioButton vsAn4;

    @FXML
    private RadioButton vsAn5;

    @FXML
    private RadioButton vsAn6;

    @FXML
    private Button NextQ;

    @FXML
    private Button End;

    @FXML
    private Label LableBall1;

    @FXML
    private Label LableBall;


    @FXML
    private Label LableNewTest1;

    @FXML
    void initialize() {
        DatabaseHandler handler1 = new DatabaseHandler();
        String query1 = "select * from question";
        Statement statement1 = null;
        try {
            statement1 = handler1.getDbConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT);
            ResultSet resultSet1 = statement1.executeQuery(query1);
            while (resultSet1.next())
            {
                DataCar dataCar = new DataCar();
               // answers.setQuestionName(resultSet1.getString(3));
                //System.out.println(answers);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        LableChooseTest.setVisible(false);
        ButtonTest1.setVisible(false);
        ButtonTest2.setVisible(false);
        ButtonTest3.setVisible(false);
        ButtonTest4.setVisible(false);
        ButtonTest5.setVisible(false);
        ButtonTest6.setVisible(false);
        ButtonTest7.setVisible(false);
        ButtonTest8.setVisible(false);

        LableQuestion.setVisible(false);
        vsAn1.setVisible(false);
        vsAn2.setVisible(false);
        vsAn3.setVisible(false);
        vsAn4.setVisible(false);
        vsAn5.setVisible(false);
        vsAn6.setVisible(false);
        NextQ.setVisible(false);

        End.setVisible(false);

        LableBall1.setVisible(false);
        LableBall.setVisible(false);

        NewTest.setOnAction(actionEvent -> {
            LableBall1.setVisible(false);
            LableBall.setVisible(false);

            LableChooseTest.setVisible(true);
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

        vsButtom(vsAn1, vsAn2, vsAn3, vsAn4, vsAn5, vsAn6);
        vsButtom(vsAn2, vsAn1, vsAn3, vsAn4, vsAn5, vsAn6);
        vsButtom(vsAn3, vsAn2, vsAn1, vsAn4, vsAn5, vsAn6);
        vsButtom(vsAn4, vsAn2, vsAn3, vsAn1, vsAn5, vsAn6);
        vsButtom(vsAn5, vsAn2, vsAn3, vsAn4, vsAn1, vsAn6);
        vsButtom(vsAn6, vsAn2, vsAn3, vsAn4, vsAn5, vsAn1);

        //DatabaseHandler handler = new DatabaseHandler();


        ButtonTest1.setOnAction(actionEvent -> SetTest(LableQuestion, vsAn1, vsAn2, vsAn3, vsAn4, vsAn5, vsAn6, ButtonTest1, NextQ));
        ButtonTest2.setOnAction(actionEvent -> SetTest(LableQuestion, vsAn1, vsAn2, vsAn3, vsAn4, vsAn5, vsAn6, ButtonTest2, NextQ));
        ButtonTest3.setOnAction(actionEvent -> SetTest(LableQuestion, vsAn1, vsAn2, vsAn3, vsAn4, vsAn5, vsAn6, ButtonTest3, NextQ));
        ButtonTest4.setOnAction(actionEvent -> SetTest(LableQuestion, vsAn1, vsAn2, vsAn3, vsAn4, vsAn5, vsAn6, ButtonTest4, NextQ));
        ButtonTest5.setOnAction(actionEvent -> SetTest(LableQuestion, vsAn1, vsAn2, vsAn3, vsAn4, vsAn5, vsAn6, ButtonTest5, NextQ));
        ButtonTest6.setOnAction(actionEvent -> SetTest(LableQuestion, vsAn1, vsAn2, vsAn3, vsAn4, vsAn5, vsAn6, ButtonTest6, NextQ));
        ButtonTest7.setOnAction(actionEvent -> SetTest(LableQuestion, vsAn1, vsAn2, vsAn3, vsAn4, vsAn5, vsAn6, ButtonTest7, NextQ));
        ButtonTest8.setOnAction(actionEvent -> SetTest(LableQuestion, vsAn1, vsAn2, vsAn3, vsAn4, vsAn5, vsAn6, ButtonTest8, NextQ));

        /*
        SetTest(LableQuestion, vsAn1, vsAn2, vsAn3, vsAn4, vsAn5, vsAn6, ButtonTest2, NewTest);
        SetTest(LableQuestion, vsAn1, vsAn2, vsAn3, vsAn4, vsAn5, vsAn6, ButtonTest3, NewTest);
        SetTest(LableQuestion, vsAn1, vsAn2, vsAn3, vsAn4, vsAn5, vsAn6, ButtonTest4, NewTest);
        SetTest(LableQuestion, vsAn1, vsAn2, vsAn3, vsAn4, vsAn5, vsAn6, ButtonTest5, NewTest);
        SetTest(LableQuestion, vsAn1, vsAn2, vsAn3, vsAn4, vsAn5, vsAn6, ButtonTest6, NewTest);
        SetTest(LableQuestion, vsAn1, vsAn2, vsAn3, vsAn4, vsAn5, vsAn6, ButtonTest7, NewTest);
        SetTest(LableQuestion, vsAn1, vsAn2, vsAn3, vsAn4, vsAn5, vsAn6, ButtonTest8, NewTest);
*/

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



        NextQ.setOnAction(actionEvent -> {
            setDate();
            LableQuestion.setVisible(false);
            vsAn1.setVisible(false);
            vsAn2.setVisible(false);
            vsAn3.setVisible(false);
            vsAn4.setVisible(false);
            vsAn5.setVisible(false);
            vsAn6.setVisible(false);
            NextQ.setVisible(false);
        });
    }

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
    //int y = 1;

    int m = 0;

    String BALL = "";
    int ball = 0;
    public void SetTest (Label label, RadioButton Rb1, RadioButton Rb2, RadioButton Rb3, RadioButton Rb4, RadioButton Rb5, RadioButton Rb6, Button bnt, Button Next) {
        //bnt.setOnAction(actionEvent -> {


                LableChooseTest.setVisible(false);
                ButtonTest1.setVisible(false);
                ButtonTest2.setVisible(false);
                ButtonTest3.setVisible(false);
                ButtonTest4.setVisible(false);
                ButtonTest5.setVisible(false);
                ButtonTest6.setVisible(false);
                ButtonTest7.setVisible(false);
                ButtonTest8.setVisible(false);

                LableQuestion.setVisible(true);
                vsAn1.setVisible(true);
                vsAn2.setVisible(true);
                vsAn3.setVisible(true);
                vsAn4.setVisible(true);
                vsAn5.setVisible(true);
                vsAn6.setVisible(true);
                NextQ.setVisible(true);



    }

    public void vsButtom (RadioButton Rb1, RadioButton Rb2, RadioButton Rb3, RadioButton Rb4, RadioButton Rb5, RadioButton Rb6)
    {
        Rb1.setOnAction(actionEvent -> {
            Rb2.setSelected(false);
            Rb3.setSelected(false);
            Rb4.setSelected(false);
            Rb5.setSelected(false);
            Rb6.setSelected(false);

        });
    }
    public String vsButtom1 (RadioButton Rb1, RadioButton Rb2, RadioButton Rb3, RadioButton Rb4, RadioButton Rb5, RadioButton Rb6)
    {
        Rb1.setOnAction(actionEvent -> {
            Rb2.setSelected(false);
            Rb3.setSelected(false);
            Rb4.setSelected(false);
            Rb5.setSelected(false);
            Rb6.setSelected(false);
        });
        return Rb1.getText();
    }
    public void setDate(){
        DatabaseHandler dbHandler = new DatabaseHandler();
        String date_rent = "";
        if(vsAn1.isSelected())
        {
            date_rent = vsAn1.getText();
        }
        if(vsAn2.isSelected())
        {
            date_rent = vsAn2.getText();
        }
        if(vsAn3.isSelected())
        {
            date_rent = vsAn3.getText();
        }
        if(vsAn4.isSelected())
        {
            date_rent = vsAn4.getText();
        }
        if(vsAn5.isSelected())
        {
            date_rent = vsAn5.getText();
        }
        if(vsAn6.isSelected())
        {
            date_rent = vsAn6.getText();
        }
        int idcar = 6;
        int idusers = 5;

        DataCar date = new DataCar(date_rent, idcar, idusers);

        try {
            dbHandler.setQuestion(date);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
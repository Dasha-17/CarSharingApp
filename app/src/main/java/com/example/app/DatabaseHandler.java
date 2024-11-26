package com.example.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
//для подключения к базе данных
public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
      // String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

       //String connectionString = "jdbc:mysql://" + dbHost + ":"
         //    + dbPort +"/" +dbName/* + "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"*/;
       //
                //строка, в которой будут храниться все данные, которые позволят нам подключиться к базе данных
        String connectionString = "jdbc:mysql://localhost:3306/Irina";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        }catch (SQLException throwables)
        {
            throwables.printStackTrace();
            throw new RuntimeException();
        }

        //dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        //dbConnection.close();

        return dbConnection;
    }
    public  void signUpUser(User user) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + ","
                + Const.USERS_LOGIN + "," + Const.USERS_PASSWORD + "," + Const.USERS_JOB + ")" + "VALUES(?,?,?,?,?)";
    //в этой строке хранится sql запрос, который помещает данные в базу данных
        //выполняем запрос
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getJob());

            preparedStatement.executeUpdate(); //добавить данные
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }
    public ResultSet getUser (User user)
    {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_LOGIN + "=? AND " + Const.USERS_PASSWORD + "=? AND " + Const.USERS_JOB + "=?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getJob());
            resultSet = preparedStatement.executeQuery(); //получить данные
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }
    public  void setTests(CreateCar tests) throws SQLException, ClassNotFoundException {
        String insert1 = "INSERT INTO " + Const.TESTS_TABLE + "(" + Const.TESTS_NAME + "," + Const.TESTS_AMOUNTQ + "," + Const.TESTS_PRICE  + ")" + "VALUES(?,?,?)";
        //в этой строке хранится sql запрос, который помещает данные в базу данных
        //выполняем запрос
        try {
            PreparedStatement preparedStatement1 = getDbConnection().prepareStatement(insert1);
            preparedStatement1.setString(1, tests.getName_test());
            preparedStatement1.setString(2, tests.getAmount_of_questions());
            preparedStatement1.setString(3, tests.getPrice());


            preparedStatement1.executeUpdate(); //добавить данные
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }
    public  void setQuestion(DataCar dataCar) throws SQLException, ClassNotFoundException {
        String insert1 = "INSERT INTO " + Const.QUESTION_TABLE + "("  + Const.QUESTION_A1 + "," + Const.QUESTION_A2  + "," + Const.QUESTION_A4 + ")" + "VALUES(?,?,?)";
        //в этой строке хранится sql запрос, который помещает данные в базу данных
        //выполняем запрос
        try {
            PreparedStatement preparedStatement2 = getDbConnection().prepareStatement(insert1);

            preparedStatement2.setString(1, dataCar.getA1());
            preparedStatement2.setInt(2, dataCar.getA2());
            preparedStatement2.setInt(3, dataCar.getA4());


            //if(answers.getA3() == "")


            preparedStatement2.executeUpdate(); //добавить данные
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    public ResultSet getQuestion (CreateCar tests)
    {
        ResultSet resultSet = null;
        String select1 = "SELECT * FROM " + Const.QUESTION_TABLE +  " WHERE " + Const.QUESTION_A1 + "=? AND " + Const.QUESTION_A2 + "=? AND " + Const.QUESTION_A2 + "=?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select1);
            preparedStatement.setInt(1, tests.getId_test());
            preparedStatement.setString(2, tests.getName_test());
            resultSet = preparedStatement.executeQuery(); //получить данные
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet getTests (CreateCar tests)
    {
        ResultSet resultSet = null;
        String select1 = "SELECT * FROM " + Const.TESTS_TABLE +  " WHERE " + Const.TESTS_ID + "=? AND " + Const.TESTS_NAME + "=?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select1);
            preparedStatement.setInt(1, tests.getId_test());
            preparedStatement.setString(2, tests.getName_test());
            resultSet = preparedStatement.executeQuery(); //получить данные
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }


    public  void setScoreNameSt(Score score) throws SQLException, ClassNotFoundException {
        String insert1 = "INSERT INTO " + Const.SCORE_TABLE + "(" + Const.SCORE_STUDENTN + ")" + "VALUES(?)";
        //в этой строке хранится sql запрос, который помещает данные в базу данных
        //выполняем запрос
        try {
            PreparedStatement preparedStatement1 = getDbConnection().prepareStatement(insert1);
            preparedStatement1.setString(1, score.getStudentName());

            preparedStatement1.executeUpdate(); //добавить данные
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    public  void setScore(Score score) throws SQLException, ClassNotFoundException {
        String insert1 = "INSERT INTO " + Const.SCORE_TABLE + "(" + Const.SCORE_TESTN + "," + Const.SCORE_SCORE + ")" + "VALUES(?,?)";
        //в этой строке хранится sql запрос, который помещает данные в базу данных
        //выполняем запрос
        try {
            PreparedStatement preparedStatement1 = getDbConnection().prepareStatement(insert1);
            preparedStatement1.setString(1, score.getTestName());
            preparedStatement1.setString(2, score.getScore());

            preparedStatement1.executeUpdate(); //добавить данные
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }





}

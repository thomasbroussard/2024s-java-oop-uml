package fr.epita.db;

import fr.epita.files.datamodel.Passenger;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test", "test", "test");
        PreparedStatement createStatement = connection.prepareStatement("CREATE TABLE PASSENGERS (" +
                "name VARCHAR(255), " +
                "age FLOAT, " +
                "pclass VARCHAR(5)," +
                "sex VARCHAR(10)," +
                "survived INT" +
                ")");
        createStatement.execute();

        //becomes the "savePassenger()" method
        Passenger passenger = new Passenger();
        passenger.setName("test");
        passenger.setSex("Male");
        passenger.setpClass("1st");
        passenger.setAge(35.0);
        passenger.setSurvived(0);

        PreparedStatement insertStatement  = connection.prepareStatement("INSERT INTO PASSENGERS (name, age, pclass, sex, survived) VALUES (?, ?, ?, ?, ?)");
        insertStatement.setString(1, passenger.getName());
        insertStatement.setDouble(2, passenger.getAge());
        insertStatement.setString(3, passenger.getpClass());
        insertStatement.setString(4, passenger.getSex());
        insertStatement.setInt(5, passenger.getSurvived());
        insertStatement.execute();


        //becomes the readAll() method
        PreparedStatement selectQueryStatement = connection.prepareStatement("SELECT name FROM PASSENGERS");
        ResultSet resultSet = selectQueryStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));

        }

        resultSet.close();
        selectQueryStatement.close();


    }
}

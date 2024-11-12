package fr.epita.db;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test", "test", "test");
        PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE USERS (name VARCHAR(255))");
        preparedStatement.execute();

        connection.prepareStatement("INSERT INTO USERS");


        PreparedStatement query = connection.prepareStatement("SELECT name FROM USERS");
        ResultSet resultSet = query.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));

        }

        resultSet.close();
        query.close();


    }
}

package fr.epita.db;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test", "test", "test");
        PreparedStatement createStatement = connection.prepareStatement("CREATE TABLE USERS (name VARCHAR(255))");
        createStatement.execute();

        PreparedStatement insertStatement  = connection.prepareStatement("INSERT INTO USERS (name) VALUES ('test')");
        PreparedStatement insertStatement2  = connection.prepareStatement("INSERT INTO USERS (name) VALUES ('test2')");
        insertStatement.execute();
        insertStatement2.execute();


        PreparedStatement selectQueryStatement = connection.prepareStatement("SELECT name FROM USERS");
        ResultSet resultSet = selectQueryStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));

        }

        resultSet.close();
        selectQueryStatement.close();


    }
}

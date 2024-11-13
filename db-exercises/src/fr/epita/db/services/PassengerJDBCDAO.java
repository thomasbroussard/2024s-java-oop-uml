package fr.epita.db.services;

import fr.epita.files.datamodel.Passenger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerJDBCDAO {

    public void save(Passenger passenger) {
        try (Connection connection = getConnection()) {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO PASSENGERS (name, age, pclass, sex, survived) VALUES (?, ?, ?, ?, ?)");
            insertStatement.setString(1, passenger.getName());
            insertStatement.setDouble(2, passenger.getAge());
            insertStatement.setString(3, passenger.getpClass());
            insertStatement.setString(4, passenger.getSex());
            insertStatement.setInt(5, passenger.getSurvived());
            insertStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Passenger> readAll(){
        List<Passenger> passengers = new ArrayList<>();
        //complete here
        return passengers;
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test", "test", "test");
    }

}

package fr.epita.db.services;

import fr.epita.db.services.exceptions.UnableToSavePassengerException;
import fr.epita.files.datamodel.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerJDBCDAO {

    public static final String SELECT_PASSENGER_QUERY = "SELECT name, age, pclass, sex, survived FROM PASSENGERS";
    public static final String DELETE_PASSENGER = "DELETE FROM PASSENGERS WHERE name = ?";

    public PassengerJDBCDAO(){
        try (Connection connection = getConnection()){
            PreparedStatement createStatement = connection.prepareStatement("CREATE TABLE PASSENGERS (" +
                    "name VARCHAR(255), " +
                    "age FLOAT, " +
                    "pclass VARCHAR(5)," +
                    "sex VARCHAR(10)," +
                    "survived INT" +
                    ")");
            createStatement.execute();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

    }

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
            throw new UnableToSavePassengerException();
        }
    }

    public List<Passenger> readAll() {
        List<Passenger> passengers = new ArrayList<>();
        //becomes the readAll() method
        try (Connection connection = getConnection()) {
            PreparedStatement selectQueryStatement = connection.prepareStatement(SELECT_PASSENGER_QUERY);
            ResultSet resultSet = selectQueryStatement.executeQuery();
            while (resultSet.next()) {
                Passenger passenger = new Passenger();
                passenger.setSurvived(resultSet.getInt("survived"));
                passenger.setName(resultSet.getString("name"));
                passenger.setpClass(resultSet.getString("pclass"));
                passenger.setSex(resultSet.getString("sex"));
                passenger.setAge(resultSet.getDouble("age"));
                passengers.add(passenger);
            }

            resultSet.close();
            selectQueryStatement.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return passengers;
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "test", "test");
    }

    public void delete(Passenger passenger) {
        try (Connection connection = getConnection()) {
            PreparedStatement deleteStatement = connection.prepareStatement(DELETE_PASSENGER);
            deleteStatement.setString(1, passenger.getName());
            deleteStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

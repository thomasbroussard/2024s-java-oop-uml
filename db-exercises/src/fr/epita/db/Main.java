package fr.epita.db;

import fr.epita.db.services.PassengerJDBCDAO;
import fr.epita.files.datamodel.Passenger;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        //becomes the "savePassenger()" method
        Passenger passenger = new Passenger();
        passenger.setName("test");
        passenger.setSex("Male");
        passenger.setpClass("1st");
        passenger.setAge(35.0);
        passenger.setSurvived(0);

        PassengerJDBCDAO dao = new PassengerJDBCDAO();
        dao.save(passenger);

        List<Passenger> passengers = dao.readAll();
        System.out.println(passengers);

        dao.delete(passenger);

    }
}

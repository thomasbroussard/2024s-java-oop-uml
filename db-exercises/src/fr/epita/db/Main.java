package fr.epita.db;

import fr.epita.db.services.PassengerJDBCDAO;
import fr.epita.db.services.exceptions.UnableToSavePassengerException;
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
        try {
            dao.save(passenger);
        } catch (UnableToSavePassengerException exception){
            System.out.println("the passenger was unfortunately not saved in the system");
        }

        List<Passenger> passengers = dao.readAll();
        System.out.println(passengers);

        dao.delete(passenger);

    }
}

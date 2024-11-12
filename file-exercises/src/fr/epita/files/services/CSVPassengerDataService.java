package fr.epita.files.services;

import fr.epita.files.datamodel.Passenger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CSVPassengerDataService {


    public static final String OUTPUT_DELIMITER = ";";
    public static final String INPUT_DELIMITER = ";";

    public static List<Passenger> extractPassengers(File csvFile) throws IOException {
        List<Passenger> passengers = new ArrayList<>();
        List<String> lines = Files.readAllLines(csvFile.toPath());
        System.out.println(lines.get(0));
        lines.remove(0);
        System.out.println(lines.get(0));

        List<String> errors = new ArrayList<>();
        for (String line : lines){
            System.out.println(line);
            try {
                String[] passengerParts = line.split(INPUT_DELIMITER);
                Passenger passenger = new Passenger();
                //Name ;PClass;Age ;Sex   ;Survived
                passenger.setName(passengerParts[0].trim());
                passenger.setpClass(passengerParts[1].trim());
                passenger.setAge(Double.parseDouble(passengerParts[2].trim()));
                passenger.setSex(passengerParts[3]);
                passenger.setSurvived(Integer.parseInt(passengerParts[4].trim()));
                passengers.add(passenger);
            } catch (Exception e){
                errors.add(line);
                System.out.println(e.getMessage());
            }
        }
        System.out.println("passenger size: " + passengers.size());
        System.out.println("errors size: " +errors.size());
        return passengers;
    }

    public static void writeListToFile(List<Passenger> passengers, File outputFile) throws IOException {
        List<String> lines = new ArrayList<>();

        // Add the header line (assuming same format as extractPassengers)
        lines.add("Name;Age;PClass;Sex;Survived");

        // Create each passenger's line
        for (Passenger passenger : passengers) {
            String line = passenger.getName() + OUTPUT_DELIMITER
                    + passenger.getAge() + OUTPUT_DELIMITER
                    + passenger.getpClass() + OUTPUT_DELIMITER
                    + passenger.getSex() + OUTPUT_DELIMITER
                    + passenger.getSurvived();
            lines.add(line);
        }

        // Write all lines to the file at once
        Files.write(outputFile.toPath(), lines);
    }

    public static void writeListToHtmlFile(List<Passenger> passengers, File outputFile) throws IOException {
        List<String> lines = new ArrayList<>();

        // Add HTML header and basic styling
        lines.add("<html>");
        lines.add("<head><style>");
        lines.add("table { width: 100%; border-collapse: collapse; }");
        lines.add("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
        lines.add("th { background-color: #f2f2f2; color: #333; }");
        lines.add("tr:nth-child(even) { background-color: #f9f9f9; }");
        lines.add("tr:hover { background-color: #ddd; }");
        lines.add("</style></head>");
        lines.add("<body>");

        // Table header
        lines.add("<h2>Passenger List</h2>");
        lines.add("<table>");
        lines.add("<tr><th>Name</th><th>Class</th><th>Age</th><th>Sex</th><th>Survived</th></tr>");

        // Table rows for each passenger
        for (Passenger passenger : passengers) {
            lines.add("<tr>"
                    + "<td>" + passenger.getName() + "</td>"
                    + "<td>" + passenger.getpClass() + "</td>"
                    + "<td>" + passenger.getAge() + "</td>"
                    + "<td>" + passenger.getSex() + "</td>"
                    + "<td>" + (passenger.getSurvived() == 1 ? "Yes" : "No") + "</td>"
                    + "</tr>");
        }

        // Closing tags
        lines.add("</table>");
        lines.add("</body>");
        lines.add("</html>");

        // Write all lines to the file at once
        Files.write(outputFile.toPath(), lines);
    }




}

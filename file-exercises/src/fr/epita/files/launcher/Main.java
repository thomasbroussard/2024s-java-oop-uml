package fr.epita.files.launcher;

import fr.epita.files.datamodel.Passenger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        File csvFile = new File("./file-exercises/data.csv");
        System.out.println(csvFile.exists());

        try {
            List<String> lines = Files.readAllLines(csvFile.toPath());
            System.out.println(lines.get(0));
            lines.remove(0);
            System.out.println(lines.get(0));
            List<Passenger> passengers = new ArrayList<>();
            List<String> errors = new ArrayList<>();
            for (String line : lines){
                System.out.println(line);
                try {
                    String[] passengerParts = line.split(";");
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
            System.out.println("passenger size: " +passengers.size());
            System.out.println("errors size: " +errors.size());

            double avgAge = getAvgAge(passengers);



            System.out.println("average age" + avgAge);

            List<Passenger> survivors = passengers.stream().filter(p -> p.getSurvived() == 1).toList();
            List<Passenger> notSurvived = queryList(passengers, p -> p.getSurvived() == 0);

            List<Passenger> passengersFromFirstClass = queryList(passengers, p -> p.getpClass().equals("1st"));
            //is equivalent to the following:
            List<Passenger> passengersFromFirstClass2 = queryList(passengers, new Predicate<Passenger>() {
                @Override
                public boolean test(Passenger p) {
                   return p.getpClass().equals("1st");
                }
            });

            System.out.println("survived: " + survivors.size());
            System.out.println("not survived: " + notSurvived.size());

            Set<Object> valuesForPclass = computeUniqueValues(passengers, Passenger::getpClass);
            Set<Object> valuesForSurvived = computeUniqueValues(passengers, Passenger::getSurvived);



            System.out.println(valuesForPclass);
            System.out.println(valuesForSurvived);

        } catch (IOException ioe){
            ioe.printStackTrace();
            return;
        }
    }

    private static Set<Object> computeUniqueValues(List<Passenger> passengers, Function<Passenger, Object> transformationFunction) {
        Set<Object> stringSet = new HashSet<>();

        for (Passenger passenger : passengers){
            stringSet.add(transformationFunction.apply(passenger));
        }
        return stringSet;
    }

    private static List<Passenger> queryList(List<Passenger> passengers, Predicate<Passenger> passengerPredicate) {
        return passengers.stream().filter(passengerPredicate).toList();
    }

    private static double getAvgAge(List<Passenger> passengers) {
        double avgAge = 0.0;
        for (Passenger p : passengers){
            avgAge += p.getAge();
        }
        avgAge = avgAge / passengers.size();
        return avgAge;
    }
}
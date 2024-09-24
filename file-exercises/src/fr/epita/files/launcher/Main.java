package fr.epita.files.launcher;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File csvFile = new File("./file-exercises/titanic_train.csv");
        System.out.println(csvFile.exists());

        try {
            List<String> lines = Files.readAllLines(csvFile.toPath());
            System.out.println(lines.get(0));
            lines.remove(0);
            System.out.println(lines.get(0));
        } catch (IOException ioe){
            ioe.printStackTrace();
            return;
        }


    }
}
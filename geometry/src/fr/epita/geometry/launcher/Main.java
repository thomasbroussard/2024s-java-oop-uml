package fr.epita.geometry.launcher;

import fr.epita.geometry.datamodel.Circle;
import fr.epita.geometry.datamodel.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Triangle> triangles =  new ArrayList<>();

        for (int i = 0; i < 1000000; i++){
            Triangle triangle = new Triangle(1 + i,2+i,3+i,4+i);
            triangles.add(triangle);
            // System.out.println(triangleArea);
            // System.out.println(trianglePerimeter);
        }





        Circle circle = new Circle(2);

        double circleArea = circle.calculateArea();
        double circlePerimeter = circle.calculatePerimeter();

        System.out.println(circleArea);
        System.out.println(circlePerimeter);



    }
}
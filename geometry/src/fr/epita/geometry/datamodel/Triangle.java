package fr.epita.geometry.datamodel;

import java.util.ArrayList;
import java.util.List;

public class Triangle implements Shape {
    private final double height;
    private double base;
    private double sideA;
    private double sideB;

    public Triangle(double height, double base, double sideA, double sideB) {
        this.height = height;
        this.base = base;
        this.sideA = sideA;
        this.sideB = sideB;
    }

    double totalTriangleArea =

    public double calculateArea(){
        return this.base * this.height / 2;
    }
    public double calculatePerimeter(){
        return this.base + this.sideB + this.sideA;
    }


}

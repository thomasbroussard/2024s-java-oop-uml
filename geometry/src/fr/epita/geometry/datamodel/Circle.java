package fr.epita.geometry.datamodel;

public class Circle {

    private double radius;


    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculatePerimeter(){
        return 2 *  this.radius * Math.PI;
    }

    public double calculateArea(){
        return  Math.pow(this.radius,2)  * Math.PI;
    }
}

package fr.epita.geometry.datamodel;

public class Square implements Shape {
    private double side;

    public Square(double side){
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return this.side * this.side;
    }

    @Override
    public double calculatePerimeter() {
        return this.side * 4;
    }
}

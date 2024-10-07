package fr.epita.files.datamodel;

public class Passenger {

    private int passengerId;
    private int survived;
    private String pClass;
    private String name;
    private String sex;
    private double age;
    private int siblingAndSpouses;
    private int parentAndChildren;
    private String ticket;
    private Double fare;
    private String cabin;
    private String embarked;

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getSurvived() {
        return survived;
    }

    public void setSurvived(int survived) {
        this.survived = survived;
    }

    public String getpClass() {
        return pClass;
    }

    public void setpClass(String pClass) {
        this.pClass = pClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public int getSiblingAndSpouses() {
        return siblingAndSpouses;
    }

    public void setSiblingAndSpouses(int siblingAndSpouses) {
        this.siblingAndSpouses = siblingAndSpouses;
    }

    public int getParentAndChildren() {
        return parentAndChildren;
    }

    public void setParentAndChildren(int parentAndChildren) {
        this.parentAndChildren = parentAndChildren;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getEmbarked() {
        return embarked;
    }

    public void setEmbarked(String embarked) {
        this.embarked = embarked;
    }
}

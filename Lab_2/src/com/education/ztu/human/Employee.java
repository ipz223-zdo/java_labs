package com.education.ztu.human;

import com.education.ztu.Gender;
import com.education.ztu.Location;
import com.education.ztu.car.Car;

public class Employee extends Person {
    private Car car;
    private String company;
    private String position;

    public Employee(String firstname, String lastname, int age, Gender gender, Location location, Car car, String company, String position) {
        super(firstname, lastname, age, gender, location);
        this.car = car;
        this.company = company;
        this.position = position;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public void getOccupation() {
        System.out.println("I am an employee.");
    }

    @Override
    public String getFullInfo() {
        return super.getFullInfo() + " working at " + company + " as a " + position;
    }
}

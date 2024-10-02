package com.education.ztu.human;

import com.education.ztu.Gender;
import com.education.ztu.Location;
import com.education.ztu.car.Car;

public class Teacher extends Person {
    private Car car;
    private String subject;
    private String university;

    public Teacher(String firstname, String lastname, int age, Gender gender, Location location, Car car, String subject, String university) {
        super(firstname, lastname, age, gender, location);
        this.car = car;
        this.subject = subject;
        this.university = university;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public void getOccupation() {
        System.out.println("I am a teacher.");
    }

    @Override
    public String getFullInfo() {
        return super.getFullInfo() + " teaching " + subject + " at " + university;
    }
}

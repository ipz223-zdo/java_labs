package com.education.ztu.human;

import com.education.ztu.Gender;
import com.education.ztu.Location;

public abstract class Person implements Human {
    protected int age;
    protected String firstname;
    protected String lastname;
    protected Gender gender;
    protected Location location;

    protected static int counter;

    public Person() {
        this("John", "Doe", 18, Gender.MALE, Location.KIEV);
    }

    public Person(String firstname, String lastname, int age, Gender gender, Location location) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.location = location;
        counter++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public abstract void getOccupation();

    public String getFullInfo() {
        return firstname + " " + lastname + ", " + age + " years old, from " + location;
    }

    @Override
    public void sayAge() {
        System.out.println("I am " + age + " years old.");
    }

    @Override
    public void sayGender() {
        System.out.println("My gender is " + gender);
    }

    @Override
    public void sayLocation() {
        System.out.println("I am from " + location);
    }

    @Override
    public void sayName() {
        System.out.println("My name is " + firstname + " " + lastname);
    }

    public static void showCounter() {
        System.out.println("Total persons: " + counter);
    }
}


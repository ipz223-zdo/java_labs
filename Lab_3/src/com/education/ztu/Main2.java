package com.education.ztu;

import com.education.ztu.game.*;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        // Створення учасників
        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Mariya", 15);
        Student student1 = new Student("Mykola", 20);
        Student student2 = new Student("Viktoria", 21);
        Employee employee1 = new Employee("Andriy", 28);
        Employee employee2 = new Employee("Oksana", 25);

        // Створення команд
        Team<Schoolar> scollarTeam = new Team<>("Dragon");
        scollarTeam.addNewParticipant(schoolar1);
        scollarTeam.addNewParticipant(schoolar2);

        Team<Student> studentTeam = new Team<>("Vpered");
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        Team<Employee> employeeTeam = new Team<>("Robotyagi");
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        // Створення списку учасників для сортування
        List<Participant> allParticipants = new ArrayList<>();
        allParticipants.add(schoolar1);
        allParticipants.add(schoolar2);
        allParticipants.add(student1);
        allParticipants.add(student2);
        allParticipants.add(employee1);
        allParticipants.add(employee2);

        // Сортування учасників за іменем
        System.out.println("Sorting participants by name:");
        Collections.sort(allParticipants);
        allParticipants.forEach(p -> System.out.println(p.getName() + " - Age: " + p.getAge()));

        // Сортування учасників за віком
        System.out.println("\nSorting participants by age:");
        Collections.sort(allParticipants, new AgeComparator());
        allParticipants.forEach(p -> System.out.println(p.getName() + " - Age: " + p.getAge()));

        // Сортування учасників за іменем та віком (Java 8)
        System.out.println("\nSorting participants by name and age:");
        Collections.sort(allParticipants, new NameAndAgeComparator());
        allParticipants.forEach(p -> System.out.println(p.getName() + " - Age: " + p.getAge()));
    }
}

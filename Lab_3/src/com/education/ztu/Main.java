package com.education.ztu;

import com.education.ztu.game.Schoolar;
import com.education.ztu.game.Team;

public class Main {

    public static void main(String[] args) {
        // Створення учасників
        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Mariya", 15);

        // Створення команди
        Team<Schoolar> scollarTeam = new Team<>("Dragon");
        scollarTeam.addNewParticipant(schoolar1);
        scollarTeam.addNewParticipant(schoolar2);

        // Демонстрація клону
        Team<Schoolar> clonedTeam = scollarTeam.deepClone();
        System.out.println("Original Team: " + scollarTeam);
        System.out.println("Cloned Team: " + clonedTeam);

        // Перевірка equals та hashCode
        System.out.println("Teams are equal: " + scollarTeam.equals(clonedTeam));
        System.out.println("Original Team hashCode: " + scollarTeam.hashCode());
        System.out.println("Cloned Team hashCode: " + clonedTeam.hashCode());
    }
}

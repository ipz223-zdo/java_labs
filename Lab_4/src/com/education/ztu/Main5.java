package com.education.ztu;

import java.time.*;

public class Main5 {
    public static void main(String[] args) {
        // 1. Створення об'єкта LocalDateTime для початку лабораторної
        LocalDateTime labStart = LocalDateTime.of(2024, 11, 21, 16, 0, 0);

        // 2. Виведення інформації про дату та час
        System.out.println("Дата початку лабораторної: " + labStart);

        // День тижня
        System.out.println("День тижня: " + labStart.getDayOfWeek());

        // День року
        System.out.println("День року: " + labStart.getDayOfYear());

        // Місяць
        System.out.println("Місяць: " + labStart.getMonth());

        // Рік
        System.out.println("Рік: " + labStart.getYear());

        // Години
        System.out.println("Години: " + labStart.getHour());

        // Хвилини
        System.out.println("Хвилини: " + labStart.getMinute());

        // Секунди
        System.out.println("Секунди: " + labStart.getSecond());

        // 3. Перевірка, чи рік високосний
        boolean isLeapYear = labStart.toLocalDate().isLeapYear();
        System.out.println("Високосний рік: " + isLeapYear);

        // 4. Поточний час
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("\nПоточний час: " + currentTime);

        // 5. Порівняння дат
        if (currentTime.isAfter(labStart)) {
            System.out.println("Поточний час після початку лабораторної.");
        } else if (currentTime.isBefore(labStart)) {
            System.out.println("Поточний час до початку лабораторної.");
        }

        // 6. Зміна елементів дати та часу
        LocalDateTime modifiedDateTime = labStart
                .withYear(2025) // змінюємо рік
                .withMonth(12)  // змінюємо місяць
                .withDayOfMonth(25) // змінюємо день
                .withHour(15)   // змінюємо години
                .withMinute(30); // змінюємо хвилини

        System.out.println("\nМодифікована дата та час: " + modifiedDateTime);
    }
}

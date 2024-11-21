package com.education.ztu;

public class Main {
    public static void main(String[] args) {
        String input = "I learn Java!!!";
        processString(input);
    }

    public static void processString(String input) {
        // Роздрукувати останній символ рядка
        System.out.println("Останній символ рядка: " + input.charAt(input.length() - 1));

        // Перевірити, чи закінчується рядок підрядком "!!!"
        System.out.println("Рядок закінчується на '!!!': " + input.endsWith("!!!"));

        // Перевірити, чи починається рядок підрядком "I learn "
        System.out.println("Рядок починається з 'I learn ': " + input.startsWith("I learn "));

        // Перевірити, чи містить рядок підрядок "Java"
        System.out.println("Рядок містить 'Java': " + input.contains("Java"));

        // Знайти позицію підрядка "Java"
        System.out.println("Позиція 'Java': " + input.indexOf("Java"));

        // Замінити всі символи "а" на "о"
        String replacedString = input.replace('a', 'o');
        System.out.println("Рядок після заміни 'а' на 'о': " + replacedString);

        // Перетворити рядок на верхній регістр
        System.out.println("Рядок у верхньому регістрі: " + input.toUpperCase());

        // Перетворити рядок на нижній регістр
        System.out.println("Рядок у нижньому регістрі: " + input.toLowerCase());

        // Вирізати підрядок "Java"
        String substring = input.substring(input.indexOf("Java"), input.indexOf("Java") + 4);
        System.out.println("Вирізаний підрядок 'Java': " + substring);
    }
}

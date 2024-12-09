package com.education.ztu;

import java.util.Scanner;

public class ReaderPrinterExample {
    // Спільна змінна для зберігання рядка
    private static String sharedString = "";
    private static boolean exitFlag = false;

    // Об'єкт для синхронізації
    private static final Object lock = new Object();

    public static class Reader extends Thread {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                synchronized (lock) {  // синхронізація через окремий об'єкт
                    System.out.println("Введіть рядок (або 'exit' для завершення): ");
                    String input = scanner.nextLine();

                    if (input.equalsIgnoreCase("exit")) {
                        exitFlag = true;  // Встановлюємо флаг завершення
                        lock.notifyAll();  // Сповіщаємо потік Printer
                        break;  // Завершуємо програму
                    }

                    // Записуємо введене значення в sharedString
                    sharedString = input;

                    // Сповіщаємо потік Printer
                    lock.notifyAll();

                    try {
                        // Засипаємо потік Reader на 1 секунду
                        lock.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            scanner.close();
        }
    }

    public static class Printer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {  // синхронізація через окремий об'єкт
                    try {
                        // Очікуємо, поки Reader запише дані
                        while (sharedString.isEmpty()) {
                            lock.wait();
                        }

                        // Виводимо значення з sharedString
                        System.out.println("Виведений рядок: " + sharedString);

                        // Сповіщаємо потік Reader, що ми завершили виведення
                        lock.notifyAll();

                        // Якщо flag завершення встановлений і sharedString порожній, виводимо результат і завершуємо
                        if (exitFlag) {
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Створення та запуск потоків
        Reader readerThread = new Reader();
        Printer printerThread = new Printer();

        readerThread.start();
        printerThread.start();
    }
}

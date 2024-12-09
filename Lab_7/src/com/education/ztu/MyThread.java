package com.education.ztu;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Я люблю програмувати!!! (" + i + ")");
        }
    }

    public static void main(String[] args) {
        // Створення екземпляра MyThread
        MyThread myThread = new MyThread();

        // Стан NEW
        System.out.println("Стан потоку після створення: " + myThread.getState());

        // Запуск потоку
        myThread.start();

        // Стан RUNNABLE
        System.out.println("Стан потоку після запуску: " + myThread.getState());
        System.out.println("Ім'я потоку: " + myThread.getName());
        System.out.println("Пріорітет потоку: " + myThread.getPriority());
        System.out.println("Чи потік живий: " + myThread.isAlive());
        System.out.println("Чи потік демон: " + myThread.isDaemon());

        // Зміна параметрів потоку
        myThread.setName("MyProgrammingThread");
        myThread.setPriority(Thread.MAX_PRIORITY);

        // Виведення оновлених параметрів
        System.out.println("Оновлене ім'я потоку: " + myThread.getName());
        System.out.println("Оновлений пріорітет потоку: " + myThread.getPriority());

        // Очікування завершення потоку
        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Стан TERMINATED
        System.out.println("Стан потоку після завершення: " + myThread.getState());

        // Інформація про головний потік
        Thread mainThread = Thread.currentThread();
        System.out.println("Ім'я головного потоку: " + mainThread.getName());
        System.out.println("Пріорітет головного потоку: " + mainThread.getPriority());
    }
}

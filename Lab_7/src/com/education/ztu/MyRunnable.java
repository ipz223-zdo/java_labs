package com.education.ztu;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        // Перевірка переривання потоку у циклі
        for (int i = 0; i <= 10000; i++) {
            if (Thread.interrupted()) {
                System.out.println("Розрахунок завершено!!!");
                return;
            }
            if (i % 10 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        // Створення трьох потоків
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        Thread thread3 = new Thread(myRunnable);

        // Запуск потоків
        thread1.start();
        thread2.start();
        thread3.start();

        // Головний потік робить паузу на 2 секунди
        try {
            // Переривання потоків
            Thread.sleep(2000);
            thread1.interrupt();
            thread2.interrupt();
            thread3.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

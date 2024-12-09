package com.education.ztu;

public class MyRunnable2 implements Runnable{
    // Статична змінна для збереження значення арифметичної прогресії
    private static int result = 1;

    // Синхронізований метод для коректної роботи з result
    private synchronized static void addToResult() {
        System.out.print(result + " ");
        result++;
    }

    @Override
    public void run() {
        // Цикл для виведення арифметичної прогресії
        for (int i = 0; i < 100; i++) {
            addToResult();
            try {
                // Чекати 0,2 секунди
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Створення об'єктів потоку
        MyRunnable2 myRunnable = new MyRunnable2();

        // Створення трьох потоків
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        Thread thread3 = new Thread(myRunnable);

        // Запуск потоків
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

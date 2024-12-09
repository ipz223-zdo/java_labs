package com.education.ztu;

public class MyRunnable3 implements Runnable {
    // Статична змінна для збереження значення арифметичної прогресії
    private static int result = 1;

    // Блок синхронізації для доступу до спільної змінної result
    private static void addToResult() {
        synchronized (MyRunnable3.class) {
            System.out.print(result + " ");
            result++;
        }
    }

    @Override
    public void run() {
        // Цикл для виведення арифметичної прогресії
        for (int i = 0; i < 10; i++) {
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
        MyRunnable3 myRunnable = new MyRunnable3();

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

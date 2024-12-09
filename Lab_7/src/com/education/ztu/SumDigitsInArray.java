package com.education.ztu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumDigitsInArray {
    // Розмір масиву
    private static final int ARRAY_SIZE = 1000000;

    public static void main(String[] args) {
        // Створюємо масив
        int[] array = new int[ARRAY_SIZE];
        fillArrayWithRandomNumbers(array);

        // 1. Однопотокове виконання
        long startTime = System.currentTimeMillis();
        long sumSingleThread = sumDigitsSingleThread(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Однопотокова сума цифр: " + sumSingleThread);
        System.out.println("Час виконання однопотокового режиму: " + (endTime - startTime) + " мс");

        // 2. Багатопотокове виконання
        startTime = System.currentTimeMillis();
        long sumMultiThread = sumDigitsMultiThread(array);
        endTime = System.currentTimeMillis();
        System.out.println("Багатопотокова сума цифр: " + sumMultiThread);
        System.out.println("Час виконання багатопотокового режиму: " + (endTime - startTime) + " мс");
    }

    // Заповнення масиву випадковими числами
    public static void fillArrayWithRandomNumbers(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100); // Випадкове число від 0 до 99
        }
    }

    // Обчислення суми цифр масиву в однопотоковому режимі
    public static long sumDigitsSingleThread(int[] array) {
        long sum = 0;
        for (int num : array) {
            sum += sumDigits(num);
        }
        return sum;
    }

    // Обчислення суми цифр для одного числа
    public static int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // Обчислення суми цифр масиву в багатопотоковому режимі
    public static long sumDigitsMultiThread(int[] array) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        int chunkSize = array.length / 5; // Розподіляємо масив на 5 частин

        // Список для збереження Future результатів
        long totalSum = 0;
        try {
            // Створюємо Callable завдання для кожного потоку
            List<Callable<Long>> tasks = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                int start = i * chunkSize;
                int end = (i + 1) * chunkSize;
                if (i == 4) { // Для останнього потоку беремо залишок
                    end = array.length;
                }
                tasks.add(new SumDigitsTask(array, start, end));
            }

            // Виконуємо всі завдання й отримуємо результат
            List<Future<Long>> results = executor.invokeAll(tasks);

            // Сумуємо всі часткові результати
            for (Future<Long> result : results) {
                totalSum += result.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        return totalSum;
    }

    // Завдання для обчислення суми цифр в частині масиву
    public static class SumDigitsTask implements Callable<Long> {
        private final int[] array;
        private final int start;
        private final int end;

        public SumDigitsTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public Long call() throws Exception {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += sumDigits(array[i]);
            }
            return sum;
        }
    }
}

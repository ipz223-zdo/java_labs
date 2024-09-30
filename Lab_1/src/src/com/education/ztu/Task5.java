package com.education.ztu;

import java.util.Scanner;

public class Task5 {
    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ціле позитивне число: ");
        int num = scanner.nextInt();

        int result = sumOfDigits(num);

        System.out.println("Сума цифр числа: " + result);
    }
}

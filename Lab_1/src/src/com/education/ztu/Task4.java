package com.education.ztu;

import java.util.Scanner;

public class Task4 {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть перше число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введіть друге число: ");
        int num2 = scanner.nextInt();

        int result = gcd(num1, num2);

        System.out.println("Найбільший спільний дільник: " + result);
    }
}

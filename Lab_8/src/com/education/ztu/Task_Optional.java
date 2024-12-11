package com.education.ztu;

import java.util.Arrays;
import java.util.Optional;

public class Task_Optional {

    public static void main(String[] args) {
        int[] numbers = {2, 3, 5, 3, 0, 1, 7, 1, 5, 4}; // Масив чисел, змінюйте його для перевірки

        Optional<Integer> max = Arrays.stream(numbers)  // Створюємо потік з масиву
                .boxed()  // Перетворюємо int в Integer для використання з Optional
                .max(Integer::compareTo);  // Знаходимо максимальне значення

        // Використовуємо метод orElse, щоб повернути повідомлення, якщо значення відсутнє
        String result = max.map(String::valueOf).orElse("Числа відсутні");

        System.out.println(result);
    }
}

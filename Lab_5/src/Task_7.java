import com.education.ztu.Product;

import java.util.*;

public class Task_7 {
    public static void main(String[] args) {
        // 1. Масив, створений через Arrays.asList
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 4, 2, 1, 5));
        System.out.println("Оригінальний список: " + numbers);

        // 2. Метод Collections.sort()
        Collections.sort(numbers);
        System.out.println("Відсортований список: " + numbers);

        // 3. Метод Collections.binarySearch()
        int index = Collections.binarySearch(numbers, 3);
        System.out.println("Індекс елемента 3: " + index);

        // 4. Методи Collections.reverse(), Collections.shuffle()
        Collections.reverse(numbers);
        System.out.println("Реверсований список: " + numbers);
        Collections.shuffle(numbers);
        System.out.println("Перемішаний список: " + numbers);

        // 5. Метод Collections.fill()
        Collections.fill(numbers, 9);
        System.out.println("Список після fill: " + numbers);

        // 6. Методи Collections.max(), Collections.min()
        numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int max = Collections.max(numbers);
        int min = Collections.min(numbers);
        System.out.println("Максимум: " + max + ", Мінімум: " + min);

        // 7. Метод Collections.copy()
        List<Integer> copyList = new ArrayList<>(Arrays.asList(new Integer[numbers.size()]));
        Collections.copy(copyList, numbers);
        System.out.println("Скопійований список: " + copyList);

        // 8. Метод Collections.rotate()
        Collections.rotate(numbers, 2);
        System.out.println("Список після обертання на 2 позиції: " + numbers);

        // 9. Метод Collections.checkedCollection()
        Collection<Integer> checkedNumbers = Collections.checkedCollection(numbers, Integer.class);
        try {
            // checkedNumbers.add("String"); // Це викличе помилку компіляції
            System.out.println("Checked Collection працює коректно.");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // 10. Метод Collections.frequency()
        int frequency = Collections.frequency(numbers, 3);
        System.out.println("Частота елемента 3: " + frequency);
    }
}
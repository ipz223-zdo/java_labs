import com.education.ztu.Product;

import java.util.*;

public class Task_5 {
    public static void main(String[] args) {
        // Створюємо множину з використанням TreeSet
        TreeSet<Product> productSet = new TreeSet<>(Comparator.comparing(Product::getPrice));

        // 1. Додавання елементів до множини (add)
        productSet.add(new Product("Ноутбук", 20000.0, 10));
        productSet.add(new Product("Смартфон", 15000.0, 20));
        productSet.add(new Product("Планшет", 12000.0, 15));
        productSet.add(new Product("Монітор", 8000.0, 5));

        // 2. Отримання першого та останнього елементів (first, last)
        System.out.println("Перший елемент: " + productSet.first().getName());
        System.out.println("Останній елемент: " + productSet.last().getName());

        // 3. Отримання підмножини (headSet, tailSet, subSet)
        System.out.println("Елементи дешевше 15000: ");
        for (Product product : productSet.headSet(new Product("", 15000.0, 0))) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }

        System.out.println("Елементи дорожче або рівні 12000: ");
        for (Product product : productSet.tailSet(new Product("", 12000.0, 0))) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }

        System.out.println("Елементи від 10000 до 20000: ");
        for (Product product : productSet.subSet(
                new Product("", 10000.0, 0),
                new Product("", 20000.0, 0))) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }

        // 4. Пошук елементів (ceiling, floor, higher, lower)
        System.out.println("Найменший елемент не менший за 15000: " + productSet.ceiling(new Product("", 15000.0, 0)).getName());
        System.out.println("Найбільший елемент не більший за 15000: " + productSet.floor(new Product("", 15000.0, 0)).getName());
        System.out.println("Елемент, більший за 15000: " + productSet.higher(new Product("", 15000.0, 0)).getName());
        System.out.println("Елемент, менший за 15000: " + productSet.lower(new Product("", 15000.0, 0)).getName());

        // 5. Видалення елементів (pollFirst, pollLast)
        Product firstProduct = productSet.pollFirst();
        System.out.println("Видалено перший елемент: " + firstProduct.getName());

        Product lastProduct = productSet.pollLast();
        System.out.println("Видалено останній елемент: " + lastProduct.getName());

        // 6. Виведення множини у зворотному порядку (descendingSet)
        System.out.println("Множина у зворотному порядку:");
        for (Product product : productSet.descendingSet()) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }
}
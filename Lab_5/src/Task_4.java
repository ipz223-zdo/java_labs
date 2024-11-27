import com.education.ztu.Product;

import java.util.*;

public class Task_4 {
    public static void main(String[] args) {
        // Створюємо чергу з використанням ArrayDeque
        Deque<Product> productQueue = new ArrayDeque<>();

        // 1. Додавання елементів до черги (push, offerLast)
        productQueue.push(new Product("Ноутбук", 20000.0, 10)); // Додає елемент на початок черги
        productQueue.offerLast(new Product("Смартфон", 15000.0, 20)); // Додає елемент в кінець черги
        productQueue.offerLast(new Product("Планшет", 12000.0, 15));

        // 2. Перегляд першого та останнього елементів (getFirst, peekLast)
        System.out.println("Перший елемент: " + productQueue.getFirst().getName());
        System.out.println("Останній елемент: " + productQueue.peekLast().getName());

        // 3. Видалення елементів з черги (pop, removeLast, pollLast)
        Product firstProduct = productQueue.pop(); // Видаляє перший елемент
        System.out.println("Видалено перший елемент: " + firstProduct.getName());

        Product lastProduct = productQueue.removeLast(); // Видаляє останній елемент
        System.out.println("Видалено останній елемент: " + lastProduct.getName());

        // 4. Додавання нового елементу та перевірка стану черги
        productQueue.offerLast(new Product("Монітор", 8000.0, 5));
        System.out.println("Поточний розмір черги: " + productQueue.size());

        // 5. Перегляд та видалення елементів за допомогою pollLast
        while (!productQueue.isEmpty()) {
            Product product = productQueue.pollLast(); // Видаляє останній елемент
            System.out.println("Видалено елемент: " + product.getName());
        }

        // 6. Перевірка, чи черга порожня
        System.out.println("Черга порожня: " + productQueue.isEmpty());

        // 7. Робота з методом push (додаємо на початок)
        productQueue.push(new Product("Клавіатура", 1000.0, 50));
        System.out.println("Перший елемент після push: " + productQueue.getFirst().getName());
    }
}
import com.education.ztu.Product;

import java.util.*;

public class Task_6 {
    public static void main(String[] args) {
        // Створюємо Map з використанням HashMap
        Map<String, Product> productMap = new HashMap<>();

        // 1. Додавання елементів до Map (put, putIfAbsent)
        productMap.put("Ноутбук", new Product("Ноутбук", 20000.0, 10));
        productMap.put("Смартфон", new Product("Смартфон", 15000.0, 20));
        productMap.putIfAbsent("Планшет", new Product("Планшет", 12000.0, 15));
        System.out.println("Розмір Map після додавання: " + productMap.size());

        // 2. Отримання елементів (get)
        System.out.println("Отримання елемента 'Ноутбук': " + productMap.get("Ноутбук"));

        // 3. Перевірка наявності ключа та значення (containsKey, containsValue)
        System.out.println("Чи містить ключ 'Монітор': " + productMap.containsKey("Монітор"));
        System.out.println("Чи містить значення Планшет: " + productMap.containsValue(new Product("Планшет", 12000.0, 15)));

        // 4. Видалення елемента (remove)
        productMap.remove("Смартфон");
        System.out.println("Розмір Map після видалення: " + productMap.size());

        // 5. Отримання ключів та значень (keySet, values)
        System.out.println("Ключі: " + productMap.keySet());
        System.out.println("Значення: ");
        for (Product product : productMap.values()) {
            System.out.println(product);
        }

        // 6. Додавання всіх елементів іншої Map (putAll)
        Map<String, Product> additionalProducts = new HashMap<>();
        additionalProducts.put("Монітор", new Product("Монітор", 8000.0, 5));
        additionalProducts.put("Клавіатура", new Product("Клавіатура", 1000.0, 50));
        productMap.putAll(additionalProducts);
        System.out.println("Розмір Map після додавання додаткових продуктів: " + productMap.size());

        // 7. Робота з entrySet
        System.out.println("Робота з entrySet:");
        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + ", Значення: " + entry.getValue());
            if (entry.getKey().equals("Монітор")) {
                entry.setValue(new Product("Монітор Pro", 10000.0, 10)); // Оновлення значення
            }
        }

        // 8. Очистка Map (clear) та перевірка розміру
        productMap.clear();
        System.out.println("Розмір Map після очистки: " + productMap.size());
    }
}
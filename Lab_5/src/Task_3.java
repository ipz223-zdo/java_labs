import java.util.*;

import com.education.ztu.Product;

public class Task_3 {
    public static void main(String[] args) {
        // Створюємо динамічний масив об'єктів класу Product
        List<Product> products = new ArrayList<>();

        // 1. Додавання об'єктів до списку (add)
        products.add(new Product("Ноутбук", 20000.0, 10));
        products.add(new Product("Смартфон", 15000.0, 20));
        products.add(new Product("Планшет", 12000.0, 15));

        // 2. Додавання декількох об'єктів одночасно (addAll)
        List<Product> newProducts = Arrays.asList(
                new Product("Монітор", 8000.0, 5),
                new Product("Клавіатура", 1000.0, 50)
        );
        products.addAll(newProducts);

        // 3. Отримання елемента за індексом (get)
        System.out.println("Продукт на індексі 1: " + products.get(1).getName());

        // 4. Пошук індексу першого та останнього входження елемента (indexOf, lastIndexOf)
        Product keyboard = new Product("Клавіатура", 1000.0, 50);
        products.add(keyboard); // Додаємо ще один екземпляр "Клавіатура"
        products.add(keyboard); // Додаємо ще один екземпляр "Клавіатура"
        System.out.println("Перший індекс клавіатури: " + products.indexOf(keyboard));
        System.out.println("Останній індекс клавіатури: " + products.lastIndexOf(keyboard));

        // 5. Перегляд списку за допомогою ітераторів (iterator, listIterator)
        System.out.println("Перегляд списку (iterator):");
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }

        System.out.println("Перегляд списку (listIterator):");
        ListIterator<Product> listIterator = products.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next().getName());
        }

        // 6. Видалення елемента (remove)
        products.remove(keyboard);
        products.remove(keyboard);
        System.out.println("Список після видалення клавіатури: " + products.size());

        // 7. Заміна елемента (set)
        products.set(0, new Product("Телевізор", 25000.0, 7));
        System.out.println("Новий перший елемент: " + products.getFirst().getName());

        // 8. Сортування списку за ціною (sort)
        products.sort(Comparator.comparing(Product::getPrice));
        System.out.println("Список після сортування за ціною:");
        for (Product product : products) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }

        // 9. Отримання підсписку (subList)
        List<Product> subList = products.subList(1, 3);
        System.out.println("Підсписок:");
        for (Product product : subList) {
            System.out.println(product.getName());
        }

        // 10. Очистка списку (clear)
        products.clear();
        System.out.println("Список після очищення: " + products.size());

        // 11. Перевірка списку на вміст (contains, isEmpty)
        System.out.println("Список містить планшет: " + products.contains(new Product("Планшет", 12000.0, 15)));
        System.out.println("Список порожній: " + products.isEmpty());

        // 12. Ретенція (retainAll)
        products.addAll(newProducts);
        products.retainAll(Collections.singletonList(new Product("Монітор", 8000.0, 5)));
        System.out.println("Список після retainAll: " + products.size());

        products.add(new Product("Ноутбук", 20000.0, 10));
        products.add(new Product("Смартфон", 15000.0, 20));
        products.add(new Product("Планшет", 12000.0, 15));

        // 13. Розмір списку (size)
        System.out.println("Розмір списку: " + products.size());

        // 14. Перетворення списку у масив (toArray)
        Product[] productArray = products.toArray(new Product[0]);
        System.out.println("Масив продуктів:");
        for (Product product : productArray) {
            System.out.println(product.getName());
        }
    }
}
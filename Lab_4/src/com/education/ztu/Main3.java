package com.education.ztu;

import java.util.Formatter;

public class Main3 {
    public static void main(String[] args) {
        // Дані про товари
        String[][] items = {
                {"Джинси", "Жіночий одяг", "1500,78 ₴"},
                {"Спідниця", "Жіночий одяг", "1000,56 ₴"},
                {"Краватка", "Чоловічий одяг", "500,78 ₴"},
                {"Сорочка", "Чоловічий одяг", "850,50 ₴"},
                {"Сукня", "Жіночий одяг", "2000,99 ₴"},
                {"Туфлі", "Жіноче взуття", "1800,35 ₴"},
                {"Ремінь", "Аксесуари", "350,00 ₴"},
                {"Кросівки", "Чоловіче взуття", "2200,00 ₴"},
                {"Футболка", "Чоловічий одяг", "400,25 ₴"},
                {"Шорти", "Чоловічий одяг", "700,00 ₴"}
        };

        // Форматований чек
        Formatter formatter = new Formatter();
        formatter.format("Дата та час покупки: %43s\n", "28.03.2019 13:25:12");
        formatter.format("================================================================\n");
        formatter.format("%-6s %-20s %-25s %10s\n", "№", "Товар", "Категорія", "Ціна");
        formatter.format("================================================================\n");


        double total = 0.0;

        for (int i = 0; i < items.length; i++) {
            formatter.format("%-6d %-20s %-25s %10s\n", i + 1, items[i][0], items[i][1], items[i][2]);
            total += parsePrice(items[i][2]);
        }

        formatter.format("================================================================\n");
        formatter.format("%-51s %10.2f ₴\n", "Разом:", total);

        // Виведення результату
        System.out.println(formatter);
        formatter.close();
    }

    // Метод для перетворення рядка ціни у число
    private static double parsePrice(String price) {
        return Double.parseDouble(price.replace(",", ".").replace(" ₴", ""));
    }
}

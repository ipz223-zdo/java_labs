package com.education.ztu;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Date;

public class Main4 {
    public static void main(String[] args) {
        // Дані про товари
        String[][] items = {
                {"Jeans", "Women's clothing", "1500.78"},
                {"Skirt", "Women's clothing", "1000.56"},
                {"Tie", "Men's clothing", "500.78"},
                {"Shirt", "Men's clothing", "850.50"},
                {"Dress", "Women's clothing", "2000.99"}
        };

        // Вибір локалі
        Locale locale = selectLocale("en_US"); // Мови: uk_UA, en_US або es_ES

        // Завантаження ресурсів
        ResourceBundle bundle = ResourceBundle.getBundle("data", locale);
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        // Виведення чека
        System.out.println(MessageFormat.format(bundle.getString("date_time"), new Date()));
        System.out.println(bundle.getString("header"));
        System.out.println(bundle.getString("table_header"));
        System.out.println(bundle.getString("header"));

        double total = 0.0;

        for (int i = 0; i < items.length; i++) {
            String itemName = items[i][0];
            String category = items[i][1];
            double price = Double.parseDouble(items[i][2]);
            total += price;

            System.out.printf("%-6d %-20s %-25s %10s\n", i + 1, itemName, category, currencyFormatter.format(price));
        }

        System.out.println(bundle.getString("header"));
        System.out.printf("%-51s %12s\n", bundle.getString("total"), currencyFormatter.format(total));
    }

    private static Locale selectLocale(String localeCode) {
        return switch (localeCode) {
            case "uk_UA" -> new Locale("uk", "UA"); // Українська
            case "en_US" -> Locale.US; // Англійська
            case "es_ES" -> new Locale("es", "ES"); // Іспанська
            default -> Locale.getDefault();
        };
    }
}

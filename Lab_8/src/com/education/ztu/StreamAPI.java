package com.education.ztu;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class StreamAPI {

    public static List<Product> products = Arrays.asList(
            new Product("Laptop", "Dell", 1500, 5),
            new Product("Smartphone", "Apple", 999, 10),
            new Product("Headphones", "Sony", 200, 15),
            new Product("Monitor", "Samsung", 800, 7)
    );

    public static Stream<String> getBrands() {
        return products.stream().map(Product::getBrand).distinct();
    }

    public static Stream<Product> getProductsCheaperThan(int price, int limit) {
        return products.stream()
                .filter(p -> p.getPrice() < price)
                .limit(limit);
    }

    public static int getTotalProductCount() {
        return products.stream()
                .map(Product::getCount)
                .reduce(0, Integer::sum);
    }

    public static Map<String, List<Product>> groupByBrand() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getBrand));
    }

    public static List<Product> sortByPrice() {
        return products.stream()
                .sorted(Comparator.comparingInt(Product::getPrice))
                .collect(Collectors.toList());
    }
}

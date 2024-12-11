package com.education.ztu;

import java.util.function.*;

public class LambdaTasks {
    public static Predicate<String> isNumeric = str -> {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    };

    public static Consumer<String> startPair = str -> System.out.println("Пара почалася о 8:30");
    public static Consumer<String> endPair = str -> System.out.println("Пара закінчилася о 9:50");

    public static Supplier<String> upperCaseSupplier = "Sample sentence"::toUpperCase;

    public static Function<String, Integer> multiplyNumbers = str -> {
        return java.util.Arrays.stream(str.split(" "))
                .mapToInt(Integer::parseInt)
                .reduce(1, (a, b) -> a * b);
    };

    
}

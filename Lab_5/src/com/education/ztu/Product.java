package com.education.ztu;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Ціна не може бути від'ємною.");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Кількість не може бути від'ємною.");
        }
    }

    // Метод для виведення інформації про продукт
    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", quantity=" + quantity + "}";
    }

    // Метод для розрахунку загальної вартості продуктів на складі
    public double calculateTotalValue() {
        return price * quantity;
    }

    // Метод для продажу продукту
    public void sell(int amount) {
        if (amount > 0 && amount <= quantity) {
            quantity -= amount;
            System.out.println(amount + " одиниць продукту продано.");
        } else {
            System.out.println("Недостатня кількість продукту для продажу.");
        }
    }

    // Метод для поповнення складу
    public void restock(int amount) {
        if (amount > 0) {
            quantity += amount;
            System.out.println(amount + " одиниць продукту додано до складу.");
        } else {
            System.out.println("Кількість для поповнення повинна бути додатною.");
        }
    }
}

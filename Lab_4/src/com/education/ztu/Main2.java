package com.education.ztu;

public class Main2 {
    public static void main(String[] args) {
        int num1 = 4;
        int num2 = 36;

        // Формування рядків
        StringBuilder sb = new StringBuilder();
        sb.append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2);
        System.out.println(sb);

        sb = new StringBuilder();
        sb.append(num1).append(" - ").append(num2).append(" = ").append(num1 - num2);
        System.out.println(sb);

        sb = new StringBuilder();
        sb.append(num1).append(" * ").append(num2).append(" = ").append(num1 * num2);
        System.out.println(sb);


        // Замінити "=" на "рівно" за допомогою insert() та deleteCharAt()
        int equalsIndex = sb.indexOf("=");
        sb.deleteCharAt(equalsIndex);
        sb.insert(equalsIndex, " рівно");
        System.out.println("Заміна '=' на 'рівно' (insert, deleteCharAt): " + sb);

        // Замінити "=" на "рівно" за допомогою replace()
        sb = new StringBuilder(); // Очищаємо StringBuilder
        sb.append(num1).append(" - ").append(num2).append(" = ").append(num1 - num2);
        sb.replace(sb.indexOf("="), sb.indexOf("=") + 1, " рівно");
        System.out.println("Заміна '=' на 'рівно' (replace): " + sb);

        // Змінити послідовність символів на протилежну
        sb = new StringBuilder(); // Очищаємо StringBuilder
        sb.append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2);
        sb.reverse();
        System.out.println("Реверс рядка: " + sb);

        // Визначення довжини та capacity
        System.out.println("Довжина StringBuilder: " + sb.length());
        System.out.println("Capacity StringBuilder: " + sb.capacity());
    }
}

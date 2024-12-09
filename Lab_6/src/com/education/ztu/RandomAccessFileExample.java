package com.education.ztu;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        // Шлях до текстового файлу
        String fileName = "copy.txt";

        // Текст для додавання
        String text1 = "Новий товар: Годинник, Аксесуари, 2500,00 ₴\n";
        String text2 = "Новий товар: Окуляри, Аксесуари, 1500,00 ₴\n";

        // Додавання тексту у файл у вказані позиції
        appendTextAtPosition(fileName, text1, 480);  // Додаємо на 50-ту позицію
        appendTextAtPosition(fileName, text2, 650); // Додаємо на 150-ту позицію

        System.out.println("Текст успішно додано у файл.");
    }

    private static void appendTextAtPosition(String fileName, String text, long position) {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            // Переходимо до заданої позиції
            raf.seek(position);

            // Зберігаємо решту тексту після заданої позиції
            byte[] remainingBytes = new byte[(int) (raf.length() - position)];
            raf.read(remainingBytes);

            // Повертаємося до позиції, пишемо новий текст
            raf.seek(position);
            raf.write(text.getBytes());

            // Записуємо решту тексту назад у файл
            raf.write(remainingBytes);
        } catch (IOException e) {
            System.out.println("Помилка при роботі з файлом: " + e.getMessage());
        }
    }
}

package com.education.ztu;
import java.io.*;

public class FileCopy {
    // Метод для копіювання текстового файлу
    public static void copyTextFile(String sourceFile, String destinationFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Додаємо перенесення рядка
            }
            System.out.println("Текстовий файл успішно скопійовано.");
        } catch (IOException e) {
            System.out.println("Помилка під час копіювання текстового файлу: " + e.getMessage());
        }
    }

    // Метод для копіювання файлу (зображення або будь-якого іншого типу)
    public static void copyBinaryFile(String sourceFile, String destinationFile) {
        try (FileInputStream inputStream = new FileInputStream(sourceFile);
             FileOutputStream outputStream = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024]; // Буфер для читання даних
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("Бінарний файл успішно скопійовано.");
        } catch (IOException e) {
            System.out.println("Помилка під час копіювання бінарного файлу: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        // Тестове копіювання текстового файлу
        String sourceTextFile = "shopping_report.txt";
        String destinationTextFile = "copy.txt";
        copyTextFile(sourceTextFile, destinationTextFile);

        // Тестове копіювання зображення
        String sourceImageFile = "4.jpg";
        String destinationImageFile = "copy.jpg";
        copyBinaryFile(sourceImageFile, destinationImageFile);
    }
}

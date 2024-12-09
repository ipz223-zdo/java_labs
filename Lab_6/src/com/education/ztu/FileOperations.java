package com.education.ztu;

import java.io.File;
import java.io.IOException;

public class FileOperations {
    public static void main(String[] args) {
        // Базова директорія для роботи
        File baseDirectory = new File("directory_for_files");
            if (!baseDirectory.exists()) {
            baseDirectory.mkdir(); // Створюємо, якщо не існує
        }

        // Створення нової папки inner_directory
        File innerDirectory = new File(baseDirectory, "inner_directory");
            if (innerDirectory.mkdir()) {
            System.out.println("Папка створена: " + innerDirectory.getAbsolutePath());
        }

        // Виведення імені батьківської директорії
            System.out.println("Батьківська директорія: " + innerDirectory.getParent());

        // Створення двох текстових файлів у inner_directory
        File file1 = new File(innerDirectory, "file1.txt");
        File file2 = new File(innerDirectory, "file2.txt");
            try {
            if (file1.createNewFile() && file2.createNewFile()) {
                System.out.println("Файли створено: " + file1.getName() + ", " + file2.getName());
            }
        } catch (IOException e) {
            System.out.println("Помилка створення файлів: " + e.getMessage());
        }

        // Видалення одного файлу
            if (file1.delete()) {
            System.out.println("Файл " + file1.getName() + " успішно видалено.");
        }

        // Перейменування папки inner_directory
        File renamedDirectory = new File(baseDirectory, "renamed_inner_directory");
            if (innerDirectory.renameTo(renamedDirectory)) {
            System.out.println("Папку перейменовано на: " + renamedDirectory.getName());
        }

        // Виведення списку файлів та папок у baseDirectory
        File[] filesAndFolders = baseDirectory.listFiles();
            if (filesAndFolders != null) {
            System.out.println("Список файлів і папок у " + baseDirectory.getName() + ":");
            for (File file : filesAndFolders) {
                String type = file.isDirectory() ? "Папка" : "Файл";
                long size = file.length();
                System.out.println(type + ": " + file.getName() + ", Розмір: " + size + " байт");
            }
        }
    }
}

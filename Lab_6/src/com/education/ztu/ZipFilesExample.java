package com.education.ztu;

import java.io.*;
import java.util.zip.*;

public class ZipFilesExample {
    public static void main(String[] args) {
        // Базова директорія з файлами для архівування
        String directoryPath = "directory_for_files";
        String zipFileName = "files_archive.zip";

        // Створення ZIP-архіву
        createZip(directoryPath, zipFileName);

        // Виведення списку файлів з архіву
        listFilesInZip(zipFileName);
    }

    // Метод для створення ZIP-архіву
    public static void createZip(String directoryPath, String zipFileName) {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Директорія не існує або це не директорія.");
            return;
        }

        try (FileOutputStream fos = new FileOutputStream(zipFileName);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            // Рекурсивне додавання файлів
            addDirectoryToZip(directory, directory.getPath(), zos);

            System.out.println("Архів створено: " + zipFileName);
        } catch (IOException e) {
            System.out.println("Помилка під час створення архіву: " + e.getMessage());
        }
    }

    // Метод для рекурсивного додавання файлів та папок до ZIP-архіву
    private static void addDirectoryToZip(File directory, String basePath, ZipOutputStream zos) throws IOException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Рекурсивно додаємо підкаталоги
                    addDirectoryToZip(file, basePath, zos);
                } else {
                    // Додаємо файл
                    addFileToZip(file, basePath, zos);
                }
            }
        }
    }

    // Метод для додавання файлу до ZIP-архіву
    private static void addFileToZip(File file, String basePath, ZipOutputStream zos) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            String zipEntryName = file.getPath().substring(basePath.length() + 1).replace("\\", "/");
            ZipEntry zipEntry = new ZipEntry(zipEntryName);
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                zos.write(buffer, 0, bytesRead);
            }

            zos.closeEntry();
            System.out.println("Файл додано до архіву: " + zipEntryName);
        }
    }

    // Метод для виведення списку файлів з ZIP-архіву
    public static void listFilesInZip(String zipFileName) {
        try (FileInputStream fis = new FileInputStream(zipFileName);
             ZipInputStream zis = new ZipInputStream(fis)) {

            System.out.println("Файли у архіві:");
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                System.out.println("- " + zipEntry.getName());
                zis.closeEntry();
            }

        } catch (IOException e) {
            System.out.println("Помилка під час читання архіву: " + e.getMessage());
        }
    }
}

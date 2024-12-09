import java.io.*;

public class Task_3 {
    public static void main(String[] args) {
        // Дані про товари
        String[][] items = {
                {"Джинси", "Жіночий одяг", "1500,78 ₴"},
                {"Спідниця", "Жіночий одяг", "1000,56 ₴"},
                {"Краватка", "Чоловічий одяг", "500,78 ₴"},
                {"Сорочка", "Чоловічий одяг", "850,50 ₴"},
                {"Сукня", "Жіночий одяг", "2000,99 ₴"}
        };

        // Файл для запису та читання
        String fileName = "shopping_report.txt";

        // Формування звіту
        String report = generateReport(items);

        // Запис звіту у файл
        writeToFile(fileName, report);

        // Читання звіту з файлу
        readFromFile(fileName);
    }

    // Метод для формування звіту
    private static String generateReport(String[][] items) {
        StringBuilder report = new StringBuilder();
        report.append(String.format("Дата та час покупки: %43s\n", "28.03.2019 13:25:12"));
        report.append("================================================================\n");
        report.append(String.format("%-6s %-20s %-25s %10s\n", "№", "Товар", "Категорія", "Ціна"));
        report.append("================================================================\n");

        double total = 0.0;

        for (int i = 0; i < items.length; i++) {
            report.append(String.format("%-6d %-20s %-25s %10s\n", i + 1, items[i][0], items[i][1], items[i][2]));
            total += parsePrice(items[i][2]);
        }

        report.append("================================================================\n");
        report.append(String.format("%-51s %10.2f ₴\n", "Разом:", total));

        return report.toString();
    }

    // Метод для запису звіту у файл
    private static void writeToFile(String fileName, String report) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.write(report);
            System.out.println("Звіт успішно записано у файл.");
        } catch (IOException e) {
            System.out.println("Помилка запису у файл: " + e.getMessage());
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Помилка закриття файлу: " + e.getMessage());
                }
            }
        }
    }

    // Метод для читання звіту з файлу
    private static void readFromFile(String fileName) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            System.out.println("Зчитування звіту з файлу:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Помилка читання з файлу: " + e.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("Помилка закриття BufferedReader: " + e.getMessage());
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    System.out.println("Помилка закриття FileReader: " + e.getMessage());
                }
            }
        }
    }

    // Метод для перетворення рядка ціни у число
    private static double parsePrice(String price) {
        return Double.parseDouble(price.replace(",", ".").replace(" ₴", ""));
    }
}
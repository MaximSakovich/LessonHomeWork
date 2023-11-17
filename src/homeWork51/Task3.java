package homeWork51;

import java.io.*;

public class Task3 {
    public static void main(String[] args) {
        // Путь к директории, в которой будут созданы файлы
        String directoryPath = "src/homeWork51";

        // Создаем объект File для указанной директории
        File directory = new File(directoryPath);

        // Получаем список файлов в директории
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                // Проверяем, является ли файл текстовым файлом
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            // Проверяем, содержится ли строка "Java7" в файле
                            if (line.contains("Java7")) {
                                System.out.println("String 'Java7' found in file: " + file.getName());
                                break; // Прерываем цикл, так как строка найдена
                            }
                        }
                    } catch (IOException e) {
                        System.err.println("Error reading file: " + file.getAbsolutePath());
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
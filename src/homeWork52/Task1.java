package homeWork52;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        String inputFilePath = "src/homeWork52/task_1.txt";
        String lessFilePath = "src/homeWork52/less.txt";
        String moreFilePath = "src/homeWork52/more.txt";

        Map<String, Integer> userSums = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String username = parts[0];
                    int amount = Integer.parseInt(parts[1]);

                    userSums.put(username, userSums.getOrDefault(username, 0) + amount);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения входного файла: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        try (BufferedWriter lessWriter = new BufferedWriter(new FileWriter(lessFilePath));
             BufferedWriter moreWriter = new BufferedWriter(new FileWriter(moreFilePath))) {

            for (Map.Entry<String, Integer> entry : userSums.entrySet()) {
                String username = entry.getKey();
                int sum = entry.getValue();

                BufferedWriter writer = (sum < 2000) ? lessWriter : moreWriter;

                writer.write(username + ":" + sum);
                writer.newLine();
            }

            System.out.println("Результаты успешно записаны в файлы.");

        } catch (IOException e) {
            System.err.println("Ошибка записи выходных файлов: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

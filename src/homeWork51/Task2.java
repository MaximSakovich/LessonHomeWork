package homeWork51;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

    public class Task2 {
        public static void main(String[] args) {
            String directoryPath = "src/homeWork51";
            for (int i = 1; i <= 10; i++) {
                String fileName = "test_" + i + ".txt";
                String content = "Java" + i;
                File file = new File(directoryPath, fileName);
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(content);
                    System.out.println("File " + file.getAbsolutePath() + " created successfully.");
                } catch (IOException e) {
                    System.err.println("Error creating file: " + file.getAbsolutePath());
                    e.printStackTrace();
                }
            }
        }
    }

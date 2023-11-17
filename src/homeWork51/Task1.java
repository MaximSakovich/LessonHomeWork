package homeWork51;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            String fileName = "test_" + i + ".txt";
            String content = "Java" + i;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(content);
                System.out.println("File " + fileName + " created successfully.");
            } catch (IOException e) {
                System.err.println("Error creating file: " + fileName);
                e.printStackTrace();
            }
        }
    }
}
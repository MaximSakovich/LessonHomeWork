package homeWork53;

import java.util.function.BiConsumer;

//Task 3
//Напишите BiConsumer, который принимает ключ и значение,
// а затем печатает их в формате "ключ=значение.

public class Task3 {

    public static void main(String[] args) {
        BiConsumer<String, String> keyValuePrinter = (key, value) -> System.out.println(key + "=" + value);

        keyValuePrinter.accept("name", "Maksym");
        keyValuePrinter.accept("age", "50");
        keyValuePrinter.accept("city", "Mullheim");
    }
}

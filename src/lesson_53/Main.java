package lesson_53;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем список строк
        List<String> stringList = new ArrayList<>();

        // Добавляем элементы в список
        stringList.add("Java");
        stringList.add("Python");
        stringList.add("C++");

        // Печать элементов списка
        for (String language : stringList) {
            System.out.println(language);
        }
    }
}

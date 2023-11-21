package homeWork54.Task1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Task 1
//Дан список строк. Используя Stream API, отфильтруйте строки, которые начинаются
// на определенную букву (например, "A"), удалите дубликаты и отсортируйте их в алфавитном порядке.

public class Task1 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Apple", "Banana", "Avocado", "Banana", "Apricot", "Apple", "Cherry");
        char filterLetter = 'A';
        List<String> result = stringList.stream()
                .filter(s -> s.startsWith(String.valueOf(filterLetter)))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}

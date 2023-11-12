package homeWork47.Task2;

import java.util.HashMap;
import java.util.Map;

//Task 2
//Пересечение двух карт: Реализуйте метод, который принимает две карты Map<String, Integer>
// и возвращает новую карту, содержащую только те записи, ключи которых присутствуют в обеих
// исходных картах. Для совпадающих ключей значение можно брать из любой карты.

public class MapIntersection {

    public static Map<String, Integer> intersection(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> intersectionMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer valueFromMap1 = entry.getValue();
            Integer valueFromMap2 = map2.get(key);
            if (valueFromMap2 != null) {
                intersectionMap.put(key, valueFromMap1);
            }
        }

        return intersectionMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("apple", 50);
        map1.put("banana", 20);
        map1.put("cherry", 30);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("banana", 25);
        map2.put("cherry", 30);
        map2.put("date", 40);

        Map<String, Integer> intersectionMap = intersection(map1, map2);
        intersectionMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}





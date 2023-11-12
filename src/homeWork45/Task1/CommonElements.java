package homeWork45.Task1;

import java.util.ArrayList;
import java.util.List;

/*Task 1
Напишите метод, который принимает на вход две реализации интерфейса List
и возвращает список состоящий из элементов, которые присутствуют в обоих коллекциях.
 */
public class CommonElements {
    public static <T> List<T> findCommonElements(List<T> list1, List<T> list2) {
        List<T> commonElements = new ArrayList<>(list1);
        commonElements.retainAll(list2);
        return commonElements;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> list2 = new ArrayList<>(List.of(3, 4, 5, 6, 7));
        List<Integer> commonElements = findCommonElements(list1, list2);
        System.out.println("Общие элементы: " + commonElements);
    }
}

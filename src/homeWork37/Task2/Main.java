package homeWork37.Task2;

import java.time.LocalDate;
import java.util.Arrays;

/*Task 2
Написать метод, принимающий массив или MyArrayList (наш самописный резиновый массив)
из нескольких дат типа LocalDate и возвращающий количество дней
между самой ранней и поздней датами в этом списке
 */
public class Main {
    public static void main(String[] args) {

        MyArrayList<LocalDate> myArrayList = new MyArrayList<>();

        LocalDate[] dates = {LocalDate.of(2023, 10, 20), LocalDate.of(2023,
                10, 25), LocalDate.of(2023, 10, 15)};

        myArrayList.setElements(Arrays.copyOf(dates, dates.length));

        System.out.println(myArrayList.toString());

        System.out.println("Количество дней между самой ранней и поздней датами: " +
                myArrayList.getDaysBetweenDates(myArrayList.getElements()));
    }
}

package homeWork37.Task2;

import java.time.LocalDate;

/*Task 2
Написать метод, принимающий массив или MyArrayList (наш самописный резиновый массив)
из нескольких дат типа LocalDate и возвращающий количество дней
между самой ранней и поздней датами в этом списке
 */
public class Main {
    public static void main(String[] args) {
        LocalDate[] dates = {
                LocalDate.of(2023, 10, 15),
                LocalDate.of(2023, 10, 20),
                LocalDate.of(2023, 10, 25)
        };
        long differenceInDays = MyArrayList.getDaysBetweenDates(dates);
        System.out.println("Difference in days: " + differenceInDays);
    }
}
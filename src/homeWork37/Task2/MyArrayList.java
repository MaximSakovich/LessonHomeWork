package homeWork37.Task2;

import java.time.LocalDate;

public class MyArrayList<T> {
    private T[] elements;

    // конструктор и другие методы

    // Метод для получения количества дней между самой ранней и поздней датами
    public long getDaysBetweenDates(T[] dates) {
        if (dates.length == 0) {
            return 0; // если массив пуст, возвращаем 0
        }

        if (!(dates[0] instanceof LocalDate)) {
            throw new IllegalArgumentException("Массив должен содержать только LocalDate объекты.");
        }

        LocalDate minDate = (LocalDate) dates[0];
        LocalDate maxDate = (LocalDate) dates[0];

        // Находим самую раннюю и позднюю дату
        for (T date : dates) {
            LocalDate currentDate = (LocalDate) date;
            if (currentDate.isBefore(minDate)) {
                minDate = currentDate;
            } else if (currentDate.isAfter(maxDate)) {
                maxDate = currentDate;
            }
        }

        // Возвращаем количество дней между датами
        return maxDate.toEpochDay() - minDate.toEpochDay();
    }

    // Другие методы класса MyRealList
}

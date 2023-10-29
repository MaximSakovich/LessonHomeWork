package homeWork37.Task2;

import java.time.LocalDate;
import java.util.Arrays;

public class MyArrayList<T> {
    private T[] elements;

    // Метод для получения количества дней между самой ранней и поздней датами
    public long getDaysBetweenDates(T[] dates) {
        if (dates.length == 0) {
            return 0;
        }
        if (!(dates[0] instanceof LocalDate)) {
            throw new IllegalArgumentException("Массив должен содержать только LocalDate объекты.");
        }
        LocalDate minDate = (LocalDate) dates[0];
        LocalDate maxDate = (LocalDate) dates[0];
        for (T date : dates) {
            LocalDate currentDate = (LocalDate) date;
            if (currentDate.isBefore(minDate)) {
                minDate = currentDate;
            } else if (currentDate.isAfter(maxDate)) {
                maxDate = currentDate;
            }
        }
        return maxDate.toEpochDay() - minDate.toEpochDay();
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }

    public T[] getElements() {
        return elements;
    }

    public void setElements(T[] elements) {
        this.elements = elements;
    }
}

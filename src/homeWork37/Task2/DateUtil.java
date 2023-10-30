package homeWork37.Task2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtil {
    // Метод для получения количества дней между самой ранней и поздней датами
    public static long getDaysBetweenDates(LocalDate[] dates) {
        if (dates.length == 0) {
            return 0;
        }
        LocalDate minDate = dates[0];
        LocalDate maxDate = dates[0];
        for (LocalDate date : dates) {
            if (date.isBefore(minDate)) {
                minDate = date;
            } else if (date.isAfter(maxDate)) {
                maxDate = date;
            }
        }
        return minDate.until(maxDate, ChronoUnit.DAYS);
    }
}
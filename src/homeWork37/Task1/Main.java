package homeWork37.Task1;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

// Task 1
//Получить и вывести на экран:
//текущую дату
//текущий год, месяц и день
//Создать дату, например Ваш день рождения и вывести на экран
//Создать две даты и проверить на равенство
//Получить и вывести на экран:
//текущее время
//текущее время + 3 часа
//Создать дату:
//которая на неделю позже сегодняшней
//которая была на год раньше сегодняшней используя метод minus
//которая на год позже сегодняшней
//tomorrow и yesterday и проверить находятся ли они до или после сегодняшней

public class Main {
    public static void main(String[] args) {
        // Текущая дата
        //LocalDate date = LocalDate.now();
        Date currentDate = new Date();
        System.out.println(currentDate);

        // Текущий год, месяц и день
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Месяцы в Calendar начинаются с 0
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Текущий год, месяц и день: " + year + "-" + month + "-" + day);

        // Создание и вывод даты (например, день рождения)
        LocalDate birthday = LocalDate.of(1973, 11, 5);
        System.out.println("День рождения: " + birthday);

        // Создание двух дат и проверка на равенство
        LocalDate date1 = LocalDate.of(2023, 10, 27);
        LocalDate date2 = LocalDate.of(2023, 10, 27);
        boolean isEqual = date1.isEqual(date2);
        System.out.println("Даты равны: " + isEqual);

        // Текущее время
        LocalTime currentTime = LocalTime.now();
        System.out.println("Текущее время: " + currentTime);

        // Текущее время + 3 часа
        LocalTime laterTime = currentTime.plusHours(3);
        System.out.println("Текущее время + 3 часа: " + laterTime);

        // Создание даты на неделю позже сегодняшней
        LocalDate nextWeek = LocalDate.now().plusWeeks(1);
        System.out.println("На неделю позже сегодняшней: " + nextWeek);

        // Создание даты на год раньше сегодняшней
        LocalDate lastYear = LocalDate.now().minusYears(1);
        System.out.println("На год раньше сегодняшней: " + lastYear);

        // Создание даты на год позже сегодняшней
        LocalDate nextYear = LocalDate.now().plusYears(1);
        System.out.println("На год позже сегодняшней: " + nextYear);

        // tomorrow и yesterday
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate yesterday = LocalDate.now().minusDays(1);
        boolean isTomorrowAfterToday = tomorrow.isAfter(LocalDate.now());
        boolean isYesterdayBeforeToday = yesterday.isBefore(LocalDate.now());
        System.out.println("Завтра после сегодняшнего: " + isTomorrowAfterToday);
        System.out.println("Вчера было до сегодняшнего дня: " + isYesterdayBeforeToday);
    }
}

package lesson_47.enumSet;

import java.util.EnumSet;
import java.util.Set;

public class EnumSetExample {
    public static void main(String[] args) {

        Set<Day> days = EnumSet.allOf(Day.class);
        System.out.println(days);

Set<Day> weekend = EnumSet.of(Day.TUESDAY, Day.FRIDAY);
        System.out.println(weekend);
        Set<Day> workDays = EnumSet.range(Day.MONDAY, Day.FRIDAY);
        System.out.println(workDays);

    }
}

package lesson_21;

public class MathUtil {

    public static int symOfInts(int x, int... ints) {
        int sum = x;
        for (int value : ints) {

            sum += value;
        }
        return sum;
    }

}

package lesson_29.summable;

public interface Summable {
    // по умолчанию "поля" интерфейса имеют модификаторы public static final
    double PI = 3.141519;


    default int sum(int...ints) {
        return getSum(ints);
    }

    private int getSum(int[] ints) {
        int sum = 0;
        for (int value: ints) {
            sum += value;
        }

        return sum;
    }

}

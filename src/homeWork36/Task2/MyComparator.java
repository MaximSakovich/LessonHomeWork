package homeWork36.Task2;

import java.util.Comparator;

public class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer even, Integer odd) {
        boolean evenNew = even % 2 == 0;
        boolean oddNew = odd % 2 == 0;
        if (evenNew && !oddNew) {
            return -1;
        } else if (!evenNew && oddNew) {
            return 1;
        } else {
            if (evenNew) {
                return even.compareTo(odd);
            } else {
                return odd.compareTo(even);
            }
        }
    }
}

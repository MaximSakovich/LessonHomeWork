package homeWork36.Task1;

import java.util.Comparator;

public class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer even, Integer odd) {
        if (even % 2 == 0 && odd % 2 != 0) {
            return -1;
        } else if (even % 2 != 0 && odd % 2 == 0) {
            return 1;
        } else {
            return even.compareTo(odd);
        }
    }
}

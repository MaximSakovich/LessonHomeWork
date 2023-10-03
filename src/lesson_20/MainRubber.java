package lesson_20;

public class MainRubber {
    public static void main(String[] args) {

        RubberArray20 ra = new RubberArray20();

        ra.add(0, 1, 2, 3, 4, 5, 6);
        // ra.cursor = 15;

        //int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // ra.array = ints; после закрытия доступа к полю - данное присвоение не возможно

        ra.add(100);
        //ra.expandArray();

        System.out.println(ra.toString());
    }
}
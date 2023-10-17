package lesson_30.rubberArray;

public class RubberArrayApp {

    public static void main(String[] args) {
        RubberArray<Integer> ra = new RubberArray<>();
        ra.add(10, -5, 16, 57);
        System.out.println(ra);
        ra.remove(16);
        System.out.println(ra);

        RubberArray<Integer> raInt = new RubberArray<>();
        raInt.add(101, 234, 536, -10, 0, 13);
        System.out.println(raInt.toString());

        RubberArray<String> raStr = new RubberArray<>();
        raStr.add("Очень", "сложно", "!");
        System.out.println(raStr.toString());


    }
}


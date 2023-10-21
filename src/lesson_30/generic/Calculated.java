package lesson_30.generic;

public interface Calculated <T extends Number>{
    T sum(T v1, T v2);
    default void printValue(T value) {
        System.out.println(value.intValue());
    }

}
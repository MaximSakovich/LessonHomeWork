package homeWork13;


public class Task2 {
    public static void main(String[] args) {
       /* Task 2

        Написать свой метод copyOfArray, дублирующий функционал метода Arrays.copyOf()
        на вход принимает массив целых чисел и число - длину нового массива.
        Метод должен создать и распечатать массив заданной в параметрах длинны.
        В начало массива должны быть скопированы элементы из входящего массива:
        {0, 1, 2, 3, 4, 5, 6} -> copyOfArray(array, 3) -> вывод на печать {0, 1, 2}
        Arrays.copyOf() использовать нельзя. Суть задачи - написать собственную реализацию этого метода */

        int[] array = {0, 1, 2, 3, 4, 5, 6};
        int newLength = 3;
        int[] copiedArray = copyOfArray(array, newLength);

        System.out.print("{");
        for (int i = 0; i < copiedArray.length; i++) {
            System.out.print(copiedArray[i]);
            if (i < copiedArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    // Метод для копирования элементов из входящего массива в новый массив заданной длины
    public static int[] copyOfArray(int[] sourceArray, int newLength) {
        int[] newArray = new int[newLength];
        for (int i = 0; i < newLength; i++) {
            if (i < sourceArray.length) {
                newArray[i] = sourceArray[i];
            }
        }
        return newArray;
    }
}
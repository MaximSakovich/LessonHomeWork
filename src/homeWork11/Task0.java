package homeWork11;

import java.util.Random;

public class Task0 {
    public static void main(String[] args) {

        //Task 0
        // Дан массив целых чисел. *Выберите произвольную длину. Заполните случайными значениями.
        // Вывести на экран:
        // минимальное значение, хранящееся в массиве, максимальное,
        // среднее арифметическое всех значений в массиве
        Random random = new Random();
        int[] array = new int[14];
        int x = 0;
        System.out.print("[");
        while (x < array.length) {
            array[x] = random.nextInt(101);
            System.out.print(array[x] + ", ");
            x++;
        }
        System.out.println("]\n");
        int y = 0;
        int min = array[0];
        while (y < array.length) {
            if (array[y] < min) {
                min = array[y];
            }
            y++;
        }
        System.out.println("Минимальное значение в массиве: " + min);
        int z = 0;
        int max = array[0];
        while (z < array.length) {
            if (array[z] > max) {
                max = array[z];
            }
            z++;
        }
        System.out.println("Максимальное значение в массиве: " + max);
        int sum = 0;
        int k = 0;
        while (k < array.length) {
            sum += array[k];
            k++;
        }
        int average = sum / array.length;
        System.out.println("Среднее значение в массиве: " + average);
    }
}

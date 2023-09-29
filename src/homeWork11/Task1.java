package homeWork11;

public class Task1 {
    public static void main(String[] args) {

        //Task 1
        // Дан массив целых чисел.
        // Поменять местами элемент с максимальным и минимальным значением
        int[] num = new int[]{82, 37, 25, -81, 3, 0, 145, 17, 987};
        int x = 0;
        while (x < num.length) {
            System.out.print(num[x] + " ");
            x++;
        }
        System.out.println();
        int max = 0;
        int min = 0;
        x = 1;
        while (x < num.length) {
            if (num[x] > num[max]) {
                max = x;
            } else if (num[x] < num[min]) {
                min = x;
            }
            x++;
        }
        int temp = num[max];
        num[max] = num[min];
        num[min] = temp;
        x = 0;
        while (x < num.length) {
            System.out.print(num[x] + " ");
            x++;
        }
    }
}

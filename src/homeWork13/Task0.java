package homeWork13;



public class Task0 {
    public static void main(String[] args) {
      /*  Task 0

        Написать метод, принимающий массив целых чисел и
        распечатывающий массив в обратной последовательности.
        {1, 4, 3, 6, 7} -> распечатывает [7, 6, 3, 4, 1]
        Перегрузить метод, если в него приходит индекс, то часть
        массива слева до этого индекса распечатывается в обычном
        порядке, а начиная с этого индекса в обратном:
        {1, 4, 3, 6, 7} + индекс 2 - > распечатывает [1, 4, 7, 6, 3]
        Еще одна перегрузка: метод принимает массив и булевый флаг.
        Если флаг == true -> печатает массив в обратном порядке.
        Если флаг == false -> печатает массив в прямом порядке*/

        int[] arr = {1, 4, 3, 6, 7};
        printArrayReverse(arr);
        int index = 2;
        printArrayWithReversePartial(arr, index);
        boolean reverseFlag = true;
        printArrayWithFlag(arr, reverseFlag);
    }

    // Печатает массив в обратном порядке
    public static void printArrayReverse(int[] arr) {
        System.out.print("[");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
            if (i != 0) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Печатает массив с частью в прямом порядке и остатком в обратном порядке, начиная с индекса
    public static void printArrayWithReversePartial(int[] arr, int index) {
        System.out.print("[");
        for (int i = 0; i <= index; i++) {
            System.out.print(arr[i]);
            if (i != index) {
                System.out.print(", ");
            }
        }
        for (int i = arr.length - 1; i > index; i--) {
            System.out.print(", " + arr[i]);
        }
        System.out.println("]");
    }

    // Печатает массив в зависимости от булевого флага (true - в обратном порядке, false - в прямом порядке)
    public static void printArrayWithFlag(int[] arr, boolean reverseFlag) {
        if (reverseFlag) {
            printArrayReverse(arr);
        } else {
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                if (i != arr.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}





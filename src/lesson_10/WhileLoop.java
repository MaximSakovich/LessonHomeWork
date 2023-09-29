package lesson_10;

public class WhileLoop {
    public static void main(String[] args) {

        int x = 0;

        //  while (true) {
        //     System.out.println("Hello");
        // }
//x=11
        while (x <= 10) {// где y счетчик цикла

            System.out.println("X равен: " + x);
            x++;

        }
        System.out.println("Конец цикла while");

        int y = 100;
        while (y >= 90) {
            System.out.println(y--);
            y = y - 3;
        }
        System.out.println("y после цикла равен: " + y);//89
        //вывести все четные числа в диапазоне от 0 до 21

        int z = 0;

        while (z <= 21) {
            if (z != 0 && z % 2 == 0) {
                System.out.print(z + "; ");
            }
            z++;
        }
        System.out.println();
        System.out.println("z после цикла: " + z);
//do-while
        int a1 = 0;
        do {
            System.out.println(a1);
        } while (a1 < 0);
        System.out.println("end");


    }
}

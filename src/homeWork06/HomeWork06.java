package homeWork06;

import java.util.Scanner;

public class HomeWork06 {
    public static void main(String[] args) {
        //Task 00
        /* Создайте переменную типа int.
                Получите произвольное значение переменной из консоли (используем Scanner)
        Выведите строку в формате:
        Число: 6 четное: true; кратно 3: true; четное и кратное 3: true
        Число: 3 четное: false, кратно 3: true, четное и кратное 3: false
        (опционально) - учесть, что случайное число может оказаться 0
        */
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Число шесть: " + (number == 6));
        System.out.println("Число четное: " + ((number != 0) && (number % 2) == 0));
        System.out.println("Число кратное 3: " + ((number != 0) && ((number % 3) == 0)));
        System.out.println("Число четное и кратное трем: " +
                ((number != 0) && ((number % 2 == 0) & ((number % 3) == 0))));

        //Task 01
        /*со звездочкой Построчно сократить логическое выражения
        (соблюдая приоритетность операций)

        System.out.println((true | false) | (45 < 70) & !(true) ^ (6 == 5));

        Убедиться, что во всех выведенных
        строчках выводится одинаковое значение типа boolean
         */
        System.out.println((true | false) | (45 < 70) & !(true) ^ (6 == 5));//true
        System.out.println((true | false) | (true) & !(true) ^ (false));//true
        System.out.println((true | false) | (true) & false ^ (false));//true
        System.out.println((true | false) | false ^ (false));//true
        System.out.println((true | false) | false);//true
        System.out.println(true | false);//true
        System.out.println(true);//true
    }
}

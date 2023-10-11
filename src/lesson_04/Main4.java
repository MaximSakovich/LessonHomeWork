package lesson_04;

public class Main4 {
    public static void main(String[] args) {
        // объявляем переменные целых типов и потом их инициализируем
        int x;
        x = 10;
        int y;
        y = 5;
        int z;
        // складываем два числа и получаем третье, как сумму этих чисел
        z = x + y;

        // объявляем и инициализируем три строки
        String a = "Hello";
        String b = ", ";
        String c = "Marsel";
        // соединяем их с помощью операции конкатенации - получаем четвертую строку, которая объединяет все предыдущие
        String d = a + b + c;
        // выводим значения
        System.out.println(d);
        System.out.println(z);
    }
}
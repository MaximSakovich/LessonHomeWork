package lesson_04;

public class Main5 {
    public static void main(String[] args) {
        // создаем строку с текстом
        String message = "Hello, My name is Marsel, I'm ";
        // создаем число со значением
        int age = 29;
        // создаем еще одну строку с текстом
        String message2 = " years old, and my height is ";
        // создаем еще одно число со значением
        double height = 1.85;

//        String text = message + age + message2 + height;
//        System.out.println(text);
        // новая строка - это результат конкатенации строки и числа = строка
        String part1 = message + age;
        // печатаем ее в консоль
        System.out.println(part1);
        // аналогично предыдущему случаю
        String part2 = message2 + height;
        System.out.println(part2);
    }
}
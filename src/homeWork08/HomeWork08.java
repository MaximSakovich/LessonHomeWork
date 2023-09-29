package homeWork08;

import java.util.Random;
import java.util.Scanner;

public class HomeWork08 {
    public static void main(String[] args) {
        // Task 0
/*
         Перепишите решение задачи с использованием switch вместо if-else:
         Необходимо написать программу, где бы пользователю предлагалось
         ввести число на выбор: 1, 2 или 3, а программа должна сказать,
         какое число ввёл пользователь: 1, 2, или 3
*/
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Введите число на выбор 1, 2 или 3: ");
        number = scanner.nextInt();
        switch (number) {
            case 1:
                System.out.println("Вы ввели число один");
                break;
            case 2:
                System.out.println("Вы ввели число два");
                break;
            case 3:
                System.out.println("Вы ввели число три");
                break;
            default:
                System.out.println("Вы ввели неверное число");
        }

        //  Task 1 (Использовать оператор switch)
/*
        Программа просит пользователя ввести число от 1 до 7 Если число равно 1,
        выводим на консоль “Понедельник”, 2 –”Вторник” и так далее.
        Если 6 или 7 – “Выходной”.
*/
        Scanner scan = new Scanner(System.in);
        int number2;
        System.out.println("Введите число на выбор от 1 до 7: ");
        number2 = scan.nextInt();
        switch (number2) {
            case 1:
                System.out.println("Понедельник - Montag");
                break;
            case 2:
                System.out.println("Вторник - Dienstag");
                break;
            case 3:
                System.out.println("Среда - Mittwoch");
                break;
            case 4:
                System.out.println("Четверг - Donnerstag");
                break;
            case 5:
                System.out.println("Пятница - Freitag");
                break;
            case 6:
                System.out.println("Суббота - Samstag");
                break;
            case 7:
                System.out.println("Воскресенье - Sonntag");
                break;
            default:
                System.out.println("Вы ввели неверное число");
        }

        //   Task 2
        /*   Реализовать с использованием switch Ваш ребенок принес оценку
     за контрольную работу по математике. В школе 12 бальная система.
     Запишите в переменную случайное число от 0 до 12. Вы разрешаете ребенку
     смотреть телевизор не более 60 минут в день.
     (Оставшееся время не может быть больше 1 часа) На сегодня у него
     осталось 45 минут. (записать в переменную)
     Если оценка от 10 до 12 баллов -> Скажите ему, как вы рады и
     добавьте к оставшемуся на сегодня времени 1 час от 7 до 9 ->
     Слова похвалы на экран + ко времени 45 минут от 4 до 6 ->
     Нейтральные слова + ко времени 15 минут 3 -> Огорчитесь.
     Минус 30 минут ко времени оценка меньше -> Трагедия.
     Сегодня ТВ смотреть запрещено.
        Выведите на экран оставшееся на сегодня время для просмотра ТВ
        P.S. Реализовать с использованием switch
   */
        int maxball = 12 + 1;
        int minut = 45;
        Random random = new Random();
        int grade = random.nextInt(maxball);
        switch (grade) {
            case 1:
            case 2:
                minut -= minut;
                System.out.println("Сегодня ТВ смотреть запрещено!!!");
                break;
            case 3:
                minut -= 30;
                System.out.println("Плохо, от оставшегося на сегодня времени отнимаем 30 минут\n" +
                        "Оставшееся время просмотра ТВ " + minut + " минут");
                break;
            case 4:
            case 5:
            case 6:
                minut += 15;
                System.out.println("Добавляем к оставшемуся на сегодня времени 15 минут\n" +
                        "Оставшееся время просмотра ТВ " + minut + " минут");
                break;
            case 7:
            case 8:
            case 9:
                minut += 45;
                System.out.println("Молодец!!! Мы рады добавить к оставшемуся на сегодня времени 45 минут\n" +
                        "Оставшееся время просмотра ТВ " + minut + " минут");
                break;
            case 10:
            case 11:
            case 12:
                minut += 60;
                System.out.println("Отличник!!! Мы рады добавить к оставшемуся на сегодня времени 1 час\n" +
                        "Оставшееся время просмотра ТВ " + minut + " минут");
                break;
            default:
                System.out.println("Ты не принес сегодня оценки\n" +
                        "Оставшееся время просмотра ТВ " + minut + " минут");
        }
    }
}

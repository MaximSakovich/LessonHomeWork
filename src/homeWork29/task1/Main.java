package homeWork29.task1;

/*Task 1
Создайте интерфейсы Swimmer и Runner с методами swim и run соответственно.
Реализуйте класс Triathlete, который будет реализовывать оба интерфейса.
Убедитесь, что класс Triathlete корректно выполняет действия, связанные с бегом и плаванием.
*/
public class Main {
    public static void main(String[] args) {
        Triathlete triathlete = new Triathlete();
        triathlete.swim();
        triathlete.run();
    }
}

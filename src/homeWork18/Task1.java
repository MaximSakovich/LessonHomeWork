package homeWork18;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя собаки: ");
        String dogName = scanner.nextLine();
        System.out.print("Введите начальную высоту прыжка собаки: ");
        int jumpHeight = scanner.nextInt();
        int increasingBarrier = 10;
        int maxBarriers = (jumpHeight / increasingBarrier) + 1; // Максимальное количество барьеров

        Dog dog = new Dog(dogName, jumpHeight, increasingBarrier);

        int[] barriers = new int[maxBarriers + 1];
        for (int i = 0; i < barriers.length; i++) {
            barriers[i] = jumpHeight + i * increasingBarrier;

            System.out.println(dogName + " пытается перепрыгнуть барьер высотой " + barriers[i] + " см.");
            dog.jump(barriers[i]);
            System.out.println();

            if (!dog.canJump(barriers[i])) {
                if (dog.canJump(barriers[maxBarriers])) {
                    System.out.println(dogName + " полностью натренирован и перепрыгивает барьер высотой " + barriers[i]
                            + " см. теперь высота барьера увеличивается на " + increasingBarrier + " см.");
                    dog.train();
                    System.out.println();
                } else {
                    System.out.println("Хватит издеваться на до мной, не в моих силах перепрыгнуть барьер высотой " + barriers[i] + " см.");
                    break;
                }
            }
        }
        scanner.close();
    }
}

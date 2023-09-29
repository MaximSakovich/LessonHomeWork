package homeWork18;

public class Task1 {
    public static void main(String[] args) {
        Dog dog = new Dog("Бобик", 100);

        // Создаем массив барьеров, начиная с 100 см и увеличиваясь с шагом 10 см,
        // но не более чем в 2 раза первоначального барьера
        int[] barriers = new int[20];
        for (int i = 0; i < barriers.length; i++) {
            barriers[i] = dog.jumpHeight + i * 10;

            System.out.println("Пытаемся перепрыгнуть барьер высотой " + barriers[i] + " см:");
            dog.jump(barriers[i]);
            System.out.println();

            if (!dog.canJump(barriers[i])) {
                if (dog.canJump(barriers[10])) {
                    System.out.println("Идет тренироваться...");
                    dog.train();
                    System.out.println();
                } else {
                    System.out.println("Я полностью натренирован и выше не смогу взять барьер уже.");
                    break;
                }
            }
        }
        }
    }

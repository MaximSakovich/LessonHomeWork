package homeWork18;

public class Task0 {

    /*public class Dog {
    String name;
    int jumpHeight;
    private boolean fullyTrained;
    //public String getName() {
    //   return name;
    //  }

    public Dog(String name, int jumpHeight) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.fullyTrained = false;
    }

    // Метод для тренировки собаки
    public void train() {
        if (jumpHeight * 2 < 100) {
            jumpHeight += 10;
        } else {
            fullyTrained = true;
        }
    }

    // Метод для проверки способности собаки прыгать
    public boolean canJump(int barrierHeight) {
        return jumpHeight >= barrierHeight;
    }

    // Метод для выполнения прыжка собакой
    public void jump(int barrierHeight) {
        if (canJump(barrierHeight)) {
            System.out.println(name + " перепрыгнул барьер высотой " + barrierHeight + " см.");
        } else {
            System.out.println(name + " не может перепрыгнуть барьер высотой " + barrierHeight + " см.");
            if (fullyTrained) {
                System.out.println(name + " идет тренироваться...");
            } else {
                System.out.println(name + " может тренироваться, чтобы перепрыгнуть барьер.");
            }
        }
    }
}

*/

/*public class Task1 {
    public static void main(String[] args) {
        Dog dog = new Dog("Бобик", 100);

        int[] barriers = new int[20];
        for (int i = 0; i < barriers.length; i++) {
            barriers[i] = dog.jumpHeight + i * 10;

            System.out.println(dog.name + " пытается перепрыгнуть барьер высотой " + barriers[i] + " см:");
            dog.jump(barriers[i]);
            System.out.println();

            if (!dog.canJump(barriers[i])) {
                if (dog.canJump(barriers[10])) {
                    System.out.println(dog.name + " полностью натренирован и перепрыгивает барьер высотой " + barriers[i] + " см:");
                    dog.train();
                    System.out.println();
                } else {
                    System.out.println("Хватит издеваться на до мной, не в моих силах перепрыгнуть барьер высотой " + barriers[i] + " см:");
                    break;
                }
            }
        }
    }
}
 */

}

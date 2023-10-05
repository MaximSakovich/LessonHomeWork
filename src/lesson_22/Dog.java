package lesson_22;

public class Dog {
    static final int INCREASEPERONETRAINING = 10;
    private String name;
    private int jumpHeight;

    // private int increasePerOneTraining;
    private int maxJumpHeight;

    public Dog(String name, int jumpHeight) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        // this.INCREASEPERONETRAINING = 10;
        this.maxJumpHeight = jumpHeight * 2;
    }

    public void jump() {
        System.out.println(name + " прыгнула!");
    }

    public void train() {

        if (jumpHeight < maxJumpHeight) {
            jumpHeight += INCREASEPERONETRAINING;
        }

        if (jumpHeight > maxJumpHeight) {
            jumpHeight = maxJumpHeight;
        }

    }

    public boolean takeBarrier(int barrier) {
        // Текущий прыжок vs барьер?
        if (jumpHeight >= barrier) {
            jump();
            return true;
        }

        if (maxJumpHeight >= barrier) {
            // собачка может. Надо тренироваться
            System.out.println(name + " идет тренироваться");
            while (jumpHeight < barrier) {
                train();
            }
            jump();
            System.out.printf("Собака %s перепрыгивает барьер: %d!\n", name, barrier);
            System.out.println("Текущий прыжок: " + jumpHeight);

            return true;

        } else {
            System.out.printf("Барьер высотой %d собака %s взять не может!\n", barrier, name);
            System.out.println("Текущий прыжок: " + jumpHeight);
            return false;
        }

    }

    public String getName() {
        return name;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public String toString() {
        return "Dog " + name + "; current jump: " + jumpHeight;
    }
}



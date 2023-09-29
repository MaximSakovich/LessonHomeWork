package homeWork18;


public class Dog {
    private String name;
    int jumpHeight;
    boolean fullyTrained;

    public Dog(String name, int jumpHeight) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.fullyTrained = false;
    }

    public void train() {
        if (jumpHeight * 2 < 100) {
            jumpHeight += 10;
            System.out.println(name + " тренируется. Текущая высота прыжка: " + jumpHeight + " см");
        } else {
            System.out.println(name + " не может тренироваться дальше.");
            fullyTrained = true;
        }
    }

    public boolean canJump(int barrierHeight) {
        return jumpHeight >= barrierHeight;
    }

    public void jump(int barrierHeight) {
        if (canJump(barrierHeight)) {
            System.out.println(name + " перепрыгнул барьер высотой " + barrierHeight + " см.");
        } else {
            System.out.println(name + " не может перепрыгнуть барьер высотой " + barrierHeight + " см.");
            if (fullyTrained) {
                System.out.println(name + " полностью натренирован и не может взять барьер выше.");
            } else {
                System.out.println(name + " может тренироваться, чтобы перепрыгнуть барьер.");
            }
        }
    }

}






















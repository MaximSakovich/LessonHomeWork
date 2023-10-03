package homeWork18;

public class Dog {
    /*Написать класс Собака. Собака должна иметь имя и высоту прыжка Должна уметь прыгать
     и должна уметь тренироваться. За каждую тренировку высота прыжка увеличивается на 10
     сантиметров Максимальная высота, которую может натренировать собака не может быть больше,
     чем 2 раза высоту первоначального прыжка.
     Также должен быть метод взять барьер. В параметрах метод принимает высоту прыжка.
     Если собака в состоянии преодолеть этот барьер - прыгает. Если не в состоянии,
     нужно проверить помогут ли тренировки (будет ли данная собака в принципе в
     состоянии взять барьер). Если да -> идем тренироваться -> берет барьер
    */

    public String dogName;
    public int jumpHeight;
    public int increasingBarrier;
    private boolean fullyTrained;

    public Dog(String dogName, int jumpHeight, int increasingBarrier) {
        this.dogName = dogName;
        this.jumpHeight = jumpHeight;
        this.increasingBarrier = increasingBarrier;
        this.fullyTrained = false;
    }

    // Метод для тренировки собаки
    public void train() {
        if (jumpHeight * 2 < jumpHeight) {
            jumpHeight += increasingBarrier;
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
            System.out.println(dogName + " перепрыгнул барьер высотой " + barrierHeight +
                    " см. теперь высота барьера увеличивается на " + increasingBarrier + " см.");
        } else {
            System.out.println(dogName + " не может перепрыгнуть барьер высотой " + barrierHeight + " см.");
            if (fullyTrained) {
                System.out.println(dogName + " идет тренироваться...");
            } else {
                System.out.println(dogName + " может тренироваться, чтобы перепрыгнуть барьер " + barrierHeight + " см.");
            }
        }
    }
}
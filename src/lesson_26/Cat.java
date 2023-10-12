package lesson_26;

public class Cat extends Animal {

    public Cat(){
        super("Fgfgff");
    }

    @Override
    public void sound(){
        System.out.println("Cat say Meow!");
    }

    public void sayHello() {
        System.out.println("Hello from Cat");
    }
}
package lesson_27.abstracts;

public class Dog extends Animal{



    @Override
    public void move() {
        System.out.println("Dog двигается");
    }


    @Override
    void eat()  {

    }

    @Override
    public void sayHello() {
        System.out.println("Hello from Dog");
    }
}

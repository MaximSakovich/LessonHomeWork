package lesson_27.abstracts;

import java.util.Objects;

abstract class Animal {

    // Абстрактный метод не имеет реализации (тела метода)
    abstract void move();
    abstract void eat();




    // в абстрактном классе могут присутствовать "обычные" методы с реализацией
    public void sayHello() {
        System.out.println("Hello from animal");
    }


}
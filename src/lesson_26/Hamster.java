package lesson_26;

public class Hamster extends Animal{

//    public Hamster(){
//        super();
//    }

    @Override
    public void sound() {
        System.out.println("Hamster say hrum-hrum");
    }

    @Override
    public String toString() {
        return "Хомяк";
    }
}
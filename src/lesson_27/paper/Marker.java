package lesson_27.paper;

public class Marker extends Pen{
    @Override
    public void draw(String figure) {
        System.out.println("Рисую " + figure + " маркером");
    }
}

package lesson_27.paper;

public class Brush extends Pen {

    @Override
    public void draw(String figure) {
        System.out.println("Кисть рисует красками " + figure);
    }
}
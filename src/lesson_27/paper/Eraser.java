package lesson_27.paper;

public class Eraser extends Pen{
    @Override
    public void draw(String figure) {
        System.out.println("Стираю фигуру " + figure);
    }
}
package lesson_27.paper;

public class Pencil extends Pen{
    @Override
    public void draw(String figure) {
        System.out.println("Рисую карандашом " + figure);
    }
}
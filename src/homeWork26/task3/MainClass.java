package homeWork26.task3;

public class MainClass {
    public static void main(String[] args) {
        Figure[] figures = new Figure[3];
        figures[0] = new Circle(5.0);
        figures[1] = new Square(4.0);
        figures[2] = new Triangle(6.0, 3.0);

        for (Figure figure : figures) {
            System.out.println(figure.toString());
        }

    }
}

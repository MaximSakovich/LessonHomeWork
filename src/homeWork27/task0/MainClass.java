package homeWork27.task0;

/*Task 0 Создайте абстрактный класс Shape с абстрактными методами для
вычисления площади и периметра. Реализуйте классы-наследники
Circle, Rectangle, и Triangle. Убедитесь, что все классы
правильно вычисляют площадь и периметр. Создайте массив объектов Shape
и вычислите общую площадь и периметр всех фигур в массиве.
*/

public class MainClass {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5),
                new Rectangle(4, 5),
                new Triangle(3, 4, 5),
                new Square(4)
        };
        double totalArea = 0;
        double totalPerimeter = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
            totalPerimeter += shape.getPerimeter();
        }
        System.out.printf("Общая площадь равна: %.2f кв.см", totalArea);
        System.out.println();
        System.out.printf("Общий периметр равен: %.2f см", totalPerimeter);
        System.out.println();
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
    }
}

package homeWork27.task0;

class Square extends Shape {
    private final double side;
    public Square(double side) {
        this.side = side;
    }
    @Override
    public double getArea() {return side * side;}
    @Override
    public double getPerimeter() {
        return 2 * (side + side);
    }
    @Override
    public String toString() {
        return String.format("Квадрат площадью: %.2f кв.см", getArea());
    }
}
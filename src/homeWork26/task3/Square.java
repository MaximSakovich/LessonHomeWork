package homeWork26.task3;

class Square extends Figure {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
    @Override
    public String toString() {
        return String.format("Квадрат площадью %.2f кв.см", calculateArea());
    }

}
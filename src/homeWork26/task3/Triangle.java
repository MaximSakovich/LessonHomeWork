package homeWork26.task3;

class Triangle extends Figure {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return String.format("Треугольник площадью %.2f кв.см", calculateArea());
    }

}

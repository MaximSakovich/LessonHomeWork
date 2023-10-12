package homeWork26;

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
    public String getDescription() {
        return String.format("Треугольник площадью %.2f кв.см", calculateArea());
    }


}

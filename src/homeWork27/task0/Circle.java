package homeWork27.task0;

class Circle extends Shape {
    private final double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() { return Math.PI * radius * radius; }
    @Override
    public double getPerimeter() {
        return Math.PI * (radius + radius);
    }
    @Override
    public String toString() {
        return String.format("Круг площадью: %.2f кв.см", getArea());
    }
}
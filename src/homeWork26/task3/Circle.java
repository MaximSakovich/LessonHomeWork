package homeWork26.task3;

class Circle extends Figure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public String toString() {
        return String.format("Круг площадью %.2f кв.см", calculateArea());
    }
}
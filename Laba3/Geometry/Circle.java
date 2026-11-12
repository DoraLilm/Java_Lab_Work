package Laba3.Geometry;

// Круг
public class Circle extends Figure {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException(
                    "Радиус должен быть больше 0"
            );
        }

        this.center = center.clone();
        this.radius = radius;
    }

    public Point getCenter() {
        return center.clone();
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle(center=" + center
                + ", r=" + radius + ")";
    }
}
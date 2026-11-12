package Laba3.Geometry;

// Прямоугольник
public class Rectangle extends Figure {
    private Point topLeft;
    private double width;
    private double height;

    public Rectangle(
            Point topLeft,
            double width,
            double height
    ) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                    "Стороны должны быть больше 0"
            );
        }

        this.topLeft = topLeft.clone();
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle(" + topLeft
                + ", w=" + width
                + ", h=" + height + ")";
    }
}
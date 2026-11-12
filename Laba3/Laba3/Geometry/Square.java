package Laba3.Geometry;

// Квадрат
public class Square extends Figure
        implements PolygonalChainProvider {

    private Point topLeft;
    private double side;

    public Square(Point topLeft, double side) {
        if (side <= 0) {
            throw new IllegalArgumentException(
                    "Сторона должна быть больше 0"
            );
        }

        this.topLeft = topLeft.clone();
        this.side = side;
    }

    public Square(int x, int y, double side) {
        this(new Point(x, y), side);
    }

    public Point getTopLeft() {
        return topLeft.clone();
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException(
                    "Сторона должна быть больше 0"
            );
        }

        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public Polyline getPolygonalChain() {
        int x = topLeft.getX();
        int y = topLeft.getY();
        int s = (int) side;

        return new Polyline(new Point[]{
                new Point(x, y),
                new Point(x + s, y),
                new Point(x + s, y + s),
                new Point(x, y + s),
                new Point(x, y)
        });
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft
                + " со стороной " + side;
    }
}
package Laba3.Geometry;

// Треугольник
public class Triangle extends Figure
        implements PolygonalChainProvider {

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a.clone();
        this.b = b.clone();
        this.c = c.clone();
    }

    @Override
    public double area() {
        double result =
                (b.getX() - a.getX()) * (c.getY() - a.getY())
                        - (c.getX() - a.getX()) * (b.getY() - a.getY());

        return Math.abs(result) / 2.0;
    }

    @Override
    public Polyline getPolygonalChain() {
        return new Polyline(
                new Point[]{a, b, c, a}
        );
    }

    @Override
    public String toString() {
        return "Triangle[" + a + ", " + b + ", " + c + "]";
    }
}
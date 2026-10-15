package Laba3;

// --- интерфейсы ---

interface LengthMeasurable {
    double getLength();
}

interface PolygonalChainProvider {
    Polyline getPolygonalChain();
}

// --- абстрактная фигура ---

abstract class Figure {
    public abstract double area();
}

// --- точка ---

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public double distanceTo(Point other) {
        int dx = this.x - other.x;
        int dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }

    @Override
    public Point clone() {
        return new Point(this.x, this.y);
    }
}

// --- ломаная ---

class Polyline implements LengthMeasurable, PolygonalChainProvider {
    protected Point[] points;

    public Polyline(Point[] points) {
        if (points == null || points.length < 2) {
            throw new IllegalArgumentException("Нужно минимум 2 точки");
        }
        this.points = points;
    }

    public Point[] getPoints() { return points; }
    public Point getPoint(int index) { return points[index]; }
    public void setPoint(int index, Point p) { points[index] = p; }

    @Override
    public double getLength() {
        double len = 0;
        for (int i = 0; i < points.length - 1; i++) {
            len += points[i].distanceTo(points[i + 1]);
        }
        return len;
    }

    @Override
    public Polyline getPolygonalChain() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polyline)) return false;
        Polyline other = (Polyline) o;
        if (points.length != other.points.length) return false;
        for (int i = 0; i < points.length; i++) {
            if (!points[i].equals(other.points[i])) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Polyline[");
        for (int i = 0; i < points.length; i++) {
            sb.append(points[i]);
            if (i < points.length - 1) sb.append(" -> ");
        }
        return sb.append("]").toString();
    }
}

// --- замкнутая ломаная ---

class ClosedPolyline extends Polyline {
    public ClosedPolyline(Point[] points) {
        super(points);
    }

    @Override
    public double getLength() {
        double len = super.getLength();
        len += points[points.length - 1].distanceTo(points[0]);
        return len;
    }
}

// --- линия ---

class Line implements LengthMeasurable, PolygonalChainProvider {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = new Point(start.getX(), start.getY());
        this.end = new Point(end.getX(), end.getY());
    }

    public Point getStart() { return start; }
    public Point getEnd() { return end; }

    public void setStart(Point p) { this.start = new Point(p.getX(), p.getY()); }
    public void setEnd(Point p) { this.end = new Point(p.getX(), p.getY()); }

    @Override
    public double getLength() {
        return start.distanceTo(end);
    }

    @Override
    public Polyline getPolygonalChain() {
        return new Polyline(new Point[]{start, end});
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line l = (Line) o;
        return start.equals(l.start) && end.equals(l.end);
    }

    @Override
    public String toString() {
        return "Line[" + start + " -> " + end + "]";
    }
}

// --- квадрат ---

class Square extends Figure implements PolygonalChainProvider {
    private Point topLeft;
    private double side;

    public Square(Point topLeft, double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона должна быть > 0");
        }
        this.topLeft = topLeft;
        this.side = side;
    }

    public Square(int x, int y, double side) {
        this(new Point(x, y), side);
    }

    public Point getTopLeft() { return topLeft; }
    public double getSide() { return side; }

    public void setSide(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона должна быть > 0");
        }
        this.side = side;
    }

    // метод из абстрактного класса Figure
    @Override
    public double area() {
        return side * side;
    }

    // метод из интерфейса PolygonalChainProvider
    @Override
    public Polyline getPolygonalChain() {
        Point p1 = topLeft;
        Point p2 = new Point(topLeft.getX() + (int) side, topLeft.getY());
        Point p3 = new Point(topLeft.getX() + (int) side, topLeft.getY() + (int) side);
        Point p4 = new Point(topLeft.getX(), topLeft.getY() + (int) side);
        return new Polyline(new Point[]{p1, p2, p3, p4});
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft + " со стороной " + side;
    }
}

// --- круг ---

class Circle extends Figure {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Радиус должен быть > 0");
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() { return center; }
    public double getRadius() { return radius; }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle(center=" + center + ", r=" + radius + ")";
    }
}

// --- прямоугольник ---

class Rectangle extends Figure {
    private Point topLeft;
    private double width, height;

    public Rectangle(Point topLeft, double width, double height) {
        if (width <= 0 || height <= 0) throw new IllegalArgumentException("Стороны должны быть > 0");
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() { return width * height; }

    @Override
    public String toString() {
        return "Rectangle(" + topLeft + ", w=" + width + ", h=" + height + ")";
    }
}

// --- треугольник ---

class Triangle extends Figure implements PolygonalChainProvider {
    private Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a; this.b = b; this.c = c;
    }

    @Override
    public double area() {
        return Math.abs((b.getX() - a.getX()) * (c.getY() - a.getY())
                - (c.getX() - a.getX()) * (b.getY() - a.getY())) / 2.0;
    }

    @Override
    public Polyline getPolygonalChain() {
        return new Polyline(new Point[]{a, b, c});
    }

    @Override
    public String toString() {
        return "Triangle[" + a + ", " + b + ", " + c + "]";
    }
}
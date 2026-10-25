
package Laba3.Geometry;

import java.util.Arrays;

// Интерфейс для объектов, у которых можно измерить длину.
public class Models {

    public interface LengthMeasurable {
        double getLength();
    }

    // Интерфейс для объектов, которые можно представить ломаной.
    public interface PolygonalChainProvider {
        Polyline getPolygonalChain();
    }

    public abstract static class Figure {
        public abstract double area();
    }

    // Точка на координатной плоскости.
    public static class Point implements Cloneable {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public double distanceTo(Point other) {
            int dx = x - other.x;
            int dy = y - other.y;

            return Math.sqrt(dx * dx + dy * dy);
        }

        @Override
        public Point clone() {
            return new Point(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Point)) {
                return false;
            }

            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }

        @Override
        public String toString() {
            return "{" + x + ";" + y + "}";
        }
    }

    // Обычная ломаная.
    public static class Polyline
            implements LengthMeasurable, PolygonalChainProvider {

        protected Point[] points;

        public Polyline(Point[] points) {
            if (points == null || points.length < 2) {
                throw new IllegalArgumentException(
                        "Нужно минимум 2 точки"
                );
            }

            this.points = new Point[points.length];

            for (int i = 0; i < points.length; i++) {
                this.points[i] = points[i].clone();
            }
        }

        public Point[] getPoints() {
            Point[] copy = new Point[points.length];

            for (int i = 0; i < points.length; i++) {
                copy[i] = points[i].clone();
            }

            return copy;
        }

        public Point getPoint(int index) {
            return points[index].clone();
        }

        public void setPoint(int index, Point point) {
            points[index] = point.clone();
        }

        @Override
        public double getLength() {
            double length = 0;

            for (int i = 0; i < points.length - 1; i++) {
                length += points[i].distanceTo(points[i + 1]);
            }

            return length;
        }

        @Override
        public Polyline getPolygonalChain() {
            return new Polyline(points);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Polyline)) {
                return false;
            }

            Polyline other = (Polyline) obj;

            if (points.length != other.points.length) {
                return false;
            }

            for (int i = 0; i < points.length; i++) {
                if (!points[i].equals(other.points[i])) {
                    return false;
                }
            }

            return true;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(points);
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("Polyline[");

            for (int i = 0; i < points.length; i++) {
                result.append(points[i]);

                if (i < points.length - 1) {
                    result.append(" -> ");
                }
            }

            return result.append("]").toString();
        }
    }

    // Замкнутая ломаная: последняя точка соединяется с первой.
    public static class ClosedPolyline extends Polyline {

        public ClosedPolyline(Point[] points) {
            super(points);
        }

        @Override
        public double getLength() {
            double length = super.getLength();

            length += points[points.length - 1]
                    .distanceTo(points[0]);

            return length;
        }
    }

    // Отрезок между двумя точками.
    public static class Line
            implements LengthMeasurable, PolygonalChainProvider {

        private Point start;
        private Point end;

        public Line(Point start, Point end) {
            this.start = start.clone();
            this.end = end.clone();
        }

        public Point getStart() {
            return start.clone();
        }

        public Point getEnd() {
            return end.clone();
        }

        public void setStart(Point point) {
            start = point.clone();
        }

        public void setEnd(Point point) {
            end = point.clone();
        }

        @Override
        public double getLength() {
            return start.distanceTo(end);
        }

        @Override
        public Polyline getPolygonalChain() {
            return new Polyline(
                    new Point[]{start, end}
            );
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Line)) {
                return false;
            }

            Line line = (Line) obj;

            return start.equals(line.start)
                    && end.equals(line.end);
        }

        @Override
        public int hashCode() {
            return 31 * start.hashCode() + end.hashCode();
        }

        @Override
        public String toString() {
            return "Line[" + start + " -> " + end + "]";
        }
    }

    // Квадрат.
    public static class Square extends Figure
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

    // Круг.
    public static class Circle extends Figure {
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

    // Прямоугольник.
    public static class Rectangle extends Figure {
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

    // Треугольник.
    public static class Triangle extends Figure
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
}

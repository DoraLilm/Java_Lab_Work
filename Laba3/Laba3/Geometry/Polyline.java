package Laba3.Geometry;

import java.util.Arrays;

// Ломаная
public class Polyline
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
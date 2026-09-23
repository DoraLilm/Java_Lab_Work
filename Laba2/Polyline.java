package Laba2;

import java.util.Arrays;

public class Polyline {

    private Point[] points;

    public Polyline() {
        points = new Point[0];
    }

    public Polyline(Point... points) {
        this.points = points;
    }

    public void addPoints(Point... newPoints) {

        Point[] newArray = new Point[
                points.length + newPoints.length
                ];

        for (int i = 0; i < points.length; i++) {
            newArray[i] = points[i];
        }

        for (int i = 0; i < newPoints.length; i++) {
            newArray[points.length + i] = newPoints[i];
        }

        points = newArray;
    }

    public double getLength() {

        double length = 0;

        for (int i = 0; i < points.length - 1; i++) {

            int dx = points[i + 1].getX() - points[i].getX();
            int dy = points[i + 1].getY() - points[i].getY();

            length += Math.sqrt(dx * dx + dy * dy);
        }

        return length;
    }

    @Override
    public String toString() {
        return "Линия " + Arrays.toString(points);
    }
}
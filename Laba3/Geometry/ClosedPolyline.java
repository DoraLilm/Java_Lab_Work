package Laba3.Geometry;

// Замкнутая ломаная   последняя точка соединяется с первой
public class ClosedPolyline extends Polyline {

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
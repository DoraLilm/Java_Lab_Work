package Laba3.Geometry;

// Отрезок между двумя точками
public class Line
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
package Laba3.Main;

import Laba3.Geometry.*;

import java.util.ArrayList;
import java.util.List;

public class TaskMethods {

    public static double totalArea(Figure[] figures) {
        double sum = 0;

        for (Figure figure : figures) {
            sum += figure.area();
        }

        return sum;
    }

    public static double sumLengths(LengthMeasurable[] objects) {
        double sum = 0;

        for (LengthMeasurable object : objects) {
            sum += object.getLength();
        }

        return sum;
    }

    public static Polyline mergeAll(
            PolygonalChainProvider[] providers
    ) {
        List<Point> points = new ArrayList<>();

        for (PolygonalChainProvider provider : providers) {
            Point[] chainPoints =
                    provider.getPolygonalChain().getPoints();

            for (Point point : chainPoints) {
                points.add(point);
            }
        }

        return new Polyline(points.toArray(new Point[0]));
    }
}
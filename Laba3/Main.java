package Laba3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- 1.3 Квадрат ---
        System.out.println("=== Задание 1.3: Квадрат ===");
        Square sq = new Square(5, 3, 23);
        System.out.println(sq);
        Polyline poly = sq.getPolygonalChain();
        System.out.println("Длина ломаной: " + poly.getLength());

        poly.setPoint(poly.getPoints().length - 1, new Point(15, 25));
        System.out.println("После сдвига последней точки: " + poly.getLength());

        try {
            sq.setSide(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Защита сработала: " + e.getMessage());
        }

        // --- 2.4 Бинарное дерево ---
        System.out.println("\n=== Задание 2.4: Бинарное дерево ===");
        BinaryNode tree = new BinaryNode();
        for (int v : new int[]{3, 5, 4, 7, 1, 2}) tree.add(v);
        System.out.println("Дерево: " + tree);
        System.out.println("Содержит 4? " + tree.contains(4));
        tree.remove(3);
        System.out.println("После удаления 3: " + tree);

        // --- 3.2 Замкнутая ломаная ---
        System.out.println("\n=== Задание 3.2: Замкнутая ломаная ===");
        ClosedPolyline cp = new ClosedPolyline(new Point[]{
                new Point(0, 0), new Point(3, 0), new Point(3, 4)
        });
        System.out.println("Длина замкнутой: " + cp.getLength());

        // --- 4.4 Фигуры ---
        System.out.println("\n=== Задание 4.4: Фигуры ===");
        Figure[] figures = {
                new Circle(new Point(0, 0), 5),
                new Square(new Point(0, 0), 4),
                new Rectangle(new Point(0, 0), 3, 7),
                new Triangle(new Point(0,0), new Point(4,0), new Point(0,3))
        };
        System.out.println("Общая площадь: " + totalArea(figures));

        // --- 5.5 Измерение длины ---
        System.out.println("\n=== Задание 5.5: Измерение длины ===");
        LengthMeasurable[] measurable = {
                new Line(new Point(0,0), new Point(3,4)),
                new Polyline(new Point[]{new Point(0,0), new Point(1,1), new Point(2,0)})
        };
        System.out.println("Сумма длин: " + sumLengths(measurable));

        // --- 5.7 Объединение ломаных ---
        System.out.println("\n=== Задание 5.7: Объединение ломаных ===");
        PolygonalChainProvider[] providers = {
                sq,
                new Line(new Point(0,0), new Point(10,10)),
                new Triangle(new Point(0,0), new Point(1,0), new Point(0,1))
        };
        Polyline merged = mergeAll(providers);
        System.out.println("Объединённая ломаная: " + merged);

        // --- 6.4 Сравнение ломаных ---
        System.out.println("\n=== Задание 6.4: equals для ломаных ===");
        Polyline p1 = new Polyline(new Point[]{new Point(0,0), new Point(1,1)});
        Polyline p2 = new Polyline(new Point[]{new Point(0,0), new Point(1,1)});
        System.out.println("p1.equals(p2): " + p1.equals(p2));

        // --- 7.3 Степень через static import ---
        System.out.println("\n=== Задание 7.3: Возведение в степень ===");
        System.out.print("Введите X: ");
        String x = sc.nextLine();
        System.out.print("Введите Y: ");
        String y = sc.nextLine();
        try {
            System.out.println(x + " ^ " + y + " = " + power(x, y));
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: нужно вводить числа");
        }

        // --- 8.4 Клонирование точки ---
        System.out.println("\n=== Задание 8.4: Клонирование точки ===");
        Point original = new Point(7, 8);
        Point copy = original.clone();
        copy.setX(100);
        System.out.println("Оригинал: " + original + ", копия: " + copy);

        sc.close();
    }

    public static double totalArea(Figure[] figs) {
        double sum = 0;
        for (Figure f : figs) sum += f.area();
        return sum;
    }

    public static double sumLengths(LengthMeasurable[] objs) {
        double sum = 0;
        for (LengthMeasurable o : objs) sum += o.getLength();
        return sum;
    }

    public static Polyline mergeAll(PolygonalChainProvider[] providers) {
        List<Point> all = new ArrayList<>();
        for (PolygonalChainProvider p : providers) {
            for (Point pt : p.getPolygonalChain().getPoints()) {
                all.add(new Point(pt.getX(), pt.getY()));
            }
        }
        return new Polyline(all.toArray(new Point[0]));
    }

    public static double power(String x, String y) {
        return pow(parseInt(x), parseInt(y));
    }
}
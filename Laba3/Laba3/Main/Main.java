package Laba3.Main;

import Laba3.Geometry.*;
import Laba3.Tree.BinaryNode;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Main {

    public static double power(String x, String y) {
        return pow(parseInt(x), parseInt(y));
    }

    public static void main(String[] args) {

        // Задание 1. Номер 3. Квадрат.
        System.out.println(" Задание 1. Номер 3. Квадрат ");

        Square square = new Square(5, 3, 23);

        System.out.println(square);
        System.out.println("Площадь квадрата: " + square.area());

        Polyline squareChain = square.getPolygonalChain();

        System.out.println(
                "Ломаная квадрата: " + squareChain
        );
        System.out.println(
                "Длина ломаной: " + squareChain.getLength()
        );

        squareChain.setPoint(
                squareChain.getPoints().length - 1,
                new Point(15, 25)
        );

        System.out.println(
                "После изменения точки: " + squareChain.getLength()
        );

        try {
            square.setSide(-5);
        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Проверка стороны: " + e.getMessage()
            );
        }

        // Задание 2. Номер 4. Бинарное дерево.
        System.out.println("\n Задание 2. Номер 4. Бинарное дерево ");

        BinaryNode tree = new BinaryNode();

        for (int number : new int[]{3, 5, 4, 7, 1, 2}) {
            tree.add(number);
        }

        System.out.println("Дерево: " + tree);
        System.out.println("Содержит 4: " + tree.contains(4));

        tree.remove(3);

        System.out.println("После удаления 3: " + tree);

        // Задание 3. Номер 2. Замкнутая ломаная.
        System.out.println("\n Задание 3. Номер 2. Замкнутая ломаная ");

        ClosedPolyline closedPolyline = new ClosedPolyline(
                new Point[]{
                        new Point(0, 0),
                        new Point(3, 0),
                        new Point(3, 4)
                }
        );

        System.out.println(
                "Замкнутая ломаная: " + closedPolyline
        );
        System.out.println(
                "Длина: " + closedPolyline.getLength()
        );

        // Задание 4. Номер 4. Фигуры.
        System.out.println("\n Задание 4. Номер 4. Фигуры ");

        Figure[] figures = {
                new Circle(new Point(0, 0), 5),
                new Square(new Point(0, 0), 4),
                new Rectangle(new Point(0, 0), 3, 7),
                new Triangle(
                        new Point(0, 0),
                        new Point(4, 0),
                        new Point(0, 3)
                )
        };

        for (Figure figure : figures) {
            System.out.println(
                    figure + ", площадь = " + figure.area()
            );
        }

        System.out.println(
                "Общая площадь: " + TaskMethods.totalArea(figures)
        );

        // Задание 5. Номер 5. Измерение длины.
        System.out.println("\n Задание 5. Номер 5. Измерение длины ");

        LengthMeasurable[] measurable = {
                new Line(
                        new Point(0, 0),
                        new Point(3, 4)
                ),
                new Polyline(
                        new Point[]{
                                new Point(0, 0),
                                new Point(1, 1),
                                new Point(2, 0)
                        }
                ),
                closedPolyline
        };

        for (LengthMeasurable object : measurable) {
            System.out.println("Длина: " + object.getLength());
        }

        System.out.println(
                "Сумма длин: " + TaskMethods.sumLengths(measurable)
        );

        // Задание 5. Номер 7. Объединение ломаных.
        System.out.println("\n Задание 5. Номер 7. Объединение ломаных ");

        PolygonalChainProvider[] providers = {
                square,
                new Line(
                        new Point(0, 0),
                        new Point(10, 10)
                ),
                new Triangle(
                        new Point(0, 0),
                        new Point(1, 0),
                        new Point(0, 1)
                )
        };

        Polyline merged = TaskMethods.mergeAll(providers);

        System.out.println("Объединённая ломаная: " + merged);
        System.out.println(
                "Длина объединённой ломаной: " + merged.getLength()
        );

        // Задание 6. Номер 4. Сравнение ломаных.
        System.out.println("\n Задание 6. Номер 4. Сравнение ломаных ");

        Polyline first = new Polyline(
                new Point[]{
                        new Point(0, 0),
                        new Point(1, 1)
                }
        );

        Polyline second = new Polyline(
                new Point[]{
                        new Point(0, 0),
                        new Point(1, 1)
                }
        );

        Polyline third = new Polyline(
                new Point[]{
                        new Point(0, 0),
                        new Point(2, 2)
                }
        );

        System.out.println(
                "Первая и вторая равны: " + first.equals(second)
        );
        System.out.println(
                "Первая и третья равны: " + first.equals(third)
        );

        // Задание 7. Номер 1. Пакеты.
        System.out.println("\n Задание 7. Номер 1. Пакеты ");
        System.out.println("Пакет проекта: Laba3");
        System.out.println("Модели фигур находятся в пакете Geometry.");

        // Задание 7. Номер 2. Главный метод.
        System.out.println("\n Задание 7. Номер 2. Главный метод ");
        System.out.println("Точка входа: Main.main(String[] args)");

        // Задание 7. Номер 3. Возведение в степень.
        System.out.println("\n Задание 7. Номер 3. Возведение в степень");

        String x = args.length > 0 ? args[0] : "2";
        String y = args.length > 1 ? args[1] : "5";

        try {
            System.out.println(
                    x + " в степени " + y + " = " + power(x, y)
            );
        } catch (NumberFormatException e) {
            System.out.println(
                    "Ошибка: аргументы должны быть целыми числами."
            );
        }

        // Задание 8. Номер 4. Клонирование точки.
        System.out.println("\n Задание 8. Номер 4. Клонирование точки");

        Point original = new Point(7, 8);
        Point copy = original.clone();

        System.out.println("Оригинал: " + original);
        System.out.println("Копия: " + copy);
        System.out.println(
                "Один и тот же объект: " + (original == copy)
        );

        copy.setX(100);

        System.out.println("После изменения копии:");
        System.out.println("Оригинал: " + original);
        System.out.println("Копия: " + copy);
    }
}
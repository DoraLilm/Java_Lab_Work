package Laba2;

public class Main {

    public static void main(String[] args) {

        System.out.println("Лабораторная работа №2. Вариант 10 ");


        //  ЗАДАНИЕ 1.3

        System.out.println();
        System.out.println("Задание 1.3 Имена ");

        Name cleopatra = new Name(
                null,
                "Клеопатра",
                null
        );

        Name pushkin = new Name(
                "Пушкин",
                "Александр",
                "Сергеевич"
        );

        Name mayakovsky = new Name(
                "Маяковский",
                "Владимир",
                null
        );

        System.out.println(cleopatra);
        System.out.println(pushkin);
        System.out.println(mayakovsky);


        //  ЗАДАНИЕ 2.2

        System.out.println();
        System.out.println("Задание 2.2 Человек с именем");

        Person person1 = new Person(
                cleopatra,
                152
        );

        Person person2 = new Person(
                pushkin,
                167
        );

        Person person3 = new Person(
                mayakovsky,
                189
        );

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);


        //  ЗАДАНИЕ 2.3

        System.out.println();
        System.out.println("Задание 2.3 Человек с родителем");

        Person ivan = new Person(
                new Name(
                        "Чудов",
                        "Иван",
                        null
                ),
                170
        );

        Person petr = new Person(
                new Name(
                        null,
                        "Петр",
                        null
                ),
                175,
                ivan
        );

        Person boris = new Person(
                new Name(
                        null,
                        "Борис",
                        null
                ),
                180,
                petr
        );

        System.out.println(ivan);
        System.out.println(petr);
        System.out.println(boris);


        //  ЗАДАНИЕ 3.2

        System.out.println();
        System.out.println("Задание 3.2 Ломаная");

        Point point1 = new Point(1, 5);
        Point point2 = new Point(2, 8);
        Point point3 = new Point(5, 3);

        Polyline firstLine = new Polyline(
                point1,
                point2,
                point3
        );

        Polyline secondLine = new Polyline(
                point1,
                new Point(2, -5),
                new Point(4, -8),
                point3
        );

        System.out.println("Первая ломаная:");
        System.out.println(firstLine);

        System.out.println("Вторая ломаная:");
        System.out.println(secondLine);


        System.out.println();
        System.out.println("После изменения первой точки:");

        point1.setX(10);
        point1.setY(10);

        System.out.println("Первая ломаная:");
        System.out.println(firstLine);

        System.out.println("Вторая ломаная:");
        System.out.println(secondLine);


        //  ЗАДАНИЕ 4.9

        System.out.println();
        System.out.println("Задание 4.9 Создаем Ломаную");

        Polyline emptyLine = new Polyline();

        System.out.println("Ломаная без точек:");
        System.out.println(emptyLine);

        Polyline newLine = new Polyline(
                new Point(1, 5),
                new Point(2, 8),
                new Point(5, 3)
        );

        System.out.println("Ломаная с точками:");
        System.out.println(newLine);


        //  ЗАДАНИЕ 5.7

        System.out.println();
        System.out.println("Задание 5.7 Длина Ломаной");

        Polyline lengthLine = new Polyline(
                new Point(1, 5),
                new Point(2, 8),
                new Point(5, 3)
        );

        System.out.println("Исходная ломаная:");
        System.out.println(lengthLine);

        System.out.println("Длина:");
        System.out.println(lengthLine.getLength());

        lengthLine.addPoints(
                new Point(5, 15),
                new Point(8, 10)
        );

        System.out.println();
        System.out.println("После добавления точек:");
        System.out.println(lengthLine);

        System.out.println("Новая длина:");
        System.out.println(lengthLine.getLength());
    }
}
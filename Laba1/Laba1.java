package Laba1;

import java.util.Arrays;

/**
 * Лабораторная работа №1. Вариант 10.
 */
public class Laba1 {

    public static void main(String[] args) {
        System.out.println("=== Задание 1. Методы ===");

        System.out.println();
        System.out.println("Номер 3. Задание 1.");
        System.out.println("x = '3'");
        System.out.println("результат: " + charToNum('3'));

        System.out.println();
        System.out.println("Номер 4. Задание 1.");
        System.out.println("x = 3");
        System.out.println("результат: " + isPositive(3));

        System.out.println();
        System.out.println("Номер 6. Задание 1.");
        System.out.println("x = 'D'");
        System.out.println("результат: " + isUpperCase('D'));

        System.out.println();
        System.out.println("Номер 8. Задание 1.");
        System.out.println("a = 3, b = 6");
        System.out.println("результат: " + isDivisor(3, 6));

        System.out.println();
        System.out.println("Номер 10. Задание 1.");
        int total = 5;

        System.out.print(total + "+11 это ");
        total = lastNumSum(total, 11);
        System.out.println(total);

        System.out.print(total + "+123 это ");
        total = lastNumSum(total, 123);
        System.out.println(total);

        System.out.print(total + "+14 это ");
        total = lastNumSum(total, 14);
        System.out.println(total);

        System.out.print(total + "+1 это ");
        total = lastNumSum(total, 1);
        System.out.println(total);

        System.out.println("Итого " + total);
        System.out.println();


        System.out.println("=== Задание 2. Условия ===");

        System.out.println();
        System.out.println("Номер 1. Задание 2.");
        System.out.println("x = -5");
        System.out.println("результат: " + abs(-5));

        System.out.println();
        System.out.println("Номер 4. Задание 2.");
        System.out.println("x = 5, y = 7");
        System.out.println("результат: " + makeDecision(5, 7));

        System.out.println();
        System.out.println("Номер 5. Задание 2.");
        System.out.println("x = 5, y = 7, z = 7");
        System.out.println("результат: " + max3(5, 7, 7));

        System.out.println();
        System.out.println("Номер 7. Задание 2.");
        System.out.println("x = 5, y = 7");
        System.out.println("результат: " + sum2(5, 7));

        System.out.println();
        System.out.println("Номер 9. Задание 2.");
        System.out.println("x = 5");
        System.out.println("результат: " + day(5));
        System.out.println();


        System.out.println("=== Задание 3. Циклы ===");

        System.out.println();
        System.out.println("Номер 2. Задание 3.");
        System.out.println("x = 5");
        System.out.println("результат: " + reverseListNums(5));

        System.out.println();
        System.out.println("Номер 3. Задание 3.");
        System.out.println("x = 9");
        System.out.println("результат: " + chet(9));

        System.out.println();
        System.out.println("Номер 6. Задание 3.");
        System.out.println("x = 1111");
        System.out.println("результат: " + equalNum(1111));

        System.out.println();
        System.out.println("Номер 8. Задание 3.");
        System.out.println("x = 4");
        System.out.println("результат:");
        leftTriangle(4);

        System.out.println();
        System.out.println("Номер 9. Задание 3.");
        System.out.println("x = 4");
        System.out.println("результат:");
        rightTriangle(4);
        System.out.println();


        System.out.println("=== Задание 4. Массивы ===");

        System.out.println();
        System.out.println("Номер 1. Задание 4.");
        System.out.println("arr = [1, 2, 3, 4, 2, 2, 5], x = 2");
        System.out.println("результат: " + findFirst(new int[]{1, 2, 3, 4, 2, 2, 5}, 2));

        System.out.println();
        System.out.println("Номер 2. Задание 4.");
        System.out.println("arr = [1, 2, 3, 4, 2, 2, 5], x = 2");
        System.out.println("результат: " + findLast(new int[]{1, 2, 3, 4, 2, 2, 5}, 2));

        System.out.println();
        System.out.println("Номер 4. Задание 4.");
        System.out.println("arr = [1, 2, 3, 4, 5], x = 9, pos = 3");
        System.out.println("результат: " + Arrays.toString(add(new int[]{1, 2, 3, 4, 5}, 9, 3)));

        System.out.println();
        System.out.println("Номер 7. Задание 4.");
        System.out.println("arr = [1, 2, 3, 4, 5]");
        System.out.println("результат: " + Arrays.toString(reverseBack(new int[]{1, 2, 3, 4, 5})));

        System.out.println();
        System.out.println("Номер 10. Задание 4.");
        System.out.println("arr = [1, 2, -3, 4, -2, 2, -5]");
        System.out.println("результат: " + Arrays.toString(deleteNegative(new int[]{1, 2, -3, 4, -2, 2, -5})));
    }

    // Задание 1.3. Преобразовать цифру-символ в число.
    public static int charToNum(char x) {
        return x - '0';
    }

    // Задание 1.4. Проверить, является ли число положительным.
    public static boolean isPositive(int x) {
        return x > 0;
    }

    // Задание 1.6. Проверить, является ли символ заглавной буквой.
    public static boolean isUpperCase(char x) {
        return x >= 'A' && x <= 'Z';
    }

    // Задание 1.8. Проверить, является ли одно число делителем другого.
    public static boolean isDivisor(int a, int b) {
        return a % b == 0 || b % a == 0;
    }

    // Задание 1.10. Сложить последние цифры двух чисел и последовательно повторить сложение.
    public static int lastNumSum(int a, int b) {
        return a % 10 + b % 10;
    }


    // Задание 2.1. Найти абсолютное значение числа.
    public static int abs(int x) {
        if (x < 0) {
            return -x;
        }
        return x;
    }

    // Задание 2.4. Вывести два числа и знак сравнения между ними.
    public static String makeDecision(int x, int y) {
        if (x < y) {
            return x + " < " + y;
        } else if (x > y) {
            return x + " > " + y;
        } else {
            return x + " == " + y;
        }
    }

    // Задание 2.5. Найти максимальное из трёх чисел.
    public static int max3(int x, int y, int z) {
        int max = x;

        if (y > max) {
            max = y;
        }
        if (z > max) {
            max = z;
        }

        return max;
    }

    // Задание 2.7. Сложить два числа; если сумма от 10 до 19, вернуть 20.
    public static int sum2(int x, int y) {
        int sum = x + y;

        if (sum >= 10 && sum <= 19) {
            return 20;
        }

        return sum;
    }

    // Задание 2.9. По номеру дня недели определить его название.
    public static String day(int x) {
        switch (x) {
            case 1:
                return "понедельник";
            case 2:
                return "вторник";
            case 3:
                return "среда";
            case 4:
                return "четверг";
            case 5:
                return "пятница";
            case 6:
                return "суббота";
            case 7:
                return "воскресенье";
            default:
                return "это не день недели";
        }
    }


    // Задание 3.2. Вывести числа от x до 0 в обратном порядке.
    public static String reverseListNums(int x) {
        String result = "";

        if (x >= 0) {
            while (x >= 0) {
                result += x + " ";
                x--;
            }
        }

        return result;
    }

    // Задание 3.3. Вывести все чётные числа от 0 до x.
    public static String chet(int x) {
        String result = "";

        for (int i = 0; i <= x; i += 2) {
            result += i + " ";
        }

        return result;
    }

    // Задание 3.6. Проверить, состоят ли все цифры числа из одной цифры.
    public static boolean equalNum(int x) {
        int lastNum = x % 10;
        x = x / 10;

        while (x != 0) {
            if (x % 10 != lastNum) {
                return false;
            }
            x = x / 10;
        }

        return true;
    }

    // Задание 3.8. Вывести левый треугольник из символов *.
    public static void leftTriangle(int x) {
        for (int i = 0; i != x; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    // Задание 3.9. Вывести правый треугольник из символов *.
    public static void rightTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < x - i; j++) {
                System.out.print(' ');
            }

            for (int j = 0; j < i; j++) {
                System.out.print('*');
            }

            System.out.println();
        }
    }


    // Задание 4.1. Найти индекс первого вхождения числа в массиве.
    public static int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }

        return -1;
    }

    // Задание 4.2. Найти индекс последнего вхождения числа в массиве.
    public static int findLast(int[] arr, int x) {
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                index = i;
            }
        }

        return index;
    }

    // Задание 4.4. Вставить число x в массив на позицию pos.
    public static int[] add(int[] arr, int x, int pos) {
        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < pos; i++) {
            newArr[i] = arr[i];
        }

        newArr[pos] = x;

        for (int i = pos; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        return newArr;
    }

    // Задание 4.7. Вернуть новый массив с элементами в обратном порядке.
    public static int[] reverseBack(int[] arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[arr.length - 1 - i];
        }

        return newArr;
    }

    // Задание 4.10. Удалить из массива все отрицательные элементы.
    public static int[] deleteNegative(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                count++;
            }
        }

        int[] newArr = new int[count];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                newArr[index] = arr[i];
                index++;
            }
        }

        return newArr;
    }
}

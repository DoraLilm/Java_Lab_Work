package Laba4.Main;

import Laba4.Models.Box;
import Laba4.Models.Storage;
import Laba4.Tasks.BoxMethods;
import Laba4.Functions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {

    public static <T> T takeFromBox(Box<T> box) {
        return box.take();
    }

    public static <T> void showStorage(
            Storage<T> storage,
            T alternative
    ) {
        System.out.println(storage.getValue(alternative));
    }

    public static void main(String[] args) {

        // Задание 1.1. Обобщённая коробка
        System.out.println("\n Задание 1.1. Коробка ");

        Box<Integer> box = new Box<>();

        box.put(3);

        System.out.println(box);
        System.out.println(
                "Полученное значение: " + takeFromBox(box)
        );
        System.out.println("Коробка пуста: " + box.isEmpty());

        try {
            box.take();
        } catch (IllegalStateException e) {
            System.out.println("Проверка: " + e.getMessage());
        }

        box.put(5);

        try {
            box.put(10);
        } catch (IllegalStateException e) {
            System.out.println("Проверка: " + e.getMessage());
        }

        System.out.println(box);

        // Задание 1.2. Неизменяемое хранилище
        System.out.println("\n Задание 1.2. Хранилище ");

        Storage<Integer> emptyNumber = new Storage<>(null);
        Storage<Integer> number = new Storage<>(99);

        Storage<String> emptyString = new Storage<>(null);
        Storage<String> string = new Storage<>("hello");

        System.out.print("Число null, альтернатива 0: ");
        showStorage(emptyNumber, 0);

        System.out.print("Число 99, альтернатива -1: ");
        showStorage(number, -1);

        System.out.print("Строка null, альтернатива default: ");
        showStorage(emptyString, "default");

        System.out.print("Строка hello, альтернатива hello world: ");
        showStorage(string, "hello world");

        // Задание 2.2. Поиск максимума
        System.out.println("\n Задание 2.2. Максимум ");

        List<Box<? extends Number>> boxes = new ArrayList<>();

        Box<Integer> firstBox = new Box<>();
        firstBox.put(15);

        Box<Double> secondBox = new Box<>();
        secondBox.put(25.5);

        Box<Long> thirdBox = new Box<>();
        thirdBox.put(100L);

        boxes.add(firstBox);
        boxes.add(secondBox);
        boxes.add(thirdBox);

        System.out.println("Коробки: " + boxes);
        System.out.println(
                "Максимальное значение: "
                        + BoxMethods.findMaximum(boxes)
        );

        // Задание 3.1. Функция
        System.out.println("\n Задание 3.1. Функция ");

        GenericMethods methods = new GenericMethods();

        List<String> words = Arrays.asList(
                "qwerty", "asdfg", "zx"
        );

        List<Integer> wordLengths = methods.transform(
                words,
                new StringLengthTransformer()
        );

        System.out.println("Исходные строки: " + words);
        System.out.println("Длины строк: " + wordLengths);

        List<Integer> numbers = Arrays.asList(1, -3, 7);

        List<Integer> absoluteNumbers = methods.transform(
                numbers,
                new AbsoluteValueTransformer()
        );

        System.out.println("Исходные числа: " + numbers);
        System.out.println("После преобразования: " + absoluteNumbers);

        List<int[]> arrays = new ArrayList<>();

        arrays.add(new int[]{3, 8, 2});
        arrays.add(new int[]{10, 4, 6});
        arrays.add(new int[]{-5, -2, -9});

        List<Integer> maximums = methods.transform(
                arrays,
                new MaxArrayTransformer()
        );

        System.out.println("Максимумы массивов: " + maximums);

        // Задание 3.2. Фильтр
        System.out.println("\n Задание 3.2. Фильтр ");

        List<String> filteredWords = methods.filterValues(
                words,
                new MinLengthCondition()
        );

        System.out.println("Строки длиной не менее 3: " + filteredWords);

        List<Integer> filteredNumbers = methods.filterValues(
                numbers,
                new NonPositiveCondition()
        );

        System.out.println(
                "Неположительные числа: " + filteredNumbers
        );

        List<int[]> arraysForFilter = new ArrayList<>();

        arraysForFilter.add(new int[]{-1, -2, 0});
        arraysForFilter.add(new int[]{3, -5, 1});
        arraysForFilter.add(new int[]{-7, -4, -2});

        List<int[]> filteredArrays = methods.filterValues(
                arraysForFilter,
                new NoPositiveNumbersCondition()
        );

        System.out.println(
                "Массивы без положительных чисел:"
        );

        for (int[] array : filteredArrays) {
            System.out.println(Arrays.toString(array));
        }

        // Задание 3.3. Сокращение
        System.out.println("\n Задание 3.3. Сокращение ");

        String combinedString = methods.reduce(
                words,
                "",
                new StringConcatCombiner()
        );

        System.out.println("Объединённая строка: " + combinedString);

        Integer sum = methods.reduce(
                numbers,
                0,
                new IntegerSumCombiner()
        );

        System.out.println("Сумма чисел: " + sum);

        List<List<Integer>> groups = new ArrayList<>();

        groups.add(Arrays.asList(1, 2, 3));
        groups.add(Arrays.asList(4, 5));
        groups.add(Arrays.asList(6, 7, 8, 9));

        List<Integer> groupSizes = methods.transform(
                groups,
                new ListSizeTransformer()
        );

        Integer totalCount = methods.reduce(
                groupSizes,
                0,
                new IntegerSumCombiner()
        );

        System.out.println("Исходные группы: " + groups);
        System.out.println("Размеры групп: " + groupSizes);
        System.out.println("Общее количество элементов: " + totalCount);

        // Проверка пустого списка
        List<Integer> emptyNumbers = new ArrayList<>();

        System.out.println(
                "Сумма пустого списка: "
                        + methods.reduce(
                        emptyNumbers,
                        0,
                        new IntegerSumCombiner()
                )
        );

        System.out.println(
                "Результат объединения пустого списка: \""
                        + methods.reduce(
                        new ArrayList<String>(),
                        "",
                        new StringConcatCombiner()
                )
                        + "\""
        );

        // Задание 3.4. Коллекционирование
        System.out.println("\n Задание 3.4. Коллекционирование ");

        // Разделение чисел на положительные и отрицательные
        List<Integer> signNumbers = Arrays.asList(1, -3, 7);

        List<List<Integer>> signGroups = methods.collectValues(
                signNumbers,
                new SignGroupsFactory(),
                new SignGroupsWriter()
        );

        System.out.println("Исходные числа: " + signNumbers);
        System.out.println("Положительные: " + signGroups.get(0));
        System.out.println("Отрицательные: " + signGroups.get(1));

        // Группировка строк по длине
        List<String> strings = Arrays.asList(
                "qwerty", "asdfg", "zx", "qw"
        );

        List<List<String>> stringGroups = methods.collectValues(
                strings,
                new StringGroupsFactory(),
                new StringGroupsWriter()
        );

        System.out.println("Исходные строки: " + strings);
        System.out.println("Группы строк по длине:");

        for (List<String> group : stringGroups) {
            System.out.println(group);
        }

        // Удаление повторяющихся строк
        List<String> repeatedStrings = Arrays.asList(
                "qwerty", "asdfg", "qwerty", "qw"
        );

        Set<String> uniqueStrings = methods.collectValues(
                repeatedStrings,
                new UniqueSetFactory(),
                new UniqueSetWriter()
        );

        System.out.println("Исходные строки: " + repeatedStrings);
        System.out.println("Уникальные строки: " + uniqueStrings);

    }
}
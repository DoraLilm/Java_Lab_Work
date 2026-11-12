package Laba4.Functions;

import java.util.List;

// Получает список целых чисел и возвращает количество его элементов
// Используется вместе с transform и reduce для подсчёта общего количества элементов во вложенных списках

public class ListSizeTransformer
        implements Transformer<List<Integer>, Integer> {

    @Override
    public Integer apply(List<Integer> value) {
        if (value == null) {
            throw new IllegalArgumentException(
                    "Вложенный список не может быть null"
            );
        }

        return value.size();
    }

    @Override
    public String toString() {
        return "Получение размера списка";
    }
}
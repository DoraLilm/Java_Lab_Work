package Laba4.Functions;

import java.util.List;

// Распределяет числа по двум спискам

public class SignGroupsWriter
        implements ResultWriter<List<List<Integer>>, Integer> {

    @Override
    public void add(List<List<Integer>> result, Integer value) {
        if (value == null) {
            throw new IllegalArgumentException(
                    "Число не может быть null"
            );
        }

        if (value > 0) {
            result.get(0).add(value);
        } else if (value < 0) {
            result.get(1).add(value);
        }
    }

    @Override
    public String toString() {
        return "Распределение чисел по знаку";
    }
}
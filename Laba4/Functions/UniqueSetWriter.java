package Laba4.Functions;

import java.util.Set;

// Добавляет строки в множество

public class UniqueSetWriter
        implements ResultWriter<Set<String>, String> {

    @Override
    public void add(Set<String> result, String value) {
        if (value == null) {
            throw new IllegalArgumentException(
                    "Строка не может быть null"
            );
        }

        result.add(value);
    }

    @Override
    public String toString() {
        return "Добавление уникальных строк";
    }
}

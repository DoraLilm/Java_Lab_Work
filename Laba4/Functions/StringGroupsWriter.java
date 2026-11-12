package Laba4.Functions;

import java.util.ArrayList;
import java.util.List;

// Добавляет строки в группы одинаковой длины

public class StringGroupsWriter
        implements ResultWriter<List<List<String>>, String> {

    @Override
    public void add(List<List<String>> result, String value) {
        if (value == null) {
            throw new IllegalArgumentException(
                    "Строка не может быть null"
            );
        }

        for (List<String> group : result) {
            if (group.get(0).length() == value.length()) {
                group.add(value);
                return;
            }
        }

        List<String> newGroup = new ArrayList<>();
        newGroup.add(value);
        result.add(newGroup);
    }

    @Override
    public String toString() {
        return "Группировка строк по длине";
    }
}
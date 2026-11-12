package Laba4.Functions;

import java.util.HashSet;
import java.util.Set;

// Создаёт множество, в котором не могут повторяться одинаковые строки

public class UniqueSetFactory
        implements ResultFactory<Set<String>> {

    @Override
    public Set<String> create() {
        return new HashSet<>();
    }

    @Override
    public String toString() {
        return "Создание множества уникальных строк";
    }
}
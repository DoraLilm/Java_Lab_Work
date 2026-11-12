package Laba4.Functions;

import java.util.ArrayList;
import java.util.List;

// Создаёт пустой список групп строк

public class StringGroupsFactory
        implements ResultFactory<List<List<String>>> {

    @Override
    public List<List<String>> create() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Создание групп строк";
    }
}
package Laba4.Functions;

import java.util.ArrayList;
import java.util.List;

// Создаёт два списка: для положительных и отрицательных чисел

public class SignGroupsFactory
        implements ResultFactory<List<List<Integer>>> {

    @Override
    public List<List<Integer>> create() {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());
        result.add(new ArrayList<>());

        return result;
    }

    @Override
    public String toString() {
        return "Создание групп положительных и отрицательных чисел";
    }
}
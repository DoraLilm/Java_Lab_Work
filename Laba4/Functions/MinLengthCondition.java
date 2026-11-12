package Laba4.Functions;

// Оставляет строки, в которых не менее трёх символов

public class MinLengthCondition
        implements Condition<String> {

    @Override
    public boolean test(String value) {
        return value != null && value.length() >= 3;
    }

    @Override
    public String toString() {
        return "Проверка минимальной длины строки";
    }
}
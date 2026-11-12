package Laba4.Functions;

// Оставляет нулевые и отрицательные числа, то есть удаляет положительные

public class NonPositiveCondition
        implements Condition<Integer> {

    @Override
    public boolean test(Integer value) {
        return value != null && value <= 0;
    }

    @Override
    public String toString() {
        return "Проверка на неположительное число";
    }
}
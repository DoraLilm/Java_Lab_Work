package Laba4.Functions;

// Оставляет массивы, в которых нет положительных чисел

public class NoPositiveNumbersCondition
        implements Condition<int[]> {

    @Override
    public boolean test(int[] values) {
        if (values == null) {
            return false;
        }

        for (int value : values) {
            if (value > 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return "Проверка отсутствия положительных чисел";
    }
}
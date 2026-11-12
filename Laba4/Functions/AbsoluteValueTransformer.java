package Laba4.Functions;

// Преобразует отрицательное число в положительное

public class AbsoluteValueTransformer
        implements Transformer<Integer, Integer> {

    @Override
    public Integer apply(Integer value) {
        if (value == null) {
            throw new IllegalArgumentException(
                    "Число не может быть null"
            );
        }

        return Math.abs(value);
    }

    @Override
    public String toString() {
        return "Получение абсолютного значения числа";
    }
}
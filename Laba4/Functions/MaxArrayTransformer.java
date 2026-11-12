package Laba4.Functions;


//Получает массив целых чисел и возвращает его максимальное значение

public class MaxArrayTransformer
        implements Transformer<int[], Integer> {

    @Override
    public Integer apply(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException(
                    "Массив не должен быть пустым"
            );
        }

        int maximum = values[0];

        for (int value : values) {
            if (value > maximum) {
                maximum = value;
            }
        }

        return maximum;
    }

    @Override
    public String toString() {
        return "Поиск максимума в массиве";
    }
}

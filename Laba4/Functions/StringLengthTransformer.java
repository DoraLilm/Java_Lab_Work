package Laba4.Functions;

// Получает строку и возвращает количество её символов

public class StringLengthTransformer
        implements Transformer<String, Integer> {

    @Override
    public Integer apply(String value) {
        if (value == null) {
            throw new IllegalArgumentException(
                    "Строка не может быть null"
            );
        }

        return value.length();
    }

    @Override
    public String toString() {
        return "Преобразование строки в её длину";
    }
}
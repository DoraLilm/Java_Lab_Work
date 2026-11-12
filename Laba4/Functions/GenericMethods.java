package Laba4.Functions;

import java.util.ArrayList;
import java.util.List;


// четыре универсальных метода: преобразование, фильтрация, сокращение и коллекционирование

public class GenericMethods {

    // Задание 3.1
    public static <T, P> List<P> transform(
            List<T> source,
            Transformer<T, P> transformer
    ) {
        if (source == null || transformer == null) {
            throw new IllegalArgumentException(
                    "Неверные входные данные"
            );
        }

        List<P> result = new ArrayList<>();

        for (T value : source) {
            result.add(transformer.apply(value));
        }

        return result;
    }

    // Задание 3.2
    public static <T> List<T> filterValues(
            List<T> source,
            Condition<T> condition
    ) {
        if (source == null || condition == null) {
            throw new IllegalArgumentException(
                    "Неверные входные данные"
            );
        }

        List<T> result = new ArrayList<>();

        for (T value : source) {
            if (condition.test(value)) {
                result.add(value);
            }
        }

        return result;
    }

    // Задание 3.3
    public static <T> T reduce(
            List<T> source,
            T initialValue,
            Combiner<T> combiner
    ) {
        if (source == null || initialValue == null
                || combiner == null) {
            throw new IllegalArgumentException(
                    "Неверные входные данные"
            );
        }

        T result = initialValue;

        for (T value : source) {
            result = combiner.combine(result, value);
        }

        return result;
    }

    // Задание 3.4
    public static <T, R> R collectValues(
            List<T> source,
            ResultFactory<R> factory,
            ResultWriter<R, T> writer
    ) {
        if (source == null || factory == null || writer == null) {
            throw new IllegalArgumentException(
                    "Неверные входные данные"
            );
        }

        R result = factory.create();

        if (result == null) {
            throw new IllegalStateException(
                    "Не удалось создать результат"
            );
        }

        for (T value : source) {
            writer.add(result, value);
        }

        return result;
    }

    @Override
    public String toString() {
        return "Универсальные методы обработки данных";
    }
}
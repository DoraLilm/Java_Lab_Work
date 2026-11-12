package Laba4.Tasks;

import Laba4.Models.Box;

import java.util.List;

// решение задания 2.2 — поиск максимального значения среди коробок с различными числовыми типами

public class BoxMethods {

    public static double findMaximum(
            List<? extends Box<? extends Number>> boxes
    ) {
        if (boxes == null || boxes.isEmpty()) {
            throw new IllegalArgumentException(
                    "Список коробок пуст"
            );
        }

        double maximum = Double.NEGATIVE_INFINITY;

        for (Box<? extends Number> box : boxes) {
            if (box == null || box.isEmpty()) {
                throw new IllegalArgumentException(
                        "Обнаружена пустая коробка"
                );
            }

            double number = box.get().doubleValue();

            if (number > maximum) {
                maximum = number;
            }
        }

        return maximum;
    }

    @Override
    public String toString() {
        return "Методы работы с коробками";
    }
}
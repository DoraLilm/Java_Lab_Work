package Laba4.Functions;

// Складывает два целых числа

public class IntegerSumCombiner
        implements Combiner<Integer> {

    @Override
    public Integer combine(Integer first, Integer second) {
        return first + second;
    }

    @Override
    public String toString() {
        return "Сложение чисел";
    }
}
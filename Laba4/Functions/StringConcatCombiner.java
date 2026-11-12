package Laba4.Functions;

// Объединяет две строки

public class StringConcatCombiner
        implements Combiner<String> {

    @Override
    public String combine(String first, String second) {
        return first + second;
    }

    @Override
    public String toString() {
        return "Объединение строк";
    }
}

package Laba4.Models;

// Неизменяемое хранилище
// Значение задаётся при создании объекта и впоследствии не меняется
// Если внутри null, возвращается альтернативное значение

public class Storage<T> {
    private final T value;

    public Storage(T value) {
        this.value = value;
    }

    public T getValue(T alternative) {
        if (value == null) {
            return alternative;
        }

        return value;
    }

    @Override
    public String toString() {
        return "Хранилище: " + value;
    }
}
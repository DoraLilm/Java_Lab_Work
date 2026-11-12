package Laba4.Models;

// Обобщённая коробка
// Она хранит одно значение указанного типа
// Если коробка заполнена, повторное добавление запрещено, При извлечении значение удаляется

public class Box<T> {
    private T value;
    private boolean filled;

    public Box() {
        value = null;
        filled = false;
    }

    public void put(T value) {
        if (filled) {
            throw new IllegalStateException(
                    "Коробка уже заполнена"
            );
        }

        this.value = value;
        filled = true;
    }

    public T get() {
        if (!filled) {
            throw new IllegalStateException(
                    "Коробка пуста"
            );
        }

        return value;
    }

    public T take() {
        if (!filled) {
            throw new IllegalStateException(
                    "Коробка пуста"
            );
        }

        T result = value;
        value = null;
        filled = false;

        return result;
    }

    public boolean isEmpty() {
        return !filled;
    }

    @Override
    public String toString() {
        if (filled) {
            return "Коробка содержит: " + value;
        }

        return "Коробка пуста";
    }
}
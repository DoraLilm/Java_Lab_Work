package Laba4.Functions;

public interface Transformer<T, P> {
    P apply(T value);
}
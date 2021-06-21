package com.rafaelshayashi.stack;

import com.rafaelshayashi.util.ArrayBasedStructure;

public class CustomStack<T> extends ArrayBasedStructure<T> {

    public static final int DEFAULT_SIZE = 10;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        super(size);
    }

    public void push(T element) {

        if (size == elements.length) {
            increaseSize();
        }
        elements[size] = element;
        size++;
    }

    public T pop() {

        if (isEmpty()) {
            return null;
        }

        return elements[--size];
    }

    public T peek() {
        return elements[size - 1];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int i = 0; i < size - 1; i++) {
            builder.append(elements[i]).append(", ");
        }

        if (size > 0) {
            builder.append(elements[size - 1]);
        }

        builder.append("]");
        return builder.toString();
    }
}

package com.rafaelshayashi.stack;

public class Stack<T> {

    private final T[] elements;
    private int size;
    public static final int DEFAULT_SIZE = 10;

    public Stack() {
        this(DEFAULT_SIZE);
    }

    public Stack(int size){
        this.elements = (T[]) new Object[size];
        this.size = 0;
    }

    public void push(T element){
        // TODO implement push
        throw new UnsupportedOperationException("Push method not implemented yet");
    }

    public T pop (){
        // TODO implement pop
        throw new UnsupportedOperationException("Pop method not implemented yet");
    }

    public T peek() {
        // TODO Implement peek
        throw new UnsupportedOperationException("Peek method not implemented yet");
    }

    public boolean isEmpty() {
        // TODO implement isEmpty
        throw new UnsupportedOperationException("isEmpty method not implemented yet");
    }

    public void clear(){
        // TODO implement clear
        throw new UnsupportedOperationException("Clear method not implemented yet");
    }

    public int size() {
        // TODO implement size
        throw new UnsupportedOperationException("Peek method not implemented yet");
    }
}

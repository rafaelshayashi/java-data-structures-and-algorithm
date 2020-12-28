package com.rafaelshayashi.stack;

public class Stack<T> {

    private T[] elements;
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

        if(size == elements.length){
            increaseSize();
        }
        elements[size] = element;
        size++;
    }

    private void increaseSize() {
        var newSize = elements.length * 2;
        var newArray = (T[]) new Object[newSize];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }

    public T pop (){

        if(size == 0) {
            return null;
        }

        T element = elements[size - 1];
        size--;
        return element;
    }

    public T peek() {
        return elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear(){
        elements = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    public int size() {
        return size;
    }
}

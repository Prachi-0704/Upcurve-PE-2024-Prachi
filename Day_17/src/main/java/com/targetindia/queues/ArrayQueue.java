package com.targetindia.queues;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {

    private int capacity = 5;
    private Object[] elements;
    private int rear = -1;

    public ArrayQueue() {
        elements = new Object[capacity]; // O(1)
    } // O(1)

    public ArrayQueue(int capacity) {
        this.capacity = capacity; // O(1)
        elements = new Object[capacity]; // O(1)
    } // O(1)

    @Override
    public void enqueue(T value) {
        rear++;
        elements[rear] = value;
    }

    @Override
    public T peek() throws NoSuchElementException {
        return (T) elements[0];
    }

    @Override
    public T dequeue() throws NoSuchElementException {
        T dequeueElement = (T)elements[0];
        for(int i = 1; i<=rear; i++){
            elements[i-1] = elements[i];
        }
        rear--;
        return dequeueElement;
    }

    @Override
    public boolean isEmpty() {
        return rear == -1;
    }

    @Override
    public int size() {
        return rear+1;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<=rear; i++){
            sb.append(elements[i]+" ");
        }

        return sb.toString();
    }
}

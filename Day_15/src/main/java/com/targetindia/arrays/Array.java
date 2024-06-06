package com.targetindia.arrays;

import java.util.Arrays;

class Array {

    private int[] numbers;
    private int size = 0;
    private int capacity = 5;

    public Array() {
        numbers = new int[capacity];
    }

    public void append(int data) {
        if (size == capacity) { // O(1)
            capacity *= 2; // O(1)
            var newNumbers = new int[capacity]; // O(1)
            for (int i = 0; i < size; i++) { // O(n)
                newNumbers[i] = numbers[i]; // O(1)
            }
            numbers = newNumbers; // O(1) // old object will be garbage collected eventually
        }
        numbers[size++] = data; // O(1)
    } // O(n) --> Linear time complexity

    public void display() {
        StringBuffer sb = new StringBuffer(); // O(1)
        sb.append("[");
        for (int i = 0; i < size; i++) { // O(n)
            sb.append(numbers[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println("Array (raw): " + Arrays.toString(numbers)); // O(n)
        System.out.println("Array content: " + sb);
    } // O(n) --> Linear time complexity

    public void prepend(int data) {
        capacity++;
        var newNumbers = new int[capacity];
        newNumbers[0] = data;
        for (int i = 0; i < size; i++) {
            newNumbers[i + 1] = numbers[i];
        } // O(n)
        numbers = newNumbers;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (size == 0) {
            throw new RuntimeException("Empty array; nothing to delete");
        }
        if (index < 0 || index >= size) {
            throw new RuntimeException("Invalid index. Must be >=0 and <" + size);
        }

        int[] newNumbers = new int[capacity];
        for (int i = 0; i < index; i++) {
            newNumbers[i] = numbers[i];
        }
        for (int i = index + 1; i < size; i++) {
            newNumbers[i - 1] = numbers[i];
        }
        numbers = newNumbers;
        size--;
    }

    public void deleteValue(int value) {
        if (size == 0) {
            throw new RuntimeException("Empty array; nothing to delete");
        }

        int key = -1;

        for (int i = 0; i < size; i++) {
            if (numbers[i] == value) {
                key = i;
                break;
            }
        }

        if (key < 0) {
            throw new RuntimeException("!!!--- Element does not exist. ---!!!");
        }

        int newNumbers[] = new int[capacity];

        for (int i = 0; i < key; i++) {
            newNumbers[i] = numbers[i];
        }
        for (int i = key + 1; i < size; i++) {
            newNumbers[i - 1] = numbers[i];
        }
        numbers = newNumbers;
        size--;
    }

    public void insertAtIndex(int index, int value) {
        if (size == 0) {
            throw new RuntimeException("Empty array; nothing to delete");
        }
        if (index < 0 || index >= size) {
            throw new RuntimeException("Invalid index. Must be >=0 and <" + size);
        }

        int[] newNumbers = new int[capacity];

        int j = 0;

        for (int i = 0; i < size + 1; i++) {
            if (i == index) {
                newNumbers[i] = value;
                continue;
            }
            newNumbers[i] = numbers[j];
            j++;
        }

        numbers = newNumbers;
        size = size + 1;

        return;
    }

    public void reverse() {
        int newNumbers[] = new int[capacity];

        for (int i = 0; i < size; i++) {
            newNumbers[i] = numbers[size - 1 - i];
        }

        numbers = newNumbers;
    }

    public void rotate(int pivot) {

        if (pivot < 0 || pivot >= size) {
            throw new RuntimeException("Invalid value of pivot");
        }

        for (int i = 0; i < pivot; i++) {
            for (int j = 1; j < size; j++) {
                int temp = numbers[0];
                numbers[0] = numbers[j];
                numbers[j] = temp;
            }
        }

    }
}

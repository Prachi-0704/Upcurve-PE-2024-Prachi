package com.targetindia.sorting;

import com.targetindia.utils.KeyboardUtil;

import java.util.Random;

// Assignment tasks for day 19
// TODO: Implement which ever sorting techniques possible on a linked list
public class Main {

    public static void main(String[] args) {
        // declare and initialize an array with random values
//        int[] array = new int[10];

        Random r = new Random();
        SinglyLinkedList list = new SinglyLinkedList(1);
        for (int i = 2; i <= 10; i++) {
            list.add((int) r.nextInt(100));
        }

        int choice;
        the_loop:
        while (true) {
            // display the array content (unsorted)
            System.out.println("List content: " + list.toString());

            System.out.println("\n*** Main Menu ***");
            System.out.println("0. Exit");
            System.out.println("1. Re-initialize the array");
            System.out.println("2. Bubble sort");
            System.out.println("3. Selection sort");
            System.out.println("4. Insertion sort");

            try {
                choice = KeyboardUtil.getInt("Enter your choice: ");
            } catch (Exception e) {
                choice = -1;
            }

            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    break the_loop;
                case 1:
                    SinglyLinkedList listNew = new SinglyLinkedList((int) r.nextInt(100));
                    for (int i = 0; i < list.length; i++) {
                        listNew.add((int) r.nextInt(100));
                    }
                    list = listNew;
                    break;

                case 2:
                    bubbleSort(list);
                    break;

                case 3:
                    selectionSort(list);
                    break;

                case 4:
                    insertionSort(list);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    public static void bubbleSort(SinglyLinkedList list) {

        if (list.head == null) return;

        for (int i = 0; i < list.length - 1; i++) {
            SinglyLinkedList curr = list.head;
            SinglyLinkedList prev = null;

            for (int j = 0; j < list.length - 1 - i; j++) {
                SinglyLinkedList next = curr.next;

                if (next != null && curr.data > next.data) {
                    // Perform swap of curr and next
                    if (prev == null) {
                        // Update head if necessary
                        list.head = next;
                    } else {
                        prev.next = next;
                    }
                    curr.next = next.next;
                    next.next = curr;

                    // Update prev to next, because next has been swapped to the curr position
                    prev = next;
                } else {
                    // Move prev and curr forward
                    prev = curr;
                    curr = next;
                }
            }
        }
    }

    public static void selectionSort(SinglyLinkedList list) {
        if (list.head == null) return;

        SinglyLinkedList start = list.head;

        while (start != null) {
            SinglyLinkedList minNode = start;
            SinglyLinkedList curr = start.next;

            // Find the minimum element in the unsorted part
            while (curr != null) {
                if (curr.data < minNode.data) {
                    minNode = curr;
                }
                curr = curr.next;
            }

            // Swap the found minimum element with the current start node
            int temp = start.data;
            start.data = minNode.data;
            minNode.data = temp;

            // Move start to the next node
            start = start.next;
        }
    }

    public static void insertionSort(SinglyLinkedList list) {
        if (list.head == null) return;

        SinglyLinkedList sorted = null; // Initialize a new sorted list

        SinglyLinkedList current = list.head;
        while (current != null) {
            SinglyLinkedList next = current.next; // Store next node to process
            sorted = sortedInsert(sorted, current); // Insert current node into sorted list
            current = next; // Move to the next node
        }

        list.head = sorted; // Update the head of the original list to point to the sorted list
    }

    private static SinglyLinkedList sortedInsert(SinglyLinkedList sorted, SinglyLinkedList newNode) {
        if (sorted == null || sorted.data >= newNode.data) {
            newNode.next = sorted;
            return newNode;
        } else {
            SinglyLinkedList current = sorted;
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            return sorted;
        }
    }
}
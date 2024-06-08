package com.targetindia.queues;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements Queue<T> {

    class ListNode{
        T data;
        ListNode next;
        ListNode(T data){
            this.data = data;
            this.next = null;
        }
    }

    ListNode head = null;
    int length = 0;

    @Override
    public void enqueue(T value) {
        ListNode newNode = new ListNode(value);

        length++;

        if(head == null){
            head = newNode;
            head.next = null;
            return;
        }

        ListNode curr = head;

        while(curr.next != null){
            curr = curr.next;
        }

        curr.next = newNode;
    }

    @Override
    public T peek() throws NoSuchElementException {
        if(head == null){
            throw new NoSuchElementException();
        }
        return head.data;
    }

    @Override
    public T dequeue() throws NoSuchElementException {
        if(head == null){
            throw new NoSuchElementException();
        }
        length--;
        ListNode dequeueNode = head;
        head = head.next;
        return dequeueNode.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        ListNode curr = head;

        while (curr != null){
            sb.append(curr.data);
            sb.append(" ");
            curr = curr.next;
        }

        return sb.toString();
    }
}

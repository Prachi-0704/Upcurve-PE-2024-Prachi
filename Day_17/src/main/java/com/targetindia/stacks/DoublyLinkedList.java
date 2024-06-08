package com.targetindia.stacks;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Stack<T>{
    @Override
    public void push(T item) {
        length++;
        var newNode = new ListNode(item);
        if (head == null) { // or tail==null
            head = tail = newNode;
            return;
        }

        newNode.prev = tail;
        tail = tail.next = newNode;
    }

    @Override
    public T peek() {
        if(head == tail && head == null){
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    @Override
    public T pop() {

        ListNode deleteNode = null;
        ListNode prv = null;
        ListNode nxt = null;
        ListNode curr = head;

        if(head == tail && head != null){
            deleteNode = head;
            head = tail = null;
            return deleteNode.data;
        }

        deleteNode = tail;
        prv = tail.prev;
        tail = prv;
        prv.next = null;
        length--;
        return deleteNode.data;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    class ListNode {
        ListNode prev;
        T data;
        ListNode next;

        public ListNode(T data) {
            this.data = data;
            this.prev = null; // this is the default behavior; no need to do this.
            this.next = null; // this is the default behavior; no need to do this.
        }
    }

    private ListNode head;
    private ListNode tail;
    private int length;


    public int size() {
        return length;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        ListNode curr = tail;
        while (curr != null){
            sb.append(curr.data+" ");
            curr = curr.prev;
        }
        return sb.toString();
    }


}

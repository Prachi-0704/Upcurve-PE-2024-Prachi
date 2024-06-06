package com.targetindia.dll;
import java.util.NoSuchElementException;

public class DoublyLinkedList {


    public int search(int val) {
        if(head==null){
            System.out.println("List is empty");
            return -1;
        }
        var curr = head;
        int idx = 0;

        while(curr != null && curr.data != val){
            curr = curr.next;
            idx++;
        }
        if(curr.data == val){
            return idx;
        }

        return -1;
    }

    public int deleteLast() {
        if (tail == null) { // or tail==null
            throw new NoSuchElementException("List is empty!");
        }

        length--;

        if (head == tail) {
            // only element in the list
            int data = head.data;
            head = tail = null;
            return data;
        }else{
            ListNode temp = tail;
            tail = tail.prev;
            tail.next = null;
            return temp.data;
        }
    }

    public void insertAtIndex(int idx, int val) {
        if(idx >= length){
            throw new IndexOutOfBoundsException("Index must be >0 and <"+length);
        }

        length++;

        ListNode newNode = new ListNode(val);

        if (head == null) { // or tail==null
            head = tail = newNode;
            return;
        }

        ListNode prv = null;
        var curr = head;

        int j = 0;
        while (curr != null && j<idx){
            prv = curr;
            curr = curr.next;
            j++;
        }

        if(curr == null){
            throw new RuntimeException("Curr is null");
        }

        prv.next = newNode;
        newNode.prev = prv;
        newNode.next = curr;
        curr.prev = newNode;
    }

    public int deleteAtIndex(int idx) {
        if(head == tail && head == null){
            throw new RuntimeException("List is Empty.");
        }
        if(idx<0 || idx>=length){
            throw new RuntimeException("Index must be <0 and >=" + length);
        }
        ListNode deleteNode = null;

        ListNode prv = null;
        ListNode nxt = null;
        ListNode curr = head;


        if(head==tail){
            deleteNode = head;
            head = tail = null;
            return deleteNode.data;
        }
        if(idx == 0){
            deleteNode = head;
            head = head.next;
            head.prev = null;

            return deleteNode.data;
        }
        if(idx == length-1){
            deleteNode = tail;
            prv = tail.prev;
            tail = prv;
            prv.next = null;
            length--;
            return deleteNode.data;
        }

        length--;

        int j = 0;

        while (j<idx){
            prv = curr;
            curr = curr.next;
            j++;
        }

        deleteNode = curr;
        nxt = curr.next;
        prv.next = nxt;
        nxt.prev = prv;

        return curr.data;
    }

    class ListNode {
        ListNode prev;
        int data;
        ListNode next;

        public ListNode(int data) {
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

    public void prepend(int data) {
        length++;
        var newNode = new ListNode(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void append(int data) {
        length++;
        var newNode = new ListNode(data);
        if (head == null) { // or tail==null
            head = tail = newNode;
            return;
        }

        newNode.prev = tail;
        tail = tail.next = newNode;
    }

    public void displayForward() {
        var curr = head;
        System.out.print("HEAD <-> ");
        while (curr != null) {
            System.out.print(curr.data);
            System.out.print(" <-> ");
            curr = curr.next;
        }
        System.out.println("TAIL");
    }


    public void displayBackward() {
        var curr = tail;
        System.out.print("TAIL <-> ");
        while (curr != null) {
            System.out.print(curr.data);
            System.out.print(" <-> ");
            curr = curr.prev;
        }
        System.out.println("HEAD");
    }

    public int deleteFirst() throws NoSuchElementException {
        if (head == null) { // or tail==null
            throw new NoSuchElementException("List is empty!");
        }

        length--;

        if (head == tail) {
            // only element in the list
            int data = head.data;
            head = tail = null;
            return data;
        }

        var nodeToDelete = head;
        head = head.next;
        head.prev = null;
        nodeToDelete.next = null;
        return nodeToDelete.data;
    }
}
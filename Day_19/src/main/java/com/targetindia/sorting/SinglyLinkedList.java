package com.targetindia.sorting;

public class SinglyLinkedList{
    int data;
    SinglyLinkedList next;

    SinglyLinkedList(int data) {
        this.data = data;
        this.next = null;
    }

    SinglyLinkedList head = null;
    int length = 0;

    public void add(int data) {
        SinglyLinkedList newNode = new SinglyLinkedList(data);
        if (head == null) {
            head = newNode;
        } else {
            SinglyLinkedList curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        length++;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();

        SinglyLinkedList curr = head;

        while(curr != null){
            sb.append(curr.data + " ");
            curr = curr.next;
        }

        return sb.toString();
    }

}

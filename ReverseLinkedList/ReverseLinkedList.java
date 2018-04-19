package com.androidians.sample;

public class ReverseLinkedList {

    static class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node A = new Node(1);
        A.next = new Node(2);
        A.next.next = new Node(3);
        A.next.next.next = new Node(4);

        A = reverseLinkedList(A);
        System.out.println(A.data);
    }

    static Node reverseLinkedList(Node head) {
        Node current = head;
        Node prev = null, next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }


}

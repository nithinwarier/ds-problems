package com.androidians.sample;

import org.w3c.dom.Node;

import java.util.Set;
import java.util.TreeSet;

public class MergePointTwoLinkedLists {

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

        Node B = new Node(5);
        B.next = new Node(8);
        B.next.next = new Node(10);
        B.next.next.next = new Node(3);
        B.next.next.next.next = new Node(4);

        System.out.println(mergePointTwoLinkedLists(A, B));
    }

    public static int mergePointTwoLinkedLists(Node A, Node B) {
        int n = length(A);
        int m = length(B);

        if (n > m) {
            A = movePointer(A, n-m);
        } else {
            B = movePointer(B, m-n);
        }

        while (A != null && B != null) {
            if (A.data == B.data) {
                return A.data;
            }

            A = A.next;
            B = B.next;
        }

        return -1;
    }

    private static Node movePointer(Node node, int d) {
        for (int i=0;i<d;i++) {
            node = node.next;
        }

        return node;
    }

    private static int length(Node A) {
        Node p = A;
        int count = 0;

        while (p != null) {
            p = p.next;
            count++;
        }

        return count;
    }

    //brute force - compare every node in LList A with LList B
    public static int mergePointTwoLinkedListsBruteForce(Node A, Node B) {
        int n = length(A);
        int m = length(B);
        Node temp = B;

        for (int i=0;i<n; i++) {
            B = temp;
            for (int j=0;j<m;j++) {
                if (A.data == B.data) {
                    return A.data;
                }

                B = B.next;
            }

            A = A.next;
        }

        return -1;
    }

    public static int mergePointTwoLinkedListsImprovedBruteForce(Node A, Node B) {
        int n = length(A);
        int m = length(B);
        Set<Node> nodes = new TreeSet<>();
        for (int i=0;i<m;i++) {
            nodes.add(B);
            B = B.next;
        }

        for (int i=0;i<n; i++) {
            if (nodes.contains(A)) {
                return A.data;
            }

            A = A.next;
        }

        return -1;
    }



}

package com.androidians.linkedlist;

/**
 * Created by nithin on 24/02/18.
 */

public class LinkedList2 {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hi Linkedlist, I am coming to you !!! Let us enjoy");

        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = new Node(4);
        n.next.next.next.next = new Node(5);
        n.next.next.next.next.next = new Node(6);

        System.out.println("countIterative: "+countIterative(n));
        System.out.println("countRecursive: "+countRecursive(n));
        printLastNode(n);
        System.out.println("Print LinkedList Iterative");
        printLinkedList(n);
        System.out.println();
        printLinkedListRecursive(n);
        Node middleNode = findMiddleNode(n);

        System.out.println();
        System.out.println("Middle Node: "+middleNode.data);
        System.out.println("NthFromLastNode: "+nthFromLastNode(n, 2).data);
        reversePrintLinkedListRecursive(n);
        reverseLinkedList(n);
    }

    private static int countIterative(Node head) {
        int count = 0;
        if (head == null) return count;
        Node p = head;
        while (p != null) {
            p = p.next;
            count++;
        }

        return count;
    }

    private static int countRecursive(Node head) {
        if (head == null)
            return 0;
        else {
            return 1 + countRecursive(head.next);
        }
    }

    private static void printLastNode(Node head) {
        if (head == null) return;
        if (head.next == null) {
            System.out.println("LastNode: "+head.data);
            return;
        }
        
        Node fast = head;
        Node slow = head;
        Node mid = head;
        
        // here, we are not travelling the enitr linkedList to find the lastNode
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            mid = fast.next;
            fast = fast.next.next;
        }
        
        if (fast != null) {
            System.out.println("LastNode: " + fast.data);
        } else if (mid != null) {
            System.out.println("LastNode: " + mid.data);
        }
    }

    private static void printLinkedList(Node head) {
        if (head == null)
            return;

        Node p = head;
        while (p != null) {
            System.out.print("\t"+p.data);
            p= p.next;
        }
    }

    private static void printLinkedListRecursive(Node head) {
        if (head == null) {
            return;
        }

        System.out.print("\t"+head.data);
        printLinkedListRecursive(head.next);
    }

    private static void reverseLinkedList(Node head) {
        if (head == null) return;

        Node prevNode = null;
        Node currNode = head;
        Node nextNode = null;

        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        System.out.println("prev node: "+prevNode.data);

        Node p = prevNode;
        while (p != null) {
            System.out.print("\t"+p.data);
            p=p.next;
        }
    }


    private static void reversePrintLinkedListRecursive(Node head) {
        if (head == null) {
            return;
        }
        reversePrintLinkedListRecursive(head.next);
        System.out.print("\t"+head.data);
    }

    private static Node findMiddleNode(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head.next;
        int count = 0;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }

        return slow;
    }

    private static Node nthFromLastNode(Node head, int n) {
        Node firstPtr = head;
        Node secondPtr = head;

        for (int i=0; i<n; i++)
            firstPtr = firstPtr.next;

        while (firstPtr != null) {
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        return secondPtr;
    }
    
    private static void pairwiseSwapToReverse(Node head) {
        if (head == null) return;
        if (head.next == null) return;

        Node p = head;
        while (p != null && p.next != null) {
            int k = p.data;
            p.data = p.next.data;
            p.next.data = k;
            p = p.next.next;
        }

        Node temp = head;
        while (temp != null) {
            System.out.println("\t"+temp.data);
            temp = temp.next;
        }

    }
    
    /**
     * Check whether the linkedList hasp loop through slow & fast pointer
     */
    private static boolean hasLoop(Node head) {
      Node slow, fast; 
      slow = fast = head; 
      while(true) {
        slow = slow.next; 
        if(fast.next != null)
            fast = fast.next.next; 
        else
            return false;  

        if(slow == null || fast == null) 
            return false;

        if(slow == fast) 
            return true;
    }

}

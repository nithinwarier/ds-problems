package com.androidians.sample.trees;

import android.support.annotation.NonNull;

public class LeastCommonAncestor {

    static class BTNode implements Comparable {
        int data;
        BTNode left;
        BTNode right;

        BTNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }

        @Override
        public int compareTo(@NonNull Object o) {
            return 0;
        }
    }

    static BTNode getNewNode(int data) {
        return new BTNode(data);
    }

    static BTNode insert(BTNode root, int data) {
        if (root == null) {
            return getNewNode(data);
        } else if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    static boolean checkIfValueExists(BTNode root, int data) {
        if (root == null)
            return false;
        if (root != null && root.data == data)
            return true;

        boolean left = checkIfValueExists(root.left, data);
        boolean right = checkIfValueExists(root.right, data);

        return left | right;
    }

    static int leastCommonAncestor(BTNode root, int a, int b) {
        if (root == null) {
            return -1;
        }

        boolean node1 = checkIfValueExists(root, a);
        boolean node2 = checkIfValueExists(root, b);

        if (node1 & node2) {
            return getLCA(root, a, b);
        }

        return -1;
    }

    private static int getLCA(BTNode root, int a, int b) {
        if (root == null) {
            return -1;
        }

        if (root.data == a) {
            return a;
        }
        if (root.data == b) {
            return b;
        }

        int left = getLCA(root.left, a, b);
        int right = getLCA(root.right, a, b);


        if (left != -1 && right != -1)
            return root.data;

        if (left != -1)
            return left;

        if (right != -1)
            return right;

        return -1;
    }


    public static void main(String[] args) {
        BTNode root = insert(null, 10);
        insert(root, 5);
        insert(root, 3);
        insert(root, 8);

        insert(root, 22);
        insert(root, 17);
        insert(root, 24);
        // latest addition to tree
        insert(root, 34);

        System.out.println();
        System.out.println(leastCommonAncestor(root, 5, 17));
    }

}

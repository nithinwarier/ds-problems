package com.androidians.sample.trees;

import android.support.annotation.NonNull;

public class PrintAllLeafNodes {

    static class BTNode implements Comparable {
        int data;
        BinaryTree.BTNode left;
        BinaryTree.BTNode right;

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

    static BinaryTree.BTNode getNewNode(int data) {
        return new BinaryTree.BTNode(data);
    }

    static BinaryTree.BTNode insert(BinaryTree.BTNode root, int data) {
        if (root == null) {
            root = getNewNode(data);
            return root;
        } else if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    static void printAllLeafNodes(BinaryTree.BTNode root) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            System.out.print("\t"+root.data);
        }
        printAllLeafNodes(root.left);
        printAllLeafNodes(root.right);
    }


    public static void main(String[] args) {
        BinaryTree.BTNode root = insert(null, 10);
        insert(root, 5);
        insert(root, 3);
        insert(root, 8);

        insert(root, 22);
        insert(root, 17);
        insert(root, 24);

        System.out.println("Print all Leaf Nodes");
        printAllLeafNodes(root);
    }
}

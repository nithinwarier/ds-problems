package com.androidians.sample.trees;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class PrintAllRootToLeafPath {

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

    static void printAllRootToLeafPath(BinaryTree.BTNode root, ArrayList<Integer> path) {
        if (root == null) return;
        path.add(root.data);

        if (root.left == null && root.right == null) {
            for (int i: path) {
                System.out.print("\t"+i);
            }
            System.out.println();
        } else {
            printAllRootToLeafPath(root.left, new ArrayList(path));
            printAllRootToLeafPath(root.right, new ArrayList(path));
        }
    }

    public static void main(String[] args) {
        BinaryTree.BTNode root = insert(null, 10);
        insert(root, 5);
        insert(root, 3);
        insert(root, 8);

        insert(root, 22);
        insert(root, 17);
        insert(root, 24);

        System.out.println("Print all path from root to leaf");
        printAllRootToLeafPath(root, new ArrayList<Integer>());
    }

}

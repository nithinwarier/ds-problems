package com.androidians.sample.trees;

import android.support.annotation.NonNull;

public class MirrorImage {

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

    static BTNode mirrorImage(BTNode root) {
        if (root == null) return root;

        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        BTNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorImage(root.left);
        mirrorImage(root.right);

        return root;
    }

    static void inOrderTraversal(BTNode root) {
        if (root == null) return;

        inOrderTraversal(root.left);
        System.out.print("\t"+root.data);
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        BTNode root = insert(null, 10);
        insert(root, 5);
        insert(root, 3);
        insert(root, 8);

        insert(root, 22);
        insert(root, 17);
        insert(root, 24);

        root = mirrorImage(root);
        inOrderTraversal(root);
    }

}

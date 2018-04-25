package com.androidians.sample.trees;

import android.support.annotation.NonNull;

public class HeightOfTree {

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

    static int heightOfTree(BTNode root) {
        if (root == null) {
            return -1;
        }

        int left = 1 + heightOfTree(root.left);
        int right = 1 + heightOfTree(root.right);

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        BTNode root = insert(null, 10);
        insert(root, 5);
        insert(root, 3);
        insert(root, 8);

        insert(root, 22);
        insert(root, 17);
        insert(root, 24);

        System.out.println(heightOfTree(root));
    }
}

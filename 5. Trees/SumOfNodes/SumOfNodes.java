package com.androidians.sample.trees;

import android.support.annotation.NonNull;

import java.util.PriorityQueue;
import java.util.Queue;

public class SumOfNodes {

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

    static int sumLeft(BinaryTree.BTNode root) {
        if (root == null) return 0;
        return root.data + sumLeft(root.left);
    }

    static int sumRight(BinaryTree.BTNode root) {
        if (root == null) return 0;
        return root.data + sumRight(root.right);
    }

    static int sum(BinaryTree.BTNode root) {
        if (root == null) return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

    static int sumIterative(BinaryTree.BTNode root) {
        int sum = 0;
        if (root == null) return 0;
        else {
            Queue<BinaryTree.BTNode> queue = new PriorityQueue<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                BinaryTree.BTNode temp = queue.poll();
                sum += temp.data;
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        BinaryTree.BTNode root = insert(null, 10);
        insert(root, 5);
        insert(root, 3);
        insert(root, 8);

        insert(root, 22);
        insert(root, 17);
        insert(root, 24);

        System.out.println("Sum left sub tree: "+ sumLeft(root));
        System.out.println("Sum right sub tree: "+ sumRight(root));
        System.out.println("Sum of binary tree: "+ sum(root));
        System.out.println("Sum of binary tree (Iterative): "+ sumIterative(root));
    }

}

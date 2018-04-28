package com.androidians.sample.trees;

import android.support.annotation.NonNull;

public class BinaryTreeTraversal {

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

    static void preOrderTraversal(BinaryTree.BTNode root) {
        if (root == null) return;

        System.out.print("\t"+root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void inOrderTraversal(BinaryTree.BTNode root) {
        if (root == null) return;

        inOrderTraversal(root.left);
        System.out.print("\t"+root.data);
        inOrderTraversal(root.right);
    }
    
    static void inOrderTraversal2(BinaryTree.BTNode root, ArrayList<Integer> data) {
        if (root == null) return;

        inOrderTraversal2(root.left, data);
        data.add(root.data);
        inOrderTraversal2(root.right, data);
    }

    static void postOrderTraversal(BinaryTree.BTNode root) {
        if (root == null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print("\t"+root.data);
    }
    
    static void preOrderTraversalIterative(BinaryTree.BTNode root) {
        if (root == null) return;

        Stack<BinaryTree.BTNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            BinaryTree.BTNode node = stack.peek();
            System.out.println(node.data);
            stack.pop();

            if (node.right != null) {
                stack.add(node.right);
            }

            if (node.left != null) {
                stack.add(node.left);
            }
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

        System.out.println();
        System.out.println("Pre order traversal ");
        preOrderTraversal(root);
        System.out.println();
        System.out.println("In order traversal");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("Post order traversal");
        postOrderTraversal(root);
        System.out.println();
        
        System.out.println("In order traversal MODIFIED");
        ArrayList<Integer> list = new ArrayList<>();
        inOrderTraversal2(root, list);
        for (int i: list) {
            System.out.print("\t"+i);
        }
        
        System.out.println();
        System.out.println("Pre order traversal iterative");
        preOrderTraversalIterative(root);
    }

}

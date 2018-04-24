package com.androidians.sample.trees;

import android.support.annotation.NonNull;
import android.support.v4.view.AsyncLayoutInflater;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class VerticalOrderTraversal {

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

    public static Map<Integer, ArrayList<Integer>> map = new TreeMap<>();;
    static BTNode verticalOrderTraversal(BTNode root, int level) {
        if (root == null) return root;

        BTNode x= verticalOrderTraversal(root.left, --level);
        if (x == null) {
            level++;
        }

        if (map.get(level) != null) {
            ArrayList list = map.get(level);
            list.add(root.data);
            map.put(level, list);
        } else {
            ArrayList list = new ArrayList();
            list.add(root.data);
            map.put(level, list);
        }

        return verticalOrderTraversal(root.right, ++level);
    }


    public static void main(String[] args) {
        BTNode root = insert(null, 10);
        insert(root, 5);
        insert(root, 3);
        insert(root, 8);

        insert(root, 22);
        insert(root, 17);
        insert(root, 24);

        verticalOrderTraversal(root, 0);
        Set<Map.Entry<Integer, ArrayList<Integer>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : entrySet) {
            System.out.print("\t"+(entry.getValue().toString()));
        }
    }

}

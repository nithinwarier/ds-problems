package com.androidians.sample.trees;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PrintVerticalSum {

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

    public static Map<Integer, Integer> map = new TreeMap<>();;
    static BTNode printVerticalSum(BTNode root, int level) {
        if (root == null) {
            return null;
        }

        BTNode x = printVerticalSum(root.left, --level);
        if (x == null) {
            level++;
        }

        if (map.get(level) != null) {
            map.put(level, map.get(level) + root.data);
        } else {
            map.put(level, root.data);
        }

        return printVerticalSum(root.right, ++level);
    }

    public static void main(String[] args) {
        BTNode root = insert(null, 10);
        insert(root, 5);
        insert(root, 3);
        insert(root, 8);

        insert(root, 22);
        insert(root, 17);
        insert(root, 24);

        printVerticalSum(root, 0);

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            System.out.print("\t"+(entry.getValue()));
        }
    }

}

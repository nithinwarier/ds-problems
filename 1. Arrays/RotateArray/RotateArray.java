package com.androidians.linkedlist;

import java.util.ArrayList;

/**
 * Created by nithin on 27/02/18.
 */

public class RotateArray {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        rotateArray(A, 8);
    }

    // rotate left to B positions
    private static void rotateArray(ArrayList<Integer> A, int B) {
        if (B > A.size())
            B = B%A.size();

        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0;i<A.size(); i++) {
            if (B+i >= A.size()) {
                result.add(A.get(i+B - A.size()));
            } else {
                result.add(A.get(i+B));
            }
        }

        for (int i=0;i<result.size();i++) {
            System.out.print("\t"+result.get(i));
        }
    }
    
    private static int[] rotateArrayAlternative(int[] A, int K) {
        if (A == null || A.length == 0) {
            return A;
        }
        
        if (K>A.length)
            K = K%A.length;

        int[] result = new int[A.length];

        for (int i=0;i<K;i++) {
            result[i] = A[A.length-K+i];
        }

        int j=0;
        for(int i=K; i<A.length; i++){
            result[i] = A[j];
            j++;
        }

        return result;
    }

}
